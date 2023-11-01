package com.projeto.gerenciamentoAlimentos.dtos;

import com.projeto.gerenciamentoAlimentos.domain.user.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    public String login;
    public String senha;
    public UserRole role;
}
