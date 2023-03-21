package com.f3pro.backend.controller;

import com.f3pro.backend.entity.Pessoa;
import com.f3pro.backend.service.PessoaGerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pessoa-gerenciamento")
public class PessoaGerenciamentoController {

    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("/senha-codigo")
    public String recuperarCodigo(@RequestBody Pessoa pessoa){
        return pessoaGerenciamentoService.solicitarCodigo(pessoa.getEmail());

    }

    @PostMapping("/senha-alterar")
    public String alterarSenha(@RequestBody Pessoa  pessoa){
        return pessoaGerenciamentoService.alterarSenha(pessoa);

    }



}
