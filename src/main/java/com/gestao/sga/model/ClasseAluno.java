package com.gestao.sga.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_aluno")
@Getter
@Setter
public class ClasseAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private ClasseCurso curso;
}
