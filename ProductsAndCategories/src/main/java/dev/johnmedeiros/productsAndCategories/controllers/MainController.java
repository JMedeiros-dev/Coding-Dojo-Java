package dev.johnmedeiros.productsAndCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dev.johnmedeiros.productsAndCategories.models.Category;
import dev.johnmedeiros.productsAndCategories.models.CategoryProduct;
import dev.johnmedeiros.productsAndCategories.models.Product;
import dev.johnmedeiros.productsAndCategories.services.CategoryService;
import dev.johnmedeiros.productsAndCategories.services.ProductService;

@Controller
public class MainController {
	
	 private final ProductService productService;
	 private final CategoryService categoryService;
	    
	    public MainController(ProductService productService, CategoryService categoryService) {
	        this.productService = productService;
	        this.categoryService = categoryService;
	    }
	    
	    // ======================================================================
	    //  MAIN ROUTE
	    // ======================================================================
	    
	    @RequestMapping("/")
	    public String dashboard(Model model) {
	    	List<Product> products = productService.allProducts();
	    	List<Category> categories = categoryService.allCategories();
	        model.addAttribute("products", products);
	        model.addAttribute("categories", categories);
	    	
	    	return "dashboard.jsp";
	    }
	    
	    
	    
	    
	    // ======================================================================
	    //  PRODUCT ROUTES
	    // ======================================================================
	    
	    @RequestMapping("/products/new")
		public String newProduct(Model model) {
			model.addAttribute("product", new Product());
			return "productsNew.jsp";
		}

	    @RequestMapping(value="/products", method=RequestMethod.POST)
	    public String createProduct(@Valid @ModelAttribute("product") Product product, 	BindingResult result) {
	        if (result.hasErrors()) {
	            return "productsNew.jsp";
	        } else {
	        	productService.saveProduct(product);
	            return "redirect:/";
	        }
	    }
	    
	    @RequestMapping("/products/{id}")
	    public String productShow(@PathVariable("id") Long id, Model model) {
	    	Product product = productService.findProduct(id);
	    	model.addAttribute("product", product);
	    	List<Category> categories = categoryService.allCategories();
	        model.addAttribute("categories", categories);
	    	
	    	return "productsShow.jsp";
	    }
	    
	    @RequestMapping(value="/products/addCategory", method=RequestMethod.POST)
	    public String addCategory(@RequestParam(value="product_id") Long product_id,
	    		@RequestParam(value="category_id") Long category_id) {
	    	
	    	Category c = categoryService.findCategory(category_id);
	    	Product p = productService.findProduct(product_id);
	    	
	    	CategoryProduct cp = new CategoryProduct(c, p);
	    	
	    	productService.saveRelationship(cp);
	    	
	    	return "redirect:/";
	    }
	    
	    
	    
	    // ======================================================================
	    //  CATEGORY ROUTES
	    // ======================================================================
	    
	    @RequestMapping("/categories/new")
		public String newCategory(Model model) {
			model.addAttribute("category", new Category());
			return "categoriesNew.jsp";
		}

	    @RequestMapping(value="/categories", method=RequestMethod.POST)
	    public String createCategory(@Valid @ModelAttribute("category") Category category, 	BindingResult result) {
	        if (result.hasErrors()) {
	            return "categoriesNew.jsp";
	        } else {
	        	categoryService.saveCategory(category);
	            return "redirect:/";
	        }
	    }
	    
	    
	    @RequestMapping("/categories/{id}")
	    public String categoryShow(@PathVariable("id") Long id, Model model) {
	    	Category category = categoryService.findCategory(id);
	    	model.addAttribute("category", category);
	    	List<Product> products = productService.allProducts();
	        model.addAttribute("products", products);
	    	
	    	return "categoriesShow.jsp";
	    }
	   
	    
	    @RequestMapping(value="/categories/addProduct", method=RequestMethod.POST)
	    public String addProduct(@RequestParam(value="category_id") Long category_id,
	    		@RequestParam(value="product_id") Long product_id) {
	    	
	    	Category c = categoryService.findCategory(category_id);
	    	Product p = productService.findProduct(product_id);
	    	
	    	CategoryProduct cp = new CategoryProduct(c, p);
	    	
	    	categoryService.saveRelationship(cp);
	    	
	    	return "redirect:/";
	    }

}
