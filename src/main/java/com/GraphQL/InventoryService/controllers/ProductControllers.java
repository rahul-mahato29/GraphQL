package com.GraphQL.InventoryService.controllers;

import com.GraphQL.InventoryService.entities.ProductEntity;
import com.GraphQL.InventoryService.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductControllers {

    private final ProductService service;

    @GetMapping
    private List<ProductEntity> getProducts() {
        return service.getProducts();
    }

    @GetMapping(path = "/{category}")
    private List<ProductEntity> getProductsByCategory(@PathVariable  String category) {
        return service.getProductsByCategory(category);
    }
}
