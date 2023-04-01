package com.example.disciplinasapi.Modules.Disciplinas.Repository;

import com.example.disciplinasapi.Modules.Disciplinas.DTO.DisciplinasResponse;
import com.example.disciplinasapi.Modules.Disciplinas.DTO.DisciplinasResponseList;
import com.example.disciplinasapi.Modules.Disciplinas.Model.Disciplinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DisciplinasRepository extends JpaRepository<Disciplinas, UUID> {
    @Query(value = "SELECT nmdisciplina, periodo FROM disciplina INNER JOIN curso ON curso.id = idcurso WHERE nmcurso = ?1", nativeQuery = true)
    List<Optional<Object>> disciplinasCurso(String curso);

    List<Disciplinas> findByIdcurso(UUID idcurso);
}
