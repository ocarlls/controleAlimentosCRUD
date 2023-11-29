package com.projeto.gerenciamentoAlimentos.domain.auth.controllers;

import com.projeto.gerenciamentoAlimentos.domain.auth.repositories.UserRepository;
import com.projeto.gerenciamentoAlimentos.domain.auth.security.TokenService;
import com.projeto.gerenciamentoAlimentos.domain.auth.usuario.AuthenticationDTO;
import com.projeto.gerenciamentoAlimentos.domain.auth.usuario.ModifyDTO;
import com.projeto.gerenciamentoAlimentos.domain.auth.usuario.User;
import com.projeto.gerenciamentoAlimentos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<Response<User>> alterar(
            @RequestBody @Valid User usuario,
            @PathVariable String roleName,
            BindingResult result) {
        Response<User> response = new Response<User>();
        response.setData(usuario);
        if(result.hasErrors()) {
            for (ObjectError erros: result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(usuario);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @RolesAllowed("[ADMIN]")
    public List<User> getAll() {
        List<User> lista = repository.findAll();
        for (User usuario : lista) {
            System.out.println(usuario.getLogin());
        }
        return lista;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable String id) {
        return repository.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        repository
                .findById(id)
                .map( categoria -> {
                    repository.delete(categoria);
                    return Void.TYPE;
                })
                .orElseThrow(  ()-> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }

    @PostMapping("/alterar-senha")
    public ResponseEntity<?> alterarSenha(@RequestBody @Valid ModifyDTO modifyDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            modifyDTO.getLogin(), modifyDTO.getPassword())
            );
            User usuario = (User) authentication.getPrincipal();
            usuario.setPassword(passwordEncoder.encode(modifyDTO.getNewPassword()));
            usuario.setLogin(modifyDTO.getNewLogin());
            usuario = repository.save(usuario);
            return ResponseEntity.ok().body(usuario);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
