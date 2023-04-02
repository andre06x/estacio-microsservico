package com.example.disciplinasapi.config.Intercerptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IntercerptorConfig implements WebMvcConfigurer {
    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor()).excludePathPatterns("/api/status").pathMatcher(new AntPathMatcher());
    }
}
