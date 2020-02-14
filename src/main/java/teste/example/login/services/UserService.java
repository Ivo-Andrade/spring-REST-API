package teste.example.login.services;

import java.util.UUID;

import teste.example.login.models.User;

public interface UserService {

    public User findById(UUID id);

}