package teste.example.login.services;

import teste.example.login.models.LoginRequest;
import teste.example.login.models.Token;

public interface TokenService {

    public Token generateToken( LoginRequest loginRequest );

    public void verifyToken( Token token );

}