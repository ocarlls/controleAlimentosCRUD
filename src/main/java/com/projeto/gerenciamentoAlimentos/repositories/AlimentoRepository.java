package com.projeto.gerenciamentoAlimentos.repositories;

import com.projeto.gerenciamentoAlimentos.models.AlimentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<AlimentoModel, Integer> {
}
