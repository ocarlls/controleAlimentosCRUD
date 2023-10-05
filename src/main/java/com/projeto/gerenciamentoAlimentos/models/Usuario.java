package com.projeto.gerenciamentoAlimentos.models;

import com.projeto.gerenciamentoAlimentos.dtos.UsuarioDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbUsuarios")
public class Usuario implements Serializable {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String nome;
    private String email;

    public Usuario(UsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
    }
}
