package com.projeto.gerenciamentoAlimentos.domain.auth.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO{
        private String login;
        private String password;
        private UserRole role;
        private int idade;
        private float peso;
        private float altura;
}
