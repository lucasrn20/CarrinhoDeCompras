package br.com.carrinhodecompras.controller;


import br.com.carrinhodecompras.domain.Carrinho;
import br.com.carrinhodecompras.service.CarrinhoService;
import br.com.carrinhodecompras.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="carrinhoMB")
@SessionScoped
public class CarrinhoController implements Serializable{
    
    private Carrinho carrinho = new Carrinho();
    private List<Carrinho> itens;
    private CarrinhoService carrinhoService = new CarrinhoService();
    private Double fechamento;
    private String formaPg;
    
    public CarrinhoController(){
        listar();
    }
    
    public void listar(){
        itens = carrinhoService.listar();
    }
    
    public String novo(){
        carrinho = new Carrinho();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        formaPg = "";
        return "list.xhtml?faces-redirect=true";
    }
    
    public String adicionar(){
        if(carrinhoService.inserir(carrinho)){
            UtilMensagens.mensagemSucesso("Sucesso", "Produto adicionado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao adicionar o produto!");
        return null;
    }
    
    public String remover(Carrinho carrinho){
        if(carrinhoService.excluir(carrinho)){
            UtilMensagens.mensagemSucesso("Sucesso", "Produto removido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao remover o produto!");
        return null;
    }
    
    public String fechar(){
        fechamento = carrinhoService.fechar();
        return "pagamento.xhtml?faces-redirect=true";
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public List<Carrinho> getItens() {
        return itens;
    }

    public void setItens(List<Carrinho> itens) {
        this.itens = itens;
    }

    public Double getFechamento() {
        return fechamento;
    }

    public void setFechamento(Double fechamento) {
        this.fechamento = fechamento;
    }

    public String getFormaPg() {
        return formaPg;
    }

    public void setFormaPg(String formaPg) {
        this.formaPg = formaPg;
    }
    
    
}
