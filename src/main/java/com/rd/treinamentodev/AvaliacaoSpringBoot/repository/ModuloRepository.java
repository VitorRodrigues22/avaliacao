package com.rd.treinamentodev.AvaliacaoSpringBoot.repository;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.ModuloEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuloRepository extends JpaRepository<ModuloEntity, Long> {

}
