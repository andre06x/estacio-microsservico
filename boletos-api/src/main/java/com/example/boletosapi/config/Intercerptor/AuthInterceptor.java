package com.example.boletosapi.config.Intercerptor;


import com.example.boletosapi.modules.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    private static final String[] AUTH_WHITELIST = {
        "/api/usuarios/*"
    };
    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AntPathMatcher matcher = new AntPathMatcher();

        String pattern = "/api/usuarios/*";
        String requestURI = request.getRequestURI();

        if(isOptions(request)){
            return true;
        }
//        if(matcher.match(pattern, requestURI)){
            var authorization = request.getHeader(AUTHORIZATION);
            jwtService.validateAuthorization(authorization);
//        }

        return true;
    }

    private boolean isOptions(HttpServletRequest request){
        return HttpMethod.OPTIONS.name().equals(request.getMethod());
    }
}
