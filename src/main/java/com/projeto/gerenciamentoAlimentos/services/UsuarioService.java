package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.domain.user.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UsuarioService {
    public Usuario save(Usuario usuario);
    public List<Usuario> getAll();
    public Optional<Usuario> getById(UUID id);
    public void delete(Usuario usuario);
}