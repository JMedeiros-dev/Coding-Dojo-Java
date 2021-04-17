package dev.johnmedeiros.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.productsAndCategories.models.Category;
import dev.johnmedeiros.productsAndCategories.models.CategoryProduct;
import dev.johnmedeiros.productsAndCategories.repositories.CategoryProductRepository;
import dev.johnmedeiros.productsAndCategories.repositories.CategoryRepository;


@Service
public class CategoryService {
	
private final CategoryRepository categoryRepository;
private final CategoryProductRepository categoryProductRepository;
    
    public CategoryService(CategoryRepository categoryRepository, CategoryProductRepository categoryProductRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryProductRepository = categoryProductRepository;
    }
    
    // returns all the categories
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }
    
    // saves/updates a category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    // retrieves a product
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
    
   
    // create relationship b/w products and categories
    public CategoryProduct saveRelationship(CategoryProduct cp) {
    	return categoryProductRepository.save(cp);
    }

}
