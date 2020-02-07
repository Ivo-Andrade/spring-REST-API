package teste.example.login.dao.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import teste.example.login.exceptions.ProductDaoException;
import teste.example.login.exceptions.ProductNotFoundException;
import teste.example.login.models.Product;

@Component
@Qualifier("repository")
public class ProductDaoRepositoryImpl
    implements ProductDao
{

    @Autowired
    ProductRepository productRepo;

    public void create(Product newInstance) {
        try {
            productRepo.save(newInstance);
        } catch (Exception e) {
            throw new ProductDaoException("An error occurred while trying to create the product in the database!",e);
        }
    }

    public Product findById(Long id) {
        try {
            return productRepo.findById(id).orElse(null);
        } catch (Exception e) {
            throw new ProductNotFoundException("An error occurred while trying to find product by id ("+id+") in the database!",e);
        }
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product update(Product transientObject) {
        try {
            productRepo.deleteById(transientObject.getId());
            return productRepo.save(transientObject);
        } catch (Exception e) {
            throw new ProductNotFoundException("An error occurred while trying to update the product by id ("+transientObject.getId()+") in the database!",e);
        }
    }

    public void delete(Product persistentObject) {
        try {
            productRepo.delete(persistentObject);
        } catch (Exception e) {
            throw new ProductNotFoundException("An error occurred while trying to delete the product in the database!",e);
        }
    }

    @Override
    public List<Product> findByName(String name) {
        try {
            return productRepo.findByName(name);
        } catch (Exception e) {
            throw new ProductNotFoundException("An error occurred while trying to find the product by name ("+name+") in the database!",e);
        }
    }

    @Override
    public List<Product> findByMake(String make) {
        try {
            return productRepo.findByMake(make);
        } catch (Exception e) {
            throw new ProductNotFoundException("An error occurred while trying to find the product by make ("+make+") in the database!",e);
        }
    }

    @Override
    public List<Product> findByPrice(Double price) {
        try {
            return productRepo.findByPrice(price);
        } catch (Exception e) {
            throw new ProductNotFoundException("An error occurred while trying to find the product by price ("+price+") in the database!",e);
        }
    }

}