package com.gestao.sga.controller;

import com.gestao.sga.model.ClasseCurso;
import com.gestao.sga.service.CursoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cs;

    @GetMapping
    public List<ClasseCurso> listar() {
        List<ClasseCurso> lista = cs.listarCursos();
        return lista;
    }
}
