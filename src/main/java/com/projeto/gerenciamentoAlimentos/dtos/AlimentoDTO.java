package com.projeto.gerenciamentoAlimentos.dtos;

import com.projeto.gerenciamentoAlimentos.domain.food.Macronutrientes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;

@Getter
@Setter
public class AlimentoDTO {
    private String nome;
    private String marca;
    private float porcao;
    @Embedded
    private Macronutrientes macronutrientes;
}

