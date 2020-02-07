// package teste.example.login.controllers;

// import org.springframework.boot.web.servlet.error.ErrorController;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.*;

// @Controller
// public class WebController 
//     implements ErrorController
// {
//     private static final String PATH = "/error";

//     @Override
//     public String getErrorPath() {
//         return PATH;
//     }

//     @RequestMapping( value = PATH )
//     public String retriveErrorPage() {
//         return "error404.html";
//     }
    
//     @GetMapping("/login")
//     public String retriveLoginPage(){
//         return "login.html";
//     }
    
//     @GetMapping("/products")
//     public String retriveProductsPage(){
//         return "products.html";
//     }

// }