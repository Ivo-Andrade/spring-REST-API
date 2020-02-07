package teste.example.login.dao.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teste.example.login.models.*;

@Repository
public interface ProductRepository
    extends JpaRepository<Product, Long>
{

    List<Product> findByName(String name);

    List<Product> findByMake(String make);

    List<Product> findByPrice(Double price);

}