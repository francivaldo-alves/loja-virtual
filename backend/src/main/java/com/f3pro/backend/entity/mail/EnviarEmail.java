package com.f3pro.backend.entity.mail;

import lombok.Data;

@Data
public class EnviarEmail {
    private String destinatario;
    private String titulo;
    private String mensagem;

}
