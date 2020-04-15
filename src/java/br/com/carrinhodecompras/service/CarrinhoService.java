package br.com.carrinhodecompras.service;

import br.com.carrinhodecompras.dao.CarrinhoDao;
import br.com.carrinhodecompras.domain.Carrinho;
import java.util.List;

public class CarrinhoService {
    private CarrinhoDao carrinhoDao = new CarrinhoDao();
    
    public Double fechar(){
        return carrinhoDao.fechar();
    }
    
    public List<Carrinho> listar(){
        return carrinhoDao.listar();
    }

    public boolean inserir(Carrinho carrinho){
        return carrinhoDao.inserir(carrinho);
    }

    public boolean excluir(Carrinho carrinho){
        return carrinhoDao.excluir(carrinho);
    }
}
