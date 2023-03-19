package com.f3pro.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f3pro.backend.entity.Marca;
import com.f3pro.backend.repository.MarcaRespository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRespository marcaRespository;

    public List<Marca> buscarTodos() {
        return marcaRespository.findAll();
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        Marca novaMarca = marcaRespository.saveAndFlush(marca);
        return novaMarca;
    }

    public Marca alterar(Marca marca) {
        marca.setDataAtualizacao(new Date());
       return marcaRespository.saveAndFlush(marca);
        
    }

    public void excluir(Long id) {
        Marca marca = marcaRespository.findById(id).get();
        marcaRespository.delete(marca);
    }

}
