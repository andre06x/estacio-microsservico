package com.example.usuariosapi.modules.usuarios.controller;

import com.example.usuariosapi.config.SuccessResponse;
import com.example.usuariosapi.modules.usuarios.dto.UsuariosRequest;
import com.example.usuariosapi.modules.usuarios.dto.UsuariosResponse;
import com.example.usuariosapi.modules.usuarios.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping
    public UsuariosResponse save(@RequestBody UsuariosRequest request){
        return usuariosService.save(request);
    }

    @GetMapping
    public List<UsuariosResponse> findAll(){
        return usuariosService.findAll();
    }

    @GetMapping("{id}")
    public UsuariosResponse findById(@PathVariable UUID id){
        return usuariosService.findByIdResponse(id);
    }

    @PutMapping("{id}")
    public UsuariosResponse update(@RequestBody UsuariosRequest request, @PathVariable UUID id){
        return usuariosService.update(request, id);
    }

    @DeleteMapping("{id}")
    public SuccessResponse deleteById(@PathVariable UUID id){
        return usuariosService.delete(id);
    }
}
