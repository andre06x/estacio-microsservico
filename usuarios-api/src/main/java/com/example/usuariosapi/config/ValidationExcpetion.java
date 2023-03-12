package com.example.usuariosapi.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationExcpetion extends RuntimeException{

    public ValidationExcpetion(String message){
        super(message);
    }
}
