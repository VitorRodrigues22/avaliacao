package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class TurmaBO {

    @Autowired
    TurmaRepository repository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public TurmaDTO parseToDTO(TurmaEntity t) {
        TurmaDTO dto = new TurmaDTO();

        if (t == null)
            return dto;


        //CURSOS
        dto.setCurso(t.getCurso());

        //INSTRUTORES
        List<InstrutorDTO> instrutor = new ArrayList<>();
        for (InstrutorEntity item : t.getInstrutores()) {
            InstrutorDTO tDTO = new InstrutorDTO();
            tDTO.setNome(item.getNomeInstrutor());
            tDTO.setValorHora(item.getValorHora());

            instrutor.add(tDTO);
        }
        dto.setInstrutores(instrutor);


        //ALUNOS
        List<AlunoDTO> aluno = new ArrayList<>();
        for (AlunoEntity item : t.getAlunos()) {
            AlunoDTO aDTO = new AlunoDTO();
            aDTO.setNomeAluno(item.getNomeAluno());
            aDTO.setCpf(item.getCpf());

            aluno.add(aDTO);
        }
        dto.setAlunos(aluno);

        //DATAS
        dto.setDtInicio(SDF.format(t.getDtInicio()));
        dto.setDtFinal(SDF.format(t.getDtFinal()));

        return dto;

    }
}
