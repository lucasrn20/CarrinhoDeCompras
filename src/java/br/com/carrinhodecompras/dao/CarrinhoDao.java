package br.com.carrinhodecompras.dao;

import br.com.carrinhodecompras.domain.Carrinho;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDao {
    
    
    private List<Carrinho> listacarrinho = new ArrayList<Carrinho>();

    public List<Carrinho> listar(){
        try{
            return listacarrinho;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean inserir(Carrinho carrinho){
        try{
            listacarrinho.add(carrinho);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }    

      public boolean excluir(Carrinho carrinho){
        try{
            listacarrinho.remove(carrinho);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }    

    public Double fechar() {
        Double total = 0.0;
        for(int x = 0; x < listacarrinho.size(); x++){
            total += (listacarrinho.get(x).getProduto().getPreco() * listacarrinho.get(x).getQtdeProduto()) ;
        }
        listacarrinho.clear();
        return total;
    }
    
}
