package dev.johnmedeiros.productsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.johnmedeiros.productsAndCategories.models.CategoryProduct;
import dev.johnmedeiros.productsAndCategories.models.Product;
import dev.johnmedeiros.productsAndCategories.repositories.CategoryProductRepository;
import dev.johnmedeiros.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	
private final ProductRepository productRepository;
private final CategoryProductRepository categoryProductRepository;
    
    public ProductService(ProductRepository productRepository, CategoryProductRepository categoryProductRepository) {
        this.productRepository = productRepository;
        this.categoryProductRepository = categoryProductRepository;
    }
    
    // returns all the products
    public List<Product> allProducts() {
        return productRepository.findAll();
    }
    
    // saves/updates a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    
    
    // retrieves a product
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
    // create relationship b/w products and categories
    public CategoryProduct saveRelationship(CategoryProduct cp) {
    	return categoryProductRepository.save(cp);
    }
    

}
