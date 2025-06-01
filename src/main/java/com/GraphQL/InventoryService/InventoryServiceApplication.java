package com.GraphQL.InventoryService;

import com.GraphQL.InventoryService.entities.ProductEntity;
import com.GraphQL.InventoryService.repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class InventoryServiceApplication {

	private final ProductRepository productRepository;

	@PostConstruct
	public void initDB() {
		List<ProductEntity> products = Stream.of(
			new ProductEntity("Laptop", "Electronics", 80000.50f, 5),
			new ProductEntity("Smart Phone", "Electronics", 40000.50f, 15),
			new ProductEntity("Office Chair", "Furniture", 8000.50f, 50),
			new ProductEntity("Notebook", "Stationary", 99.00f, 10),
			new ProductEntity("Water Bottle", "Accessories", 150.00f, 8)
		).toList();

		productRepository.saveAll(products);
	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
