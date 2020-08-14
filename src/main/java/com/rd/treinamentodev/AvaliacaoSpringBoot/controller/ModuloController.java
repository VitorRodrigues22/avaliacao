package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.ModuloRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuloController {

    @Autowired
    private ModuloRepository repository;

    //LISTAR VIA REPOSITÓRIO
    @GetMapping("/modulos")
    public ResponseEntity<Object> listarTodas(){
        return ResponseEntity.ok().body(repository.findAll());
    }

}
