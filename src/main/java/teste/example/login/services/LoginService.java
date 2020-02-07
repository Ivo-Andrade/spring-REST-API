package teste.example.login.services;

import teste.example.login.models.LoginRequest;
import teste.example.login.models.Token;

public interface LoginService {

    public Token verifyLogin( LoginRequest loginService );

}