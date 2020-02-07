package teste.example.login.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import teste.example.login.exceptions.UserDaoException;
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
        try {
            userRepo.save(newInstance);
        } catch (Exception e) {
            throw new UserDaoException("An error occurred while trying to create the user in the database!");
        }
    }

    public User findById(Long id) {
        try {
            return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found!"));
        } catch (Exception e) {
            throw new UserDaoException("An error occurred while trying to find the user by id ("+id+") in the database!",e);
        }
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User update(User transientObject) {
        try {
            userRepo.deleteById(transientObject.getId());
            return userRepo.save(transientObject);
        } catch (Exception e) {
            throw new UserDaoException("An error occurred while trying to update the user by id ("+transientObject.getId()+") in the database!",e);
        }
    }

    public void delete(User persistentObject) {
        try {
            userRepo.delete(persistentObject);
        } catch (Exception e) {
            throw new UserDaoException("An error occurred while trying to delete the user in the database!",e);
        }
    }

    public User findByUsername(String username) {
        try {
            return userRepo.findByUsername(username);
        } catch (Exception e) {
            throw new UserNotFoundException("User not found!",e);
        }
    }

    public List<User> findByDescription(String description) {
        try {
            return userRepo.findByDescription(description);
        } catch (Exception e) {
            throw new UserNotFoundException("User not found!",e);
        }
    }

}