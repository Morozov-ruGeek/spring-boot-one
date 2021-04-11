package ru.geekbrains.spring.lesson_2;

import java.util.List;

public interface IProductRepository {
    List<Product> getProducts();
    Product getProductById();
}
