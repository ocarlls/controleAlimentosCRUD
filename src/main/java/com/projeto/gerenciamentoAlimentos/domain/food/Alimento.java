package com.projeto.gerenciamentoAlimentos.domain.food;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.gerenciamentoAlimentos.dtos.AlimentoDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "alimentos")
public class Alimento implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlimento;
    private float porcao;
    private String nome;
    private String marca;
    @JsonProperty("macronutrientes")
    @Embedded
    private Macronutrientes macronutrientes;


    public Alimento(AlimentoDTO alimentoDTO) {
        this.setNome(upperCase(alimentoDTO.getNome()));
        this.setMarca(upperCase(alimentoDTO.getMarca()));
        this.setPorcao(alimentoDTO.getPorcao());
        this.macronutrientes = alimentoDTO.getMacronutrientes();
    }

    private static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }
}