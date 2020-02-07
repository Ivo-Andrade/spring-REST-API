package teste.example.login.services.impl;

import org.springframework.stereotype.Service;

import teste.example.login.exceptions.InvalidTokenException;
import teste.example.login.models.*;
import teste.example.login.services.TokenService;

@Service
public class TokenServiceImpl 
    implements TokenService
{

    public Token generateToken( LoginRequest loginRequest ) {
        return new Token("valid_token_example");
    }

    public void verifyToken( Token token ) {
        if(!token.getToken().equals("valid_token_example")) 
            throw new InvalidTokenException("Token provided is incorrect!");
    }

}