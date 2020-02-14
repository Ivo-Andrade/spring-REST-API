package teste.example.login.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import teste.example.login.dao.user.UserDao;
import teste.example.login.models.User;
import teste.example.login.services.UserService;

@Service
public class UserServiceImpl 
    implements UserService 
{
    @Qualifier("repository")
    @Autowired UserDao userRepo;

    public User findById(UUID id) {
        return userRepo.findById(id);
    }

}