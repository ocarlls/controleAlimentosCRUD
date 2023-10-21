package com.projeto.gerenciamentoAlimentos.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbRefeicoes")
public class Refeicao {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @ManyToMany
    private List<Alimento> alimentos;
    @Embedded
    private Macronutrientes macronutrientesTotais;
}
