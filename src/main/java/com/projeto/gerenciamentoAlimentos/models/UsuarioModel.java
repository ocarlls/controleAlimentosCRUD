package com.projeto.gerenciamentoAlimentos.models;

import com.projeto.gerenciamentoAlimentos.dtos.UsuarioDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbUsuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String nome;
    private String email;

    public UsuarioModel(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
    }
}
