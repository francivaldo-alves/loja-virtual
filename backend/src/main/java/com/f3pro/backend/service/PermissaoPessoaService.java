package com.f3pro.backend.service;

import com.f3pro.backend.entity.Permissao;
import com.f3pro.backend.entity.PermissaoPessoa;
import com.f3pro.backend.entity.Pessoa;
import com.f3pro.backend.repository.PermissaoPessoaRepository;
import com.f3pro.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");
        if (listaPermissao.size() > 0) {
            var permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);

        }
    }


}
