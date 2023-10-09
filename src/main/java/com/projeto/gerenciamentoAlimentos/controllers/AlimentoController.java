package com.projeto.gerenciamentoAlimentos.controllers;

import com.projeto.gerenciamentoAlimentos.dtos.AlimentoDTO;
import com.projeto.gerenciamentoAlimentos.models.Alimento;
import com.projeto.gerenciamentoAlimentos.models.Macronutrientes;
import com.projeto.gerenciamentoAlimentos.services.AlimentoService;
import com.projeto.gerenciamentoAlimentos.services.impl.AlimentoServiceImpl;
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
@RequestMapping("comida")
public class AlimentoController {
    @Autowired
    AlimentoServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> iserirComida(@RequestBody @Valid AlimentoDTO alimentoDTO){
        var alimentoModel = new Alimento(alimentoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alimentoModel));
    }

    @GetMapping
    public ResponseEntity<List<Alimento>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> listaUmAlimento(@PathVariable(value = "id") int id) {
        Optional<Alimento> alimentoModelOptional = service.getById(id);
        if(!alimentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alimento não encontrado na base de dados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alimentoModelOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaAlimento(@PathVariable(value = "id") int id) {
        Optional<Alimento> alimentoModelOptional = service.getById(id);
        if(!alimentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alimento não encontrado na base de dados");
        }
        service.delete(alimentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Alimento deletado com sucesso!!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarAlimento(@PathVariable(value = "id") int id,
                                                @RequestBody @Valid AlimentoDTO alimentoDTO){
        Optional<Alimento> alimentoModelOptional = service.getById(id);
        if(!alimentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alimento não encontrado na base de dados");
        }
        var alimentoModel = new Alimento();

        BeanUtils.copyProperties(alimentoDTO, alimentoModel);
        alimentoModel.setIdAlimento(alimentoModelOptional.get().getIdAlimento());
        return ResponseEntity.status(HttpStatus.OK).body(service.save(alimentoModel));
    }

}
