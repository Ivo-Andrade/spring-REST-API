package teste.example.login.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import teste.example.login.models.Token;
import teste.example.login.services.TokenService;

@Aspect
@Component
public class TokenValidationAspect {

    @Autowired
    TokenService tokenService;

    @Before("@annotation(teste.example.login.aspects.annotations.TokenValidationAdvice) && args(@RequestBody token)")
    public void tokenValidation(JoinPoint joinPoint, Token token) {
        tokenService.verifyToken(token);
    }

}