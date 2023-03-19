package com.f3pro.backend.controller;

import com.f3pro.backend.entity.Cidade;
import com.f3pro.backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/")
    public List<Cidade> buscarTodos() {
        return cidadeService.buscarTodos();

    }

    @PostMapping("/inserir")
    public Cidade inserir(@RequestBody Cidade objeto) {
        return cidadeService.inserir(objeto);

    }

    @PutMapping("/alerar")
    public Cidade alterar(@RequestBody Cidade objeto) {
        return cidadeService.alterar(objeto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        cidadeService.excluir(id);
        return ResponseEntity.ok().build();

    }

}
