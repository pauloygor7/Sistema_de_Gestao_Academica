package com.gestao.sga.model;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_classe_curso")
@Getter
@Setter
public class ClasseCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String sigla;

    @Nullable
    @Column(nullable = true)
    private String descricao;
}
