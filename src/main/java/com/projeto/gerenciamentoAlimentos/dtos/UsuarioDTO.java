package com.projeto.gerenciamentoAlimentos.dtos;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO{
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
}
