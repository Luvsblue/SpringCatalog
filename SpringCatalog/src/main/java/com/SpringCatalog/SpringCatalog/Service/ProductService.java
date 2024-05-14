package com.SpringCatalog.SpringCatalog.Service;

import com.SpringCatalog.SpringCatalog.Entity.Product;
import com.SpringCatalog.SpringCatalog.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
