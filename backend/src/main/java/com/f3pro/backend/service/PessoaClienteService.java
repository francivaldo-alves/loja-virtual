package com.f3pro.backend.service;

import com.f3pro.backend.dto.PessoaClienteRequestDTO;
import com.f3pro.backend.entity.Pessoa;
import com.f3pro.backend.entity.mail.EnviarEmail;
import com.f3pro.backend.repository.PermissaoRepository;
import com.f3pro.backend.repository.PessoaClienteRepository;
import com.f3pro.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;

    String mensagem="Cadastro realizado com sucesso. Em breve você receberá a senha de acesso através do e-mail cadastrado, " +
            " acesse o link https://github.com/francivaldo-alves/loja-virtual!! ";

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa objetoNovo = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(objetoNovo);
        emailService.envioEmailTexto(objetoNovo.getEmail(),"Teste de Envido de Email ", mensagem);

        return objetoNovo;

    }


}
