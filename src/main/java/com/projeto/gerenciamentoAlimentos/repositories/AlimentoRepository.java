package com.projeto.gerenciamentoAlimentos.repositories;

import com.projeto.gerenciamentoAlimentos.domain.food.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {
    @Query("SELECT nome FROM Alimentos where nome like %:keyword%")
    List<String> search(@Param("keyword") String keyword);
}
