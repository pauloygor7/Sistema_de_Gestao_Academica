package com.gestao.sga.repository;

import com.gestao.sga.model.ClasseAluno;
import com.gestao.sga.model.ClasseCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<ClasseAluno, Long> {

    boolean existsByCursoId(Long cursoId);
}
