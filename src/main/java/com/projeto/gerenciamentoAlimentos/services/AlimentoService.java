package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.domain.food.Alimento;
import com.projeto.gerenciamentoAlimentos.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public interface AlimentoService {
    public ResponseEntity<Response<Alimento>> save(Alimento alimento, BindingResult result);
    public List<Alimento> getAll();
    public ResponseEntity<Response<Alimento>> getById(Integer id);
    public ResponseEntity<Response<Alimento>> delete(Integer id);
}
