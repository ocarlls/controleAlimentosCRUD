package com.projeto.gerenciamentoAlimentos.services.impl;

import com.projeto.gerenciamentoAlimentos.domain.food.Alimento;
import com.projeto.gerenciamentoAlimentos.repositories.AlimentoRepository;
import com.projeto.gerenciamentoAlimentos.response.Response;
import com.projeto.gerenciamentoAlimentos.services.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.Valid;
import java.util.List;

@Component
public class AlimentoServiceImpl implements AlimentoService {
    @Autowired
    AlimentoRepository repository;

    @Override
    public ResponseEntity<Response<Alimento>> save(@Valid Alimento alimento, BindingResult result) {
        Response<Alimento> response = new Response<Alimento>();
        response.setData(alimento);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(alimento);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Alimento> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Alimento>> getById(Integer id) {
        Response<Alimento> response = new Response<Alimento>();
        Alimento obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Alimento inválido");
        } catch (Exception ex) {
            response.getErrors().add("Alimento inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Response<Alimento>> delete(Integer id) {
        Response<Alimento> response = new Response<Alimento>();
        Alimento obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Alimento inválido");
        } catch (Exception ex) {
            response.getErrors().add("Alimento inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}
