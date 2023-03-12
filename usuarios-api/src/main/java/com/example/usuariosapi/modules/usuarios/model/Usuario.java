package com.example.usuariosapi.modules.usuarios.model;

import com.example.usuariosapi.modules.usuarios.dto.UsuariosRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private String dt_nascimento;

    public static Usuario of(UsuariosRequest request){
        var usuario = new Usuario();
        BeanUtils.copyProperties(request, usuario);
        return usuario;
    }
}
