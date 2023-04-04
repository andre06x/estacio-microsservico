package com.example.boletosapi.modules.boletos.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BoletosRequest {

    private UUID id;

    private Double valor;

    private String datavencimento;

    private Boolean status;

    private UUID idestudante;

}
