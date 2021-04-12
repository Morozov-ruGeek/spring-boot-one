package ru.geekbrains.spring.lesson_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.lesson_2.model.Product;
import ru.geekbrains.spring.lesson_2.services.ProductService;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String showAllProductsPage(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/{id}")
    public String showProductInfo(@PathVariable(name = "id") Long id, Model model){
        Optional<Product> product = productService.findOneById(id);
        if(product.isPresent()){
            model.addAttribute("product",product);
        }
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreater(){
        return "add_product_form";
    }

    @PostMapping("/create")
    public String createNewProduct(@RequestParam Long id, @RequestParam String title, @RequestParam float cost){
        Product product = new Product(id, title, cost);
        productService.createProduct(product);
        return "redirect:/products/all";
    }
}
