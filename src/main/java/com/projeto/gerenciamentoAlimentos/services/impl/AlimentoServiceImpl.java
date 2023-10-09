package com.projeto.gerenciamentoAlimentos.services.impl;

import com.projeto.gerenciamentoAlimentos.models.Alimento;
import com.projeto.gerenciamentoAlimentos.repositories.AlimentoRepository;
import com.projeto.gerenciamentoAlimentos.services.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AlimentoServiceImpl implements AlimentoService {
    @Autowired
    AlimentoRepository repository;
    @Override
    public Alimento save(Alimento alimento) {
        return repository.save(alimento);
    }

    @Override
    public List<Alimento> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Alimento> getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Alimento alimento) {
        repository.delete(alimento);
    }

}
