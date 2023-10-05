package com.projeto.gerenciamentoAlimentos.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlimentoDTO {
    @NotBlank
    private String nome;
    private String categoria;
    @NotNull
    private int calorias;
    private float proteina;
    private float carboidratos;
    private float gordura;
}

