package com.projeto.gerenciamentoAlimentos.models;

import javax.persistence.*;

import com.projeto.gerenciamentoAlimentos.dtos.AlimentoDTO;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbFoods")
public class Alimento implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlimento;
    private String nome;
    private Macronutrientes macronutrientes;

    public Alimento(AlimentoDTO alimentoDTO) {
        this.setNome(alimentoDTO.getNome());
    }
}