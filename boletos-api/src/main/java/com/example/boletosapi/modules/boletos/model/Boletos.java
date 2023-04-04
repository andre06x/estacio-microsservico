package com.example.boletosapi.modules.boletos.model;

import com.example.boletosapi.modules.boletos.dto.BoletosRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="boletos")
public class Boletos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String datavencimento;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private UUID idestudante;

    public static Boletos of(BoletosRequest request){
        var boletos = new Boletos();
        BeanUtils.copyProperties(request, boletos);
        return boletos;
    }
}
