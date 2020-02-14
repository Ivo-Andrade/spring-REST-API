package teste.example.login.dao.user;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import teste.example.login.exceptions.UserNotFoundException;
import teste.example.login.models.User;

@Component
@Qualifier("repository")
public class UserDaoRepositoryImpl
    implements UserDao
{

    @Autowired
    UserRepository userRepo;

    public void create(User newInstance) {
        userRepo.save(newInstance);
    }

    public User findById(UUID id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User update(User transientObject) {
        userRepo.deleteById(transientObject.getId());
        return userRepo.save(transientObject);
    }

    public void delete(User persistentObject) {
        userRepo.delete(persistentObject);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<User> findByDescription(String description) {
        return userRepo.findByDescription(description);
    }

}