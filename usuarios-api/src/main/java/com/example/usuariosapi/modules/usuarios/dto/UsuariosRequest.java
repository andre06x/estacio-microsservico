package com.example.usuariosapi.modules.usuarios.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class UsuariosRequest {

    private String nome;

    private String cpf;

    private String rg;

    private String dt_nascimento;
}
