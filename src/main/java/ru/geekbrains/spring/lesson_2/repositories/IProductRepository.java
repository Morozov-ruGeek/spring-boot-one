package ru.geekbrains.spring.lesson_2.repositories;

import ru.geekbrains.spring.lesson_2.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> getAllProducts();
    void createProduct(Product product);
    Optional<Product> findOneById(Long id);
}
