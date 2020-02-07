package teste.example.login.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import teste.example.login.models.*;
import teste.example.login.services.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("")
    public Token performLogin(@RequestBody @Valid LoginRequest loginRequest){
        return loginService.verifyLogin(loginRequest);
    }

}