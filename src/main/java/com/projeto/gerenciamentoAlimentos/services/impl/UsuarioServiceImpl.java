package com.projeto.gerenciamentoAlimentos.services.impl;
import com.projeto.gerenciamentoAlimentos.domain.user.Usuario;
import com.projeto.gerenciamentoAlimentos.repositories.UsuarioRepository;
import com.projeto.gerenciamentoAlimentos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repository;
    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Usuario usuario) {
        repository.delete(usuario);
    }
}
