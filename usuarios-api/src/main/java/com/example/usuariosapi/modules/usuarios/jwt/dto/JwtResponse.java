package com.example.usuariosapi.modules.usuarios.jwt.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.jsonwebtoken.Claims;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private UUID id;
    private UUID id_usuario;
    private String email;
    private Boolean admin;

    public static JwtResponse getUser(Claims jwtClaims){
        try {
            return new ObjectMapper().convertValue(jwtClaims.get("authUser"), JwtResponse.class);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
}
