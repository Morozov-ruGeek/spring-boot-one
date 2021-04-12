package ru.geekbrains.spring.lesson_2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.lesson_2.model.Product;
import ru.geekbrains.spring.lesson_2.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Optional<Product> findOneById(Long id){
        return productRepository.findOneById(id);
    }

    public void createProduct(Product product){
        productRepository.createProduct(product);
    }
}
