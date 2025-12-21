package com.gestao.sga.controller;

import com.gestao.sga.model.ClasseAluno;
import com.gestao.sga.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService as;

    @PostMapping
    public ResponseEntity<?> cadastrarAluno(@RequestBody ClasseAluno aluno) {
        return as.cadastrarAluno(aluno);
    }
}
