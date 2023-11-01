package com.projeto.gerenciamentoAlimentos.repositories;

import com.projeto.gerenciamentoAlimentos.domain.food.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {
}
