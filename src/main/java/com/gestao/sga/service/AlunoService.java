package com.gestao.sga.service;

import com.gestao.sga.model.ClasseAluno;
import com.gestao.sga.model.ClasseCurso;
import com.gestao.sga.model.RespostaModel;
import com.gestao.sga.repository.AlunoRepository;
import com.gestao.sga.repository.SgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository ar;

    @Autowired
    private SgaRepository sr;

    @Autowired
    private RespostaModel rm;

    public ResponseEntity<?> cadastrarAluno(ClasseAluno aluno) {
        if (aluno.getNome().equals("")) {
            rm.setMensagem("O nome do aluno é obrigatório!");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (aluno.getMatricula().equals("")) {
            rm.setMensagem("A matrícula do aluno é obrigatório!");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (aluno.getEmail().equals("")) {
            rm.setMensagem("O email do aluno é obrigatório!");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        }

        Long cursoId = aluno.getCurso() != null ? aluno.getCurso().getId() : null;
        if (cursoId == null || !sr.existsById(cursoId)) {
            rm.setMensagem("Curso não encontrado para matrícula!");
            return new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
        }

        ClasseCurso curso = sr.findById(cursoId).get();
        aluno.setCurso(curso);

        return new ResponseEntity<>(ar.save(aluno), HttpStatus.CREATED);
    }

    public List<ClasseAluno> listarAlunos() {
        List<ClasseAluno> lista = ar.findAll();
        return lista;
    }
}
