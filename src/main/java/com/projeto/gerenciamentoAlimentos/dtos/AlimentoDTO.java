package com.projeto.gerenciamentoAlimentos.dtos;

import com.projeto.gerenciamentoAlimentos.models.Macronutrientes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlimentoDTO {
    private String nome;
    private Macronutrientes macronutrientes;
}

