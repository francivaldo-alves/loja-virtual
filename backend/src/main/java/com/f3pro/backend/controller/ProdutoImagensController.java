package com.f3pro.backend.controller;

import com.f3pro.backend.entity.ProdutoImagens;
import com.f3pro.backend.service.ProdutoImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService produtoImagensService;

    @GetMapping("/")
    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensService.buscarTodos();
    }

    @PostMapping("/inserir")
    public ProdutoImagens inserir(@RequestParam("idProduto") Long idProduto, @RequestParam("file") MultipartFile file){
        return produtoImagensService.inserir(idProduto,file);
    }

    @PutMapping("/alterar")
    public ProdutoImagens alterar(@RequestBody ProdutoImagens produtoImagens) {
        return produtoImagensService.alterar(produtoImagens);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoImagensService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
