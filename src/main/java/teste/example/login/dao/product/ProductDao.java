package teste.example.login.dao.product;

import java.util.List;

import teste.example.login.dao.GenericDao;
import teste.example.login.models.Product;

public interface ProductDao
    extends GenericDao<Product,Long>
{

    List<Product> findByName(String name);

    List<Product> findByMake(String make);

    List<Product> findByPrice(Double price);
    
}