package com.example.boletosapi.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthtenticationExcpetion extends RuntimeException{

    public AuthtenticationExcpetion(String message){
        super(message);
    }
}
