package com.example.disciplinasapi.Modules.Disciplinas.Model;

import com.example.disciplinasapi.Modules.Curso.Model.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "disciplina")
public class Disciplinas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private UUID idcurso;

    @Column(nullable = false)
    private String nmdisciplina;

    @Column(nullable = false)
    private Integer periodo;

}
