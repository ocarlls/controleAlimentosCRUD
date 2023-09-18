package com.projeto.gerenciamentoAlimentos.repositories;

import com.projeto.gerenciamentoAlimentos.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
}
