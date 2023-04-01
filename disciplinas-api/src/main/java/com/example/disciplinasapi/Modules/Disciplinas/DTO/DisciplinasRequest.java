package com.example.disciplinasapi.Modules.Disciplinas.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinasRequest {
    private String curso;
    private String nmcurso;
    private Integer periodo;
}
