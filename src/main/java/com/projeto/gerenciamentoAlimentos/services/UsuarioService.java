package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.models.UsuarioModel;
import com.projeto.gerenciamentoAlimentos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Transactional
    public UsuarioModel save(UsuarioModel usuarioModel) {
        return  usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> getAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscaId(int id) {
        return usuarioRepository.findById(id);
    }
}