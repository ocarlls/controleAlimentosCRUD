package com.projeto.gerenciamentoAlimentos.controllers;

import com.projeto.gerenciamentoAlimentos.dtos.UsuarioDTO;
import com.projeto.gerenciamentoAlimentos.models.UsuarioModel;
import com.projeto.gerenciamentoAlimentos.services.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("novo")
    public ResponseEntity<Object> iserirUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var usuarioModel = new UsuarioModel(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioModel));
    }

    @GetMapping("todos")
    public ResponseEntity<List<UsuarioModel>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAll());
    }

    @GetMapping("busca/{id}")
    public ResponseEntity<Object> listaUmUsuario(@PathVariable(value = "id") int id) {
        Optional<UsuarioModel> usuarioModelOptional = usuarioService.buscaId(id);
        if(!usuarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado na base de dados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional);
    }

//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<Object> deletarUsuario(@PathVariable(value = "id") int id){
//        Optional<UsuarioModel> usuarioModelOptional = usuarioService.buscaId(id);
//        usuarioService.buscaId(id);
//    }
}