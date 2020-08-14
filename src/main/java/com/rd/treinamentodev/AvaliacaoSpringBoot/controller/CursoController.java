package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.AlunoService;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoRepository repository;

    //LISTAR VIA REPOSITÓRIO
    @GetMapping("/cursos")
    public ResponseEntity<Object> listarTodas() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping("/cursos")
    public ResponseEntity gravar(@RequestBody CursoDTO cursoDTO) throws Exception {
        return cursoService.gravar(cursoDTO);
    }

    @GetMapping("/cursos/{nomeCurso}")
    public ResponseEntity buscarPorNome(@PathVariable("nomeCurso") String nomeCurso){
        return ResponseEntity.ok().body(cursoService.buscarPorNome(nomeCurso));
    }

}
