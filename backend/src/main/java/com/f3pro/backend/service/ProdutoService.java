package com.f3pro.backend.service;

import com.f3pro.backend.entity.Produto;
import com.f3pro.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto produto) {
        produto.setDataCriacao(new Date());
        return produtoRepository.saveAndFlush(produto);
    }

    public Produto alterar(Produto produto) {
        produto.setDataCriacao(new Date());
       return produtoRepository.saveAndFlush(produto);
        
    }

    public void excluir(Long id) {
        Produto marca = produtoRepository.findById(id).get();
        produtoRepository.delete(marca);
    }

}
