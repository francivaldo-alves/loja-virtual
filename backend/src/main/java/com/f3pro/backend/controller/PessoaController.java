package com.f3pro.backend.controller;

import com.f3pro.backend.entity.Pessoa;
import com.f3pro.backend.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> buscarTodos() {
        return pessoaService.buscarTodos();

    }

    @PostMapping("/inserir")
    public Pessoa inserir(@Valid @RequestBody Pessoa objeto) {
        return pessoaService.inserir(objeto);

    }

    @PutMapping("/alerar")
    public Pessoa alterar(@Valid @RequestBody Pessoa objeto) {
        return pessoaService.alterar(objeto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();

    }

}
