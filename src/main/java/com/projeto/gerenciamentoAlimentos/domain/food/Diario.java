package com.projeto.gerenciamentoAlimentos.domain.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "diario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diario {
    @Id@GeneratedValue
    private UUID id;
    private Date data;
    @ManyToMany
    private List<Refeicao> refeicoes;

}
