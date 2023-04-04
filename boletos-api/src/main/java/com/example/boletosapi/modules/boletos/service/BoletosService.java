package com.example.boletosapi.modules.boletos.service;

import com.example.boletosapi.config.ValidationExcpetion;
import com.example.boletosapi.modules.boletos.dto.BoletoResponse;
import com.example.boletosapi.modules.boletos.dto.BoletosRequest;
import com.example.boletosapi.modules.boletos.model.Boletos;
import com.example.boletosapi.modules.boletos.repository.BoletosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BoletosService {

    @Autowired
    private BoletosRepository boletosRepository;

    public BoletoResponse save(BoletosRequest request){
        var boleto = boletosRepository.save(Boletos.of(request));
        return BoletoResponse.of(boleto);
    }

    public BoletoResponse pagar(UUID id){
        Boletos boleto = boletosRepository.findById(id).orElseThrow(() -> new ValidationExcpetion("Não foi encontrado usuario com esse id" + id));;
        boleto.setStatus(true);
        boletosRepository.save(boleto);
        return BoletoResponse.of(boleto);
    }

    public List<Boletos> buscarBoletosEstudantes(UUID idestudante){
        List <Boletos> boletos = boletosRepository.findByIdestudante(idestudante);
        return boletos;
    }
}
