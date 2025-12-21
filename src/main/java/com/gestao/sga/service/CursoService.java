package com.gestao.sga.service;

import com.gestao.sga.model.ClasseCurso;
import com.gestao.sga.model.RespostaModel;
import com.gestao.sga.repository.AlunoRepository;
import com.gestao.sga.repository.SgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private SgaRepository sr;

    @Autowired
    private RespostaModel rm;

    @Autowired
    private AlunoRepository ar;

    @Transactional(readOnly = true)
    public ResponseEntity<?> cadastrarCurso(ClasseCurso curso) {
        if (curso.getNome().equals("")) {
            rm.setMensagem("O nome do curso é obrigatório!");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        } else if (curso.getSigla().equals("")) {
            rm.setMensagem("A sigla do curso é obrigatório!");
            return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<ClasseCurso>(sr.save(curso), HttpStatus.CREATED);
    }

    @Transactional(readOnly = true)
    public List<ClasseCurso> listarCursos() {
        List<ClasseCurso> lista = sr.findAll();
        return lista;
    }

    @Transactional(readOnly = true)
    public Optional<ClasseCurso> buscarCursoById(Long id) {
        Optional<ClasseCurso> curso = sr.findById(id);
        return curso;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> deletarCursoById(Long id) {
        return sr.findById(id).map(curso -> {
                    if (ar.existsByCursoId(curso.getId())) {
                        rm.setMensagem("Não é possível remover o curso, existem alunos vinculados!");
                        return new ResponseEntity<>(rm, HttpStatus.CONFLICT);
                    }

                    sr.delete(curso);
                    rm.setMensagem("Curso removido com sucesso!");
                    return new ResponseEntity<>(rm, HttpStatus.OK);
                }).orElseGet(() -> {
            rm.setMensagem("Curso não encontrado!");
            return new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
        });
    }
}
