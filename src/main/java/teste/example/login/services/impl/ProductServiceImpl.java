package teste.example.login.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import teste.example.login.models.Product;
import teste.example.login.dao.product.ProductDao;
import teste.example.login.services.ProductService;

@Service
public class ProductServiceImpl 
    implements ProductService 
{

    @Qualifier("memory")
    @Autowired private ProductDao productDao;
    
	public List<Product> getProducts() {
        return productDao.findAll();
	}

}