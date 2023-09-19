package com.projeto.gerenciamentoAlimentos.controllers;

import com.projeto.gerenciamentoAlimentos.dtos.AlimentoDTO;
import com.projeto.gerenciamentoAlimentos.dtos.UsuarioDTO;
import com.projeto.gerenciamentoAlimentos.models.AlimentoModel;
import com.projeto.gerenciamentoAlimentos.models.UsuarioModel;
import com.projeto.gerenciamentoAlimentos.services.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("comida")
public class AlimentoController {
    @Autowired
    AlimentoService alimentoService;

    @PostMapping("novo")
    public ResponseEntity<Object> iserirComida(@RequestBody @Valid AlimentoDTO alimentoDTO){
        var alimentoModel = new AlimentoModel(alimentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(alimentoService.save(alimentoModel));
    }

    @GetMapping("todos")
    public ResponseEntity<List<AlimentoModel>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(alimentoService.getAll());
    }
}
