package teste.example.login.dao.product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import teste.example.login.exceptions.ProductDaoException;
import teste.example.login.exceptions.ProductNotFoundException;
import teste.example.login.models.Product;

@Component
@Qualifier("memory")
public class ProductDaoMemoryImpl 
    implements ProductDao
{

    List<Product> productList = new ArrayList<Product>();

    @PostConstruct
    public void init() {
		productList.add(new Product(UUID.randomUUID(),"MEMORY_Product_A", "A_Make", 12.34));
		productList.add(new Product(UUID.randomUUID(),"MEMORY_Product_B", "A_Make", 43.21));
		productList.add(new Product(UUID.randomUUID(),"MEMORY_Product_A", "1_Make", 11.22));
    }

    public void create(Product newInstance) {
        try {
            productList.add(newInstance);
        } catch (Exception e) {
            throw new ProductDaoException("An error occurred while trying to create the product in the database!",e);
        }
    }

    public Product findById (UUID id) {
        for(Product product : productList) {
            if( product.getId() == id)
                return product;
        }
        throw new ProductNotFoundException("Product not found!");
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product update(Product transientObject) {
        for(Product product : productList) {
            if( product.getId() == transientObject.getId()){
                productList.remove(product);
                productList.add(transientObject);
                return product;
            }
        }
        throw new ProductNotFoundException("Product with id "+transientObject.getId()+" was not found in the database!");
    }

    public void delete(Product persistentObject) {
        try {
            productList.remove(persistentObject);
        } catch (Exception e) {
            throw new ProductNotFoundException("An error occurred while trying to delete the product in the database!",e);
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<Product>();

        for(Product product : productList) {
            if( product.getName().equals(name))
                products.add(product);
        }

        return products;
    }

    @Override
    public List<Product> findByMake(String make) {
        List<Product> products = new ArrayList<Product>();

        for(Product product : productList) {
            if( product.getMake().equals(make))
                products.add(product);
        }

        return products;
    }

    @Override
    public List<Product> findByPrice(Double price) {
        List<Product> products = new ArrayList<Product>();

        for(Product product : productList) {
            if( product.getPrice() == price)
                products.add(product);
        }

        return products;
    }
    
}