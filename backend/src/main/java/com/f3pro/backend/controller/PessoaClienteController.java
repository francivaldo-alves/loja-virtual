package com.f3pro.backend.controller;

import com.f3pro.backend.dto.PessoaClienteRequestDTO;
import com.f3pro.backend.entity.Pessoa;
import com.f3pro.backend.service.PessoaClienteService;
import com.f3pro.backend.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaClienteService;


    @PostMapping("/inserir")
    public Pessoa inserir(@Valid @RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        return pessoaClienteService.registrar(pessoaClienteRequestDTO);

    }



}
