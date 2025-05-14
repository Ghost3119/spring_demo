package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(long id){
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product update(Product product){
        if (productRepository.existsById(product.getId())) {
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
    }

    public void deleteById(long id){
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("El producto con el ID especificado no existe.");
        }
        productRepository.deleteById(id);
    }
}
