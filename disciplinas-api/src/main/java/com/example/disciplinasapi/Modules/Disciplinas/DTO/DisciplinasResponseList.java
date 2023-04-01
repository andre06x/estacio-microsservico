package com.example.disciplinasapi.Modules.Disciplinas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
public class DisciplinasResponseList {
    private List<DisciplinasResponse> disciplinas;


}
