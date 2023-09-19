package com.projeto.gerenciamentoAlimentos.controllers;

import com.projeto.gerenciamentoAlimentos.services.AlimentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comida")
public class AlimentoController {
    final AlimentoService alimentoService;
    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }
}
