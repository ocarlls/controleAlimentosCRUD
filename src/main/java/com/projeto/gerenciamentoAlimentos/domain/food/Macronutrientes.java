package com.projeto.gerenciamentoAlimentos.domain.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Macronutrientes {
    private float kcal;
    private float proteina;
    private float carboidrato;
    private float gordura;

}
