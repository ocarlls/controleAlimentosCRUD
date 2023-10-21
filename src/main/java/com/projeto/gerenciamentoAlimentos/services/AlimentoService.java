package com.projeto.gerenciamentoAlimentos.services;

import com.projeto.gerenciamentoAlimentos.models.Alimento;
import com.projeto.gerenciamentoAlimentos.models.Usuario;
import com.projeto.gerenciamentoAlimentos.repositories.AlimentoRepository;
import com.projeto.gerenciamentoAlimentos.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public interface AlimentoService {
    public ResponseEntity<Response<Alimento>> save(Alimento alimento, BindingResult result);
    public List<Alimento> getAll();
    public ResponseEntity<Response<Alimento>> getById(Integer id);
    public ResponseEntity<Response<Alimento>> delete(Integer id);
}
