package com.GraphQL.InventoryService.controllers;

import com.GraphQL.InventoryService.entities.ProductEntity;
import com.GraphQL.InventoryService.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductControllers {

    private final ProductService service;

    @QueryMapping
    private List<ProductEntity> getProducts() {
        return service.getProducts();
    }

    @QueryMapping
    private List<ProductEntity> getProductsByCategory(@Argument String category) {
        return service.getProductsByCategory(category);
    }

    @MutationMapping
    private ProductEntity updateStock(@Argument Long id, @Argument int stock) {
        return service.updateStock(id, stock);
    }

    @MutationMapping
    private ProductEntity receivedNewShipment(@Argument Long id, @Arguments int quantity) {
        return service.updateStock(id, quantity);
    }
}
