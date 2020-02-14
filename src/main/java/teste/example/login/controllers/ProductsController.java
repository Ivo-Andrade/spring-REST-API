package teste.example.login.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import teste.example.login.aspects.annotations.TokenValidationAdvice;
import teste.example.login.models.*;
import teste.example.login.services.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired ProductService productService;

    @PostMapping("")
    @ResponseBody
    @TokenValidationAdvice
    public List<Product> retriveProducts(@RequestBody @Valid Token token) {
        return productService.getProducts();
    }

}