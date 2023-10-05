package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {
    public Usuario save(Usuario usuario);
    public List<Usuario> getAll();
    public Optional<Usuario> getById(int id);
    public void delete(Usuario usuario);
}