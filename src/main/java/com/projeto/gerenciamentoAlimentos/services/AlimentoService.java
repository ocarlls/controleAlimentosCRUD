package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.models.AlimentoModel;
import com.projeto.gerenciamentoAlimentos.repositories.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService {
    @Autowired
    AlimentoRepository alimentoRepository;
    public AlimentoService(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }

    public AlimentoModel save(AlimentoModel alimentoModel) {
        return alimentoRepository.save(alimentoModel);
    }

    public List<AlimentoModel> getAll() {
        return alimentoRepository.findAll();
    }
}
