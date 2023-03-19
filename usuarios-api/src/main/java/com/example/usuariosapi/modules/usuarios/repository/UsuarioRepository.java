package com.example.usuariosapi.modules.usuarios.repository;

import com.example.usuariosapi.modules.usuarios.dto.UsuarioAdminResponse;
import com.example.usuariosapi.modules.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    @Query(value = "SELECT admin FROM usuarios WHERE id = ?1", nativeQuery = true)
    List<UsuarioAdminResponse> admin(UUID id);
}
