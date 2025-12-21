package com.gestao.sga.controller;

import com.gestao.sga.model.ClasseCurso;
import com.gestao.sga.model.RespostaModel;
import com.gestao.sga.service.CursoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cs;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody ClasseCurso curso) {
        return cs.cadastrarCurso(curso);
    }

    @GetMapping
    public List<ClasseCurso> listar() {
        List<ClasseCurso> lista = cs.listarCursos();
        return lista;
    }

    @GetMapping("/{id}")
    public Optional<ClasseCurso> buscarCursoById(@PathVariable Long id) {
        return cs.buscarCursoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProdutoById(@PathVariable Long id) {
        return cs.deletarCursoById(id);
    }
}
