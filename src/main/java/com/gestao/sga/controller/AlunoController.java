package com.gestao.sga.controller;

import com.gestao.sga.model.ClasseAluno;
import com.gestao.sga.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService as;

    @PostMapping
    public ResponseEntity<?> cadastrarAluno(@Valid @RequestBody ClasseAluno aluno) {
        return as.cadastrarAluno(aluno);
    }

    @GetMapping
    public List<ClasseAluno> listarAlunos() {
        return as.listarAlunos();
    }

    @GetMapping("/{id}")
    public Optional<ClasseAluno> buscarAlunoById(@PathVariable Long id) {
        return as.buscarAlunoById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @Valid @RequestBody ClasseAluno aluno) {
        return as.atualizarAluno(id, aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable Long id) {
        return as.deletarAluno(id);
    }
}
