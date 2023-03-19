package com.f3pro.backend.service;

import com.f3pro.backend.entity.Pessoa;
import com.f3pro.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa objeto) {
        objeto.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(objeto);
        return pessoaNovo;

    }

    public Pessoa alterar(Pessoa objeto) {
        objeto.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(objeto);

    }

    public void excluir(Long id) {
        Pessoa objeto =pessoaRepository.findById(id).get();
        pessoaRepository.delete(objeto);

    }

}
