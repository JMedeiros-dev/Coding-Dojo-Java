package dev.johnmedeiros.productsAndCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.productsAndCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	// this method retrieves all the products from the database
    List<Product> findAll();
    
    //this method finds a product by ID
  	Optional<Product> findById(Long id);

}
