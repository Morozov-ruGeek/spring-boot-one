package ru.geekbrains.spring.lesson_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private List<Product> products;



    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    private void initProducts() {
        products = new ArrayList<>(Arrays.asList(
                new Product(),
                new Product(),
                new Product(),
                new Product(),
                new Product(),
                ));
    }

    @Override
    public Product getProductById() {
        return null;
    }
}
