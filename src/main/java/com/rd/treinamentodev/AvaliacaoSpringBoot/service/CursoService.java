package com.rd.treinamentodev.AvaliacaoSpringBoot.service;


import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class CursoService {


    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity gravar(CursoDTO cursoDTO) throws Exception {
        CursoEntity entity = new CursoEntity();

        entity.setNomeCurso(cursoDTO.getNomeCurso());
        entity.setNrCargaHoraria(cursoDTO.getNrCargaHoraria());

        entity = cursoRepository.save(entity);


        ResultData resultData = new ResultData(HttpStatus.CREATED.value(), "Curso cadastrado com sucesso", entity.getIdCurso());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
    }

    public List<CursoEntity> buscarPorNome(String nomeCurso){
        return cursoRepository.findByNomeCurso(nomeCurso);
    }

}
