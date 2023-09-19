package com.projeto.gerenciamentoAlimentos.models;

import javax.persistence.*;

import com.projeto.gerenciamentoAlimentos.dtos.AlimentoDTO;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tbFoods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idAlimento")
public class AlimentoModel implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlimento;
    private String nome;
    private String categoria;
    private int calorias;
    private double proteina;
    private double carboidratos;
    private double gordura;

    public AlimentoModel(AlimentoDTO alimentoDTO) {
        this.nome = alimentoDTO.getNome();
        this.categoria = alimentoDTO.getCategoria();
        this.carboidratos = alimentoDTO.getCarboidratos();
        this.proteina = alimentoDTO.getProteina();
        this.gordura = alimentoDTO.getGordura();
        this.calorias = alimentoDTO.getCalorias();
    }
}