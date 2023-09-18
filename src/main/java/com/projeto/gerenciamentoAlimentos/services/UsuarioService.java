package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.models.UsuarioModel;
import com.projeto.gerenciamentoAlimentos.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public UsuarioModel save(UsuarioModel usuarioModel) {
        return  usuarioRepository.save(usuarioModel);
    }
}