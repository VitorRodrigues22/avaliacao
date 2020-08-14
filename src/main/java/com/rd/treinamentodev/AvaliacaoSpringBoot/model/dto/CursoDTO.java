package com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    private String nomeCurso;

    private Integer nrCargaHoraria;
}
