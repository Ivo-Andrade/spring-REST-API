package teste.example.login.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teste.example.login.models.*;

@Repository
public interface UserRepository 
    extends JpaRepository<User, Long>
{

    User findByUsername(String username);

    List<User> findByDescription(String description);
    
}