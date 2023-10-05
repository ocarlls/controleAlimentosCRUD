package com.projeto.gerenciamentoAlimentos.controllers;

import com.projeto.gerenciamentoAlimentos.dtos.UsuarioDTO;
import com.projeto.gerenciamentoAlimentos.models.Usuario;
import com.projeto.gerenciamentoAlimentos.services.UsuarioService;
import com.projeto.gerenciamentoAlimentos.services.impl.UsuarioServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    UsuarioServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> iserirUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var usuarioModel = new Usuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioModel));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listaUmUsuario(@PathVariable(value = "id") int id) {
        Optional<Usuario> usuarioModelOptional = service.getById(id);
        if(!usuarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado na base de dados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable(value = "id") int id){
        Optional<Usuario> usuarioModelOptional = service.getById(id);
        if (!usuarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado na base de dados");
        }
        service.delete(usuarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarUsuario(@PathVariable(value = "id") int id,
                                                @RequestBody @Valid UsuarioDTO usuarioDTO){
        Optional<Usuario> usuarioModelOptional = service.getById(id);
        if (!usuarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado na base de dados");
        }
        var usuarioModel = new Usuario();
        BeanUtils.copyProperties(usuarioDTO, usuarioModel);
        usuarioModel.setId_usuario(usuarioModelOptional.get().getId_usuario());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(usuarioModel));
    }
}