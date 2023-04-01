package com.example.disciplinasapi.Modules.Curso.Repository;

import com.example.disciplinasapi.Modules.Curso.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;
public interface CursoRepository extends JpaRepository<Curso, UUID> {
     Curso findByNmcurso(String nmcurso);
}
