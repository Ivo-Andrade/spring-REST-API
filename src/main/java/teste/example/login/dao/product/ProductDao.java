package teste.example.login.dao.product;

import java.util.List;
import java.util.UUID;

import teste.example.login.dao.GenericDao;
import teste.example.login.models.Product;

public interface ProductDao
    extends GenericDao<Product,UUID>
{

    List<Product> findByName(String name);

    List<Product> findByMake(String make);

    List<Product> findByPrice(Double price);
    
}