package teste.example.login.dao.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import teste.example.login.exceptions.UserDaoException;
import teste.example.login.exceptions.UserNotFoundException;
import teste.example.login.models.User;

@Component
@Qualifier("memory")
public class UserDaoMemoryImpl
    implements UserDao
{

    List<User> userList = new ArrayList<User>();

    @PostConstruct
    public void init() {
        userList.add(new User(1L,"MEMORY_User_A", "passUser","description_A"));
        userList.add(new User(2L,"MEMORY_User_B", "passUser","description_B"));
        userList.add(new User(3L,"MEMORY_User_C", "passUser","description_C"));
    }

    public void create(User newInstance) {
        try {
            userList.add(newInstance);
        } catch (Exception e) {
            throw new UserDaoException("An error occurred while trying to create the user in the database!",e);
        }
    }

    public List<User> findAll() {
        return userList;
    }

    public User update(User transientObject) {
        for(User user : userList) {
            if( user.getId() == transientObject.getId()){
                userList.remove(user);
                userList.add(transientObject);
                return user;
            }

        }
        throw new UserDaoException("An error occurred while trying to update the user by id ("+transientObject.getId()+") in the database!");
    }

    public void delete(User persistentObject) {
        try {
            userList.remove(persistentObject);
        } catch (Exception e) {
            throw new UserDaoException("An error occurred while trying to delete the user in the database!",e);
        }
    }

    public User findByUsername(String username) {
        for(User user : userList) {
            if( user.getUsername().equals(username))
                return user;
        }
        throw new UserNotFoundException("User not found!");
    }

    public List<User> findByDescription(String description) {
        List<User> users = new ArrayList<User>();

        for(User user : userList) {
            if( user.getDescription().equals(description))
                users.add(user);
        }

        return users;
    }

}