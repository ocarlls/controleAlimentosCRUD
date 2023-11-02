package com.projeto.gerenciamentoAlimentos.domain.auth.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO{
    private String login;
    private String password;
}
