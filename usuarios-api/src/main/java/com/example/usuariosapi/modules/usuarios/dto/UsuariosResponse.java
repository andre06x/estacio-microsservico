package com.example.usuariosapi.modules.usuarios.dto;

import com.example.usuariosapi.modules.usuarios.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosResponse {
    private UUID id;

    private String nome;

    private String cpf;

    private String rg;

    private String dt_nascimento;

    private Boolean admin;

    public static UsuariosResponse of(Usuario request){
        var usuario = new UsuariosResponse();
        BeanUtils.copyProperties(request, usuario);
        return usuario;
    }

}
