package com.example.usuariosapi.modules.usuarios.service;

import com.example.usuariosapi.config.SuccessResponse;
import com.example.usuariosapi.config.ValidationExcpetion;
import com.example.usuariosapi.modules.usuarios.dto.UsuariosRequest;
import com.example.usuariosapi.modules.usuarios.dto.UsuariosResponse;
import com.example.usuariosapi.modules.usuarios.model.Usuario;
import com.example.usuariosapi.modules.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class UsuariosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuariosResponse save(UsuariosRequest request){
        validateUsuariosInformed(request);
        var usuario =  usuarioRepository.save(Usuario.of(request));
        return UsuariosResponse.of(usuario);
    }

    private void  validateUsuariosInformed(UsuariosRequest request){
        if(isEmpty(request.getCpf())|| isEmpty(request.getRg()) || isEmpty(request.getNome()) || isEmpty(request.getDt_nascimento())){
            throw new ValidationExcpetion("Dados para o cadastro incompletos");
        };
    }

    public List<UsuariosResponse> findAll(){
        return usuarioRepository.findAll().stream().map(UsuariosResponse::of).collect(Collectors.toList());
    }

    public UsuariosResponse findByIdResponse(UUID id){
        if(isEmpty(id)){
            throw new ValidationExcpetion("Id do usuario não informado.");
        }
        return UsuariosResponse.of(findById(id));
    }

    public Usuario findById(UUID id){
        return usuarioRepository.findById(id).orElseThrow(() -> new ValidationExcpetion("Não foi encontrado usuario com esse id"));
    }

    public UsuariosResponse update(UsuariosRequest request, UUID id){
        validateUsuariosInformed(request);
        validateInformedId(id);

        var usuario = Usuario.of(request);
        usuario.setId(id);

        usuarioRepository.save(usuario);
        return UsuariosResponse.of(usuario);
    }

    public SuccessResponse delete(UUID id){
        validateInformedId(id);
        usuarioRepository.deleteById(id);
        return SuccessResponse.create("O usuario foi deletado.");
    }

    public void validateInformedId(UUID id){
        if(isEmpty(id))
            throw new ValidationExcpetion("Id não informado");
    }
}
