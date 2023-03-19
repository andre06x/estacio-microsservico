package com.example.usuariosapi.modules.usuarios.dto;

import com.example.usuariosapi.modules.usuarios.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioAdminResponse {
    private Boolean admin;
    private String nome;

    public static UsuarioAdminResponse of(Usuario request){
        return UsuarioAdminResponse.builder().admin(request.getAdmin()).nome(request.getNome()).build();
    }
}
