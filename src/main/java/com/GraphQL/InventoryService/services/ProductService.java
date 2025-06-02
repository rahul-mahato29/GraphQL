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

    //sales team : update the stock of a product in inventory service
    public ProductEntity updateStock(Long id, int quantity){
        ProductEntity product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id : {}"+id));
        product.setStock(quantity);
        return productRepository.save(product);
    }

    //warehouse : receive new shipment, update in db
    public ProductEntity receivedNewShipment(Long id, Integer quantity){
        ProductEntity existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id : {}"+id));
        existingProduct.setStock(existingProduct.getStock() + quantity);
        return productRepository.save(existingProduct);
    }
}
