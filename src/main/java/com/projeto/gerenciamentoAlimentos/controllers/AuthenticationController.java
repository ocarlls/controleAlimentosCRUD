package com.projeto.gerenciamentoAlimentos.controllers;

import com.projeto.gerenciamentoAlimentos.domain.user.Usuario;
import com.projeto.gerenciamentoAlimentos.dtos.AuthenticationDTO;
import com.projeto.gerenciamentoAlimentos.dtos.RegisterDTO;
import com.projeto.gerenciamentoAlimentos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().build();
    }



    @PostMapping("/{roleName}")
    public ResponseEntity cadastrar(@RequestBody @Valid RegisterDTO data){
        Optional<Usuario> obj = repository.findByLogin(data.getLogin());
        if (!Objects.equals(obj, Optional.empty())) return ResponseEntity.badRequest().body("Usuário já existe");
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getSenha());
        Usuario novoUsuario = new Usuario(data.getLogin(), encryptedPassword, data.getRole());
        this.repository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }


}
