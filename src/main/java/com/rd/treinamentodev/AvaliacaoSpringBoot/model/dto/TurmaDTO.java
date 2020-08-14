package com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import lombok.Data;

import java.util.List;

@Data
public class TurmaDTO {

    private CursoEntity curso;

    private String dtInicio;

    private String dtFinal;

    private List<InstrutorDTO> instrutores;

    private List<AlunoDTO> alunos;
}
