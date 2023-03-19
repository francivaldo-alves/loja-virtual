package com.f3pro.backend.service;

import com.f3pro.backend.entity.Categoria;

import com.f3pro.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria) {
        categoria.setDataCriacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public Categoria alterar(Categoria categoria) {
        categoria.setDataAlreracao(new Date());
       return categoriaRepository.saveAndFlush(categoria);
        
    }

    public void excluir(Long id) {
        Categoria marca = categoriaRepository.findById(id).get();
        categoriaRepository.delete(marca);
    }

}
