package com.projeto.gerenciamentoAlimentos.controllers;

import com.projeto.gerenciamentoAlimentos.dtos.AlimentoDTO;
import com.projeto.gerenciamentoAlimentos.models.Alimento;
import com.projeto.gerenciamentoAlimentos.models.Macronutrientes;
import com.projeto.gerenciamentoAlimentos.response.Response;
import com.projeto.gerenciamentoAlimentos.services.AlimentoService;
import com.projeto.gerenciamentoAlimentos.services.impl.AlimentoServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("comida")
public class AlimentoController {
    @Autowired
    AlimentoServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Alimento>> post(@Valid @RequestBody Alimento alimento, BindingResult result) {
        return service.save(alimento, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Alimento> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Alimento>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Alimento>> put(@Valid @RequestBody Alimento alimento, BindingResult result) {
        return service.save(alimento, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Alimento>> delete(@PathVariable Integer id) {
        return service.delete(id);
    }

}
