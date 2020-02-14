package teste.example.login.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import teste.example.login.dao.user.*;
import teste.example.login.exceptions.IncorrectPasswordException;
import teste.example.login.models.*;
import teste.example.login.services.*;

@Service
public class LoginServiceImpl implements LoginService {

    @Qualifier("memory")
    @Autowired private UserDao userDao;
    @Autowired private TokenService tokenService;

    public Token verifyLogin( LoginRequest loginRequest ) {
        if (userDao.findByUsername(loginRequest.getUsername()).getPassword().equals(loginRequest.getPassword()))
            return tokenService.generateToken(loginRequest);
        else throw new IncorrectPasswordException("Provided password is incorrect!");
    }

}