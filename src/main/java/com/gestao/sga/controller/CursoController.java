package com.gestao.sga.controller;

import com.gestao.sga.model.ClasseCurso;
import com.gestao.sga.service.CursoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
