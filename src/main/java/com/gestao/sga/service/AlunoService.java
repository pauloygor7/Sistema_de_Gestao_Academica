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
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public List<ClasseAluno> listarAlunos() {
        List<ClasseAluno> lista = ar.findAll();
        return lista;
    }

    @Transactional(readOnly = true)
    public Optional<ClasseAluno> buscarAlunoById(Long id) {
        Optional<ClasseAluno> aluno = ar.findById(id);
        return aluno;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> atualizarAluno(Long id, ClasseAluno aluno) {

        if ((aluno.getNome() == null || aluno.getNome().isBlank()) &&
                (aluno.getEmail() == null || aluno.getEmail().isBlank()) &&
                (aluno.getMatricula() == null || aluno.getMatricula().isBlank()) &&
                aluno.getCurso() == null) {

            rm.setMensagem("É obrigatório preencher pelo menos um campo!");
            return new ResponseEntity<>(rm, HttpStatus.BAD_REQUEST);
        }

        Optional<ClasseAluno> optionalAluno = ar.findById(id);

        if (optionalAluno.isPresent()) {
            ClasseAluno alunoExistente = optionalAluno.get();

            if (aluno.getNome() != null) {
                alunoExistente.setNome(aluno.getNome());
            }
            if (aluno.getEmail() != null) {
                alunoExistente.setEmail(aluno.getEmail());
            }
            if (aluno.getMatricula() != null) {
                alunoExistente.setMatricula(aluno.getMatricula());
            }
            if (aluno.getCurso() != null) {
                alunoExistente.setCurso(aluno.getCurso());
            }

            return new ResponseEntity<>(ar.save(alunoExistente), HttpStatus.OK);
        } else {
            rm.setMensagem("Aluno não encontrado");
            return new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
        }
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> deletarAluno(Long id) {
        Optional<ClasseAluno> optionalAluno = ar.findById(id);

        if (optionalAluno.isPresent()) {
            ClasseAluno alunoExistente = optionalAluno.get();
            ar.delete(alunoExistente);
            rm.setMensagem("Aluno removido com sucesso!");
            return new ResponseEntity<>(rm, HttpStatus.OK);
        } else {
            rm.setMensagem("Aluno não encontrado!");
            return new ResponseEntity<>(rm, HttpStatus.NOT_FOUND);
        }
    }

}
