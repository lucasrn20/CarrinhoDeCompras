package br.com.carrinhodecompras.dao;

import br.com.carrinhodecompras.domain.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    
    private List<Produto> listaprodutos = new ArrayList<Produto>() {};

    public List<Produto> listar(){

        try{
            return listaprodutos;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public Produto consultar(Integer id){

        try{
            for (int i = 0; i < listaprodutos.size(); i++) {
                if (listaprodutos.get(i).getId().equals(id))
                    return listaprodutos.get(i); 
            } 
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean inserir(Produto produto){
        try{
            listaprodutos.add(produto);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }    
    
     public boolean alterar(Produto produto){

        try{
            for (int i = 0; i < listaprodutos.size(); i++) {
                if (listaprodutos.get(i).getId().equals(produto.getId())) {
                    listaprodutos.get(i).setDescricao(produto.getDescricao());
                    listaprodutos.get(i).setEstoque(produto.getEstoque());
                    listaprodutos.get(i).setPreco(produto.getPreco());
                }
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }    
     
      public boolean excluir(Produto produto){

        try{
            listaprodutos.remove(produto);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }    
    
}
