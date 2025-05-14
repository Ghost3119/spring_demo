package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable long id){
        return productService.findById(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        productService.deleteById(id);
    }
}
