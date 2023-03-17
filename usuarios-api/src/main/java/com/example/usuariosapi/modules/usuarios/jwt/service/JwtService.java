package com.example.usuariosapi.modules.usuarios.jwt.service;

import com.example.usuariosapi.config.AuthtenticationExcpetion;
import com.example.usuariosapi.modules.usuarios.jwt.dto.JwtResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class JwtService {
    private static final String EMPTY_SPACE = " ";
    private static final Integer TOKEN_INDEX = 1;

    @Value("${app-config.secrets.api-secret}")
    private String apiSecret;

    public void validateAuthorization(String token){
        var accessToken = extractToken(token);
        try {
            var claims = Jwts
                    .parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(apiSecret.getBytes()))
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();

            var user = JwtResponse.getUser(claims);

            if(isEmpty(user) || isEmpty(user.getId()) || !user.getAdmin()){
                throw new AuthtenticationExcpetion("Usuario não válido");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            throw new AuthtenticationExcpetion("Error ao tentar processar token");
        }
    }

    private String extractToken(String token){
        if(isEmpty(token)){
            throw new AuthtenticationExcpetion("Token nao informado");
        }

        if(token.contains(EMPTY_SPACE)){
            return token.split(EMPTY_SPACE)[TOKEN_INDEX];
        }

        return token;
    }
}
