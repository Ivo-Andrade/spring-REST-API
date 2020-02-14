package teste.example.login.services.impl;

import java.util.UUID;

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
        if(token == null)
            throw new InvalidTokenException("Token is missing!");
        if(!token.getToken().equals("valid_token_example")) 
            throw new InvalidTokenException("Token provided is incorrect!");
    }

    public UUID getUserId(Token token) {
        return UUID.fromString("84e21235-3331-4d8a-8c11-274ffe02567e");
    }

}