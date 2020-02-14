package teste.example.login.dao.user;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teste.example.login.models.*;

@Repository
public interface UserRepository 
    extends JpaRepository<User, UUID>
{

    User findByUsername(String username);

    List<User> findByDescription(String description);
    
}