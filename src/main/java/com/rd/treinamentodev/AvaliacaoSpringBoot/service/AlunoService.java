package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    public ResponseEntity gravar(AlunoDTO alunoDTO) throws Exception {
        ResultData resultData = null;
        AlunoEntity entity = new AlunoEntity();

        entity.setNomeAluno(alunoDTO.getNomeAluno());
        entity.setCpf(alunoDTO.getCpf());


        //TODO validar se o CPF existe no banco antes de existir, caso exista retornar mensagem de erro
        for (AlunoEntity a : alunoRepository.findByCpf(alunoDTO.getCpf())) {
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "CPF já existente no banco de dados!");
        }

        if (alunoDTO.getCpf() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "CPF não informado!");

        if (resultData != null)
            return ResponseEntity.badRequest().body(resultData);
        else {
            try {
                entity = alunoRepository.save(entity);
                resultData = new ResultData<AlunoEntity>(HttpStatus.OK.value(), "Aluno registrada com sucesso!");
                return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
            } catch (Exception e) {
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar Produto", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultData);
            }
        }
    }
}
