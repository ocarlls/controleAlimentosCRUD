package com.projeto.gerenciamentoAlimentos.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb-usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_usuario")
public class UsuarioModel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String nome;
    private String email;
}
