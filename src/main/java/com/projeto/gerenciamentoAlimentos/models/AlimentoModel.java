package com.projeto.gerenciamentoAlimentos.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "tb-foods")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_alimento")
public class AlimentoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_alimento;
    private String nome;
    private String categoria;
    private int calorias;
    private double proteina;
    private double carboidratos;
    private double gordura;
}