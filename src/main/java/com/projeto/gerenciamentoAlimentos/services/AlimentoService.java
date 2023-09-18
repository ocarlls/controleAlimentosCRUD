package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.repositories.AlimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlimentoService {
    final AlimentoRepository alimentoRepository;
    public AlimentoService(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }
}
