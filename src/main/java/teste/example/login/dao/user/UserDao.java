package teste.example.login.dao.user;

import java.util.List;
import java.util.UUID;

import teste.example.login.dao.GenericDao;
import teste.example.login.models.User;

public interface UserDao
    extends GenericDao<User,UUID>
{

    User findByUsername(String username);

    List<User> findByDescription(String description);
    
}