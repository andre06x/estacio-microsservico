package com.example.disciplinasapi.Modules.Disciplinas.Controller;

import com.example.disciplinasapi.Modules.Curso.Model.Curso;
import com.example.disciplinasapi.Modules.Curso.Repository.CursoRepository;
import com.example.disciplinasapi.Modules.Disciplinas.DTO.DisciplinasRequest;
import com.example.disciplinasapi.Modules.Disciplinas.DTO.DisciplinasResponse;
import com.example.disciplinasapi.Modules.Disciplinas.DTO.DisciplinasResponseList;
import com.example.disciplinasapi.Modules.Disciplinas.Repository.DisciplinasRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/disciplinas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DisciplinasController {

    @Autowired
    private DisciplinasRepository disciplinasRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/listar-todas")
    public List<Optional<Object>> listarTodas(@RequestBody DisciplinasRequest request){

        return  disciplinasRepository.disciplinasCurso(request.getCurso());
    }

    @GetMapping("/listar-curso")
    public List<DisciplinasResponse> listarCurso(@RequestBody DisciplinasRequest request){
        UUID idCurso = cursoRepository.findByNmcurso(request.getNmcurso()).getId();
        return disciplinasRepository.findByIdcurso(idCurso).stream().map(DisciplinasResponse::of).collect(Collectors.toList());
    }

}
