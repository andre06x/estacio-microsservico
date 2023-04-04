package com.example.boletosapi.modules.boletos.controller;

import com.example.boletosapi.modules.boletos.dto.BoletoResponse;
import com.example.boletosapi.modules.boletos.dto.BoletosRequest;
import com.example.boletosapi.modules.boletos.model.Boletos;
import com.example.boletosapi.modules.boletos.repository.BoletosRepository;
import com.example.boletosapi.modules.boletos.service.BoletosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/boletos")
public class BoletosController {

    @Autowired
    private BoletosService boletosService;

    @PostMapping
    public BoletoResponse save(@RequestBody BoletosRequest request){
        return boletosService.save(request);
    }

    @GetMapping("/estudante/{id}")
    public List<Boletos> boletosEstudante(@PathVariable UUID id){
        return boletosService.buscarBoletosEstudantes(id);
    }

    @PutMapping("/pagar/{id}")
    public BoletoResponse pago(@PathVariable UUID id){
        return boletosService.pagar(id);
    }
}
