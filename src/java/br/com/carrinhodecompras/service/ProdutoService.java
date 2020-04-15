package br.com.carrinhodecompras.service;

import br.com.carrinhodecompras.dao.ProdutoDao;
import br.com.carrinhodecompras.domain.Produto;
import java.util.List;


public class ProdutoService {
    private ProdutoDao produtoDao = new ProdutoDao();
    
    public List<Produto> listar(){
        return produtoDao.listar();
    }
    
    public Produto consultar(Integer id){
        return produtoDao.consultar(id);
    }
    
    public boolean inserir(Produto produto){
        return produtoDao.inserir(produto);
    }
    
    public boolean alterar(Produto produto){
        return produtoDao.alterar(produto);
    }
    
    public boolean excluir(Produto produto){
        return produtoDao.excluir(produto);
    }

}
