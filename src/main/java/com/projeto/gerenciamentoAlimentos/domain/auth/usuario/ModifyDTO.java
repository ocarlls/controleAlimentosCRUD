package com.projeto.gerenciamentoAlimentos.domain.auth.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModifyDTO{
    private String login;
    private String password;
    private String newLogin;
    private String newPassword;
}

