package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.models.Alimento;
import com.projeto.gerenciamentoAlimentos.models.Usuario;
import com.projeto.gerenciamentoAlimentos.repositories.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public interface AlimentoService {
    public Alimento save(Alimento alimento);
    public List<Alimento> getAll();
    public Optional<Alimento> getById(int id);
    public void delete(Alimento alimento);
}
