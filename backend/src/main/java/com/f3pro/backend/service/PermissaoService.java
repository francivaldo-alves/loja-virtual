package com.f3pro.backend.service;

import com.f3pro.backend.entity.Permissao;
import com.f3pro.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTodos() {
        return permissaoRepository.findAll();
    }

    public Permissao inserir(Permissao permissao) {
        permissao.setDataCriacao(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public Permissao alterar(Permissao permissao) {
        permissao.setDataAlreracao(new Date());
       return permissaoRepository.saveAndFlush(permissao);
        
    }

    public void excluir(Long id) {
        Permissao marca = permissaoRepository.findById(id).get();
        permissaoRepository.delete(marca);
    }

}
