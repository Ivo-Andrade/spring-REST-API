package teste.example.login.dao.product;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
        productRepo.save(newInstance);
    }

    public Product findById(UUID id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found!"));
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product update(Product transientObject) {
        productRepo.deleteById(transientObject.getId());
        return productRepo.save(transientObject);
    }

    public void delete(Product persistentObject) {
        productRepo.delete(persistentObject);
    }

    public List<Product> findByName(String name) {
        return productRepo.findByName(name);
    }

    public List<Product> findByMake(String make) {
        return productRepo.findByMake(make);
    }

    public List<Product> findByPrice(Double price) {
        return productRepo.findByPrice(price);
    }

}