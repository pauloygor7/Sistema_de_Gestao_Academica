package com.gestao.sga.repository;

import com.gestao.sga.model.ClasseCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SgaRepository extends JpaRepository<ClasseCurso, Long> {
}
