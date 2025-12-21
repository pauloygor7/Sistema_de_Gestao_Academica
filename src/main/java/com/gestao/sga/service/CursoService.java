package com.gestao.sga.service;

import com.gestao.sga.model.ClasseCurso;
import com.gestao.sga.repository.SgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private SgaRepository sr;

    public List<ClasseCurso> listarCursos() {
        List<ClasseCurso> lista = sr.findAll();
        return lista;
    }
}
