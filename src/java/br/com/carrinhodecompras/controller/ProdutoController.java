package br.com.carrinhodecompras.controller;

import br.com.carrinhodecompras.domain.Produto;
import br.com.carrinhodecompras.service.ProdutoService;
import br.com.carrinhodecompras.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="produtoMB")
@SessionScoped
public class ProdutoController implements Serializable{
    
    private Produto produto = new Produto();
    private List<Produto> produtos;
    private ProdutoService produtoService = new ProdutoService();
    
    public ProdutoController(){
        listar();
    }
    
    public void listar(){
        produtos = produtoService.listar();
    }
    
    public String novo(){
        produto = new Produto();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(Produto produto){
        this.produto = produto;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        if(produtoService.inserir(produto)){
            UtilMensagens.mensagemSucesso("Sucesso", "Produto salvo com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o produto!");
        return null;
    }
    
    public String alterar(){
        if(produtoService.alterar(produto)){
            UtilMensagens.mensagemSucesso("Sucesso", "Produto alterado com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o produto!");
        return null;
    }
    
    public String excluir(Produto produto){
        if(produtoService.excluir(produto)){
            UtilMensagens.mensagemSucesso("Sucesso", "Produto excluido com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true"; 
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o produto!");
        return null;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
