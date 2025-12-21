package com.gestao.sga.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String sigla;

    @Column(nullable = true)
    private String descricao;
}
