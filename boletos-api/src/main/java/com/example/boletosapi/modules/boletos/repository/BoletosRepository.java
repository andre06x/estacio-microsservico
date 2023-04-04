package com.example.boletosapi.modules.boletos.repository;

import com.example.boletosapi.modules.boletos.model.Boletos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BoletosRepository extends JpaRepository<Boletos, UUID> {
    List<Boletos> findByIdestudante(UUID idestudante);
}
