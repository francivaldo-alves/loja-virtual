package com.f3pro.backend.service;

import com.f3pro.backend.entity.Produto;
import com.f3pro.backend.entity.ProdutoImagens;
import com.f3pro.backend.repository.ProdutoImagensRepository;
import com.f3pro.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos() {
        return produtoImagensRepository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens objeto = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("/home/f3pro/workspaces/repo-java/loja-virtual/imagens/" +nomeImagem );
                Files.write(caminho, bytes);
                objeto.setNome(nomeImagem);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        objeto.setProduto(produto);
        objeto.setDataCriacao(new Date());
        objeto = produtoImagensRepository.saveAndFlush(objeto);
        return objeto;
    }

    public ProdutoImagens alterar(ProdutoImagens produtoImagens) {
        produtoImagens.setDataAlreracao(new Date());
        return produtoImagensRepository.saveAndFlush(produtoImagens);

    }

    public void excluir(Long id) {
        ProdutoImagens marca = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(marca);
    }

}
