package com.f3pro.backend.dto;

import com.f3pro.backend.entity.Cidade;
import com.f3pro.backend.entity.Pessoa;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;

@Data
public class PessoaClienteRequestDTO {

    private String nome;
    @CPF
    private String cpf;
    @Email
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;


    public Pessoa converter(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequestDTO,pessoa);

        return pessoa;
    }
}
