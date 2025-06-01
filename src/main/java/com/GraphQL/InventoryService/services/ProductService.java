package com.GraphQL.InventoryService.services;

import com.GraphQL.InventoryService.entities.ProductEntity;
import com.GraphQL.InventoryService.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductEntity> getProducts() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getProductsByCategory(@PathVariable String category){
        return productRepository.findByCategory(category);
    }
}
