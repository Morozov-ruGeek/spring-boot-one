package ru.geekbrains.spring.lesson_2.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.lesson_2.model.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository implements IProductRepository {

    private List<Product> products;

    @PostConstruct
    private void initProducts() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "pants", 150),
                new Product(2L, "jeans", 120),
                new Product(3L, "shorts", 70),
                new Product(4L, "tights", 85),
                new Product(5L, "breeches", 75)
        ));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Optional<Product> findOneById(Long id) {
        for (Product s : products) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }
}
