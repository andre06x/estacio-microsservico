package com.example.boletosapi.modules.boletos.dto;

import com.example.boletosapi.modules.boletos.model.Boletos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletoResponse {
    private UUID id;

    private Double valor;

    private String datavencimento;

    private Boolean status;

    private UUID idestudante;

    public static BoletoResponse of(Boletos request){
        var boletos = new BoletoResponse();
        BeanUtils.copyProperties(request, boletos);
        return boletos;
    }
}
