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
    private String categoria;
    private float calorias;
    private float proteina;
    private float carboidratos;
    private float gordura;

    public Alimento(AlimentoDTO alimentoDTO) {
        this.nome = alimentoDTO.getNome();
        this.categoria = alimentoDTO.getCategoria();
        this.carboidratos = alimentoDTO.getCarboidratos();
        this.proteina = alimentoDTO.getProteina();
        this.gordura = alimentoDTO.getGordura();
        this.calorias = alimentoDTO.getCalorias();
    }
}