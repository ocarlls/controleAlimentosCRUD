package com.projeto.gerenciamentoAlimentos.security;

import com.projeto.gerenciamentoAlimentos.domain.user.Usuario;
import com.projeto.gerenciamentoAlimentos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(username).orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado com login: " + username));
        return new User(usuario.getLogin(), usuario.getSenha(), true, true, true, true, usuario.getAuthorities());
    }
}
