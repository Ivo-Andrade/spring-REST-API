package teste.example.login.services;

import java.util.UUID;

import teste.example.login.models.LoginRequest;
import teste.example.login.models.Token;

public interface TokenService {

    public Token generateToken( LoginRequest loginRequest );

    public void verifyToken( Token token );

    public UUID getUserId( Token token );

}