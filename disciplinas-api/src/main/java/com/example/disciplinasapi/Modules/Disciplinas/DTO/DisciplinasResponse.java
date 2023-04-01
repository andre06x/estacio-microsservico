package com.example.disciplinasapi.Modules.Disciplinas.DTO;

import com.example.disciplinasapi.Modules.Disciplinas.Model.Disciplinas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinasResponse {
    private String nmdisciplina;
    private Integer periodo;

    public static DisciplinasResponse of(Disciplinas request){
        return DisciplinasResponse.builder().nmdisciplina(request.getNmdisciplina()).periodo(request.getPeriodo()).build();
    }
}
