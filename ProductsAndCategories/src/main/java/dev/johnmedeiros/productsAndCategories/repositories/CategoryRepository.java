package dev.johnmedeiros.productsAndCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.johnmedeiros.productsAndCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	// this method retrieves all the products from the database
    List<Category> findAll();
    
    //this method finds a product by ID
  	Optional<Category> findById(Long id);
}
