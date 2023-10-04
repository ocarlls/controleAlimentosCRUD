package com.projeto.gerenciamentoAlimentos.controllers;

import com.projeto.gerenciamentoAlimentos.dtos.AlimentoDTO;
import com.projeto.gerenciamentoAlimentos.dtos.UsuarioDTO;
import com.projeto.gerenciamentoAlimentos.models.AlimentoModel;
import com.projeto.gerenciamentoAlimentos.models.UsuarioModel;
import com.projeto.gerenciamentoAlimentos.services.AlimentoService;
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
    @GetMapping("busca/{id}")
    public ResponseEntity<Object> listaUmAlimento(@PathVariable(value = "id") int id) {
        Optional<AlimentoModel> alimentoModelOptional = alimentoService.buscaId(id);
        if(!alimentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alimento não encontrado na base de dados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alimentoModelOptional);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deletaAlimento(@PathVariable(value = "id") int id) {
        Optional<AlimentoModel> alimentoModelOptional = alimentoService.buscaId(id);
        if(!alimentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alimento não encontrado na base de dados");
        }
        alimentoService.delete(alimentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Alimento deletado com sucesso!!");
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Object> editarAlimento(@PathVariable(value = "id") int id,
                                                @RequestBody @Valid AlimentoDTO alimentoDTO){
        Optional<AlimentoModel> alimentoModelOptional = alimentoService.buscaId(id);
        if(!alimentoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alimento não encontrado na base de dados");
        }
        var alimentoModel = new AlimentoModel();

        BeanUtils.copyProperties(alimentoDTO, alimentoModel);
        alimentoModel.setIdAlimento(alimentoModelOptional.get().getIdAlimento());
        return ResponseEntity.status(HttpStatus.OK).body(alimentoService.save(alimentoModel));
    }

}
