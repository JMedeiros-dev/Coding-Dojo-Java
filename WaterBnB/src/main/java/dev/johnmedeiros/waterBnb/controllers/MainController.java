package dev.johnmedeiros.waterBnb.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.johnmedeiros.waterBnb.models.Listing;
import dev.johnmedeiros.waterBnb.models.Review;
import dev.johnmedeiros.waterBnb.models.User;
import dev.johnmedeiros.waterBnb.services.ListingService;
import dev.johnmedeiros.waterBnb.services.ReviewService;
import dev.johnmedeiros.waterBnb.services.UserService;
import dev.johnmedeiros.waterBnb.validator.UserValidator;

@Controller
public class MainController {
	
	private final UserService userService;
	private final UserValidator userValidator;
	private final ListingService listingService;
	private final ReviewService reviewService;
	
	public MainController(UserService userService, UserValidator userValidator, ListingService listingService, ReviewService reviewService) {
	    this.userService = userService;
	    this.userValidator = userValidator;
	    this.listingService = listingService;
	    this.reviewService = reviewService;
	 }

	
//=========================================================
// LANDING ROUTES
//=========================================================
	
	
	@RequestMapping("/")
	public String landingPage() {
		return "index.jsp";
	}


//==================================================================
// SIGN UP ROUTES
//==================================================================
	 
	 
	 @RequestMapping("/registration")
	 public String registerForm(Model model) {
		 model.addAttribute("user", new User());
	     return "signin.jsp";
	 }
	 
	 
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 userValidator.validate(user, result);
		 if (result.hasErrors()) {
	            return "signin.jsp";
	   } else {
		   User u = userService.registerUser(user);
	       session.setAttribute("userId", u.getId());
	       String type = u.getType();
	       System.out.println(type);;
	       if(type.equals("host")) {
	    	   return "redirect:/dashboard";	
	     } else {
		       return "redirect:/search";
	            }
	        }
	    }
	
	 
	 //==================================================================
	 // LOGIN ROUTE
	 //==================================================================
	 
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirect) {
	     
		 if(userService.authenticateUser(email, password)) {
	    	 User u = userService.findByEmail(email);
	    	 String type = u.getType();
	         System.out.println(type);
	         session.setAttribute("userId", u.getId());
	         if(type.equals("host")) {
	           return "redirect:/dashboard";	
	         } else {
	           return "redirect:/search"; 
	         }
	     } else {
	    	 redirect.addFlashAttribute("error", "Invalid Login Credentials");
	    	 return "redirect:/registration";
	     }

	 }
	 
	 
	 //==================================================================
	 // GUEST SEARCH PAGE ROUTES
	 //==================================================================


		@RequestMapping("/search")
		 public String searchPage(HttpSession session, Model model, RedirectAttributes redirect) {
			 Long userId = (Long) session.getAttribute("userId");
			  User u = userService.findUserById(userId);
			  String type = u.getType();
				 if(userId == null || type.equals("host")) {
					redirect.addFlashAttribute("please", "Please Sign in as a guest to access this page");
					return "redirect:/";
				}
			 model.addAttribute("user", userService.findUserById(userId));
		     return "search.jsp";
		 }
		
		
		@RequestMapping(value="/search", method=RequestMethod.POST)
	    public String newsearch(@RequestParam(value="address") String address, Model model) {
			List<Listing> results = listingService.searchListing(address);
			model.addAttribute("results", results);
	            return "results.jsp";
	    }
		

		
	 //==================================================================
	 // LISTINGS
	 //==================================================================
		
		 @RequestMapping("/listings/{id}")
		    public String showListing(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirect) {
			 Long userId = (Long) session.getAttribute("userId");
			  User u = userService.findUserById(userId);
			  String type = u.getType();
				 if(userId == null || type.equals("host")) {
					redirect.addFlashAttribute("please", "Please Sign in as a guest to access this page");
					return "redirect:/";
				}
			 	Listing listing = listingService.findListing(id);
		        model.addAttribute("listing", listing);
		        return "listing.jsp";
		    }

	//==================================================================
	  // REVIEW ROUTES
	  //==================================================================
		 
		  @RequestMapping("/listings/{id}/review")
			public String review(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirect) {
			  Long userId = (Long) session.getAttribute("userId");
			  User u = userService.findUserById(userId);
			  String type = u.getType();
				 if(userId == null || type.equals("host")) {
						redirect.addFlashAttribute("please", "Sorry only guests are allowed to leave reviews");
						return "redirect:/";
				 }
				Listing listing = listingService.findListing(id);
				model.addAttribute("listing", listing);
				 model.addAttribute("user", userService.findUserById(userId));
				model.addAttribute("review", new Review());
				return "review.jsp";
			}
		 
		 @RequestMapping(value="/listings/add_review", method=RequestMethod.POST)
		    public String addReview(@Valid @ModelAttribute("review") Review review, BindingResult result, HttpSession session) {
		        if (result.hasErrors()) {
		            return "review.jsp";
		        } else {
		            reviewService.saveReview(review);
		            return "redirect:/search";
		        }
		    }
		 

	 //==================================================================
	 // DASHBOARD ROUTE
	 //==================================================================
	
		@RequestMapping("/dashboard")
		 public String dashboard(HttpSession session, Model model, RedirectAttributes redirect) {
			Long userId = (Long) session.getAttribute("userId");
			  User u = userService.findUserById(userId);
			  String type = u.getType();
				 if(userId == null || type.equals("guest")) {
					redirect.addFlashAttribute("please", "Please Login or Register before entering the site");
					return "redirect:/";
				}
			 model.addAttribute("user", userService.findUserById(userId));
			 model.addAttribute("listing", new Listing());
		     return "dashboard.jsp";
		 }

		
		
	 //==================================================================
	 // NEW LISTING ROUTE
	 //==================================================================	
		
		 @RequestMapping(value="/dashboard/new_listing", method=RequestMethod.POST)
		    public String createAuthor(@Valid @ModelAttribute("listing") Listing listing, BindingResult result) {
		        if (result.hasErrors()) {
		            return "dashboard.jsp";
		        } else {
		            listingService.saveListing(listing);
		            return "redirect:/dashboard";
		        }
		    }
		
		 
		 
	 //==================================================================
	 // EDIT LISTING ROUTE
	 //==================================================================
		
		 @RequestMapping("/listings/edit/{id}")
		    public String editListing(@PathVariable("id") Long id, Model model, HttpSession session, RedirectAttributes redirect) {
			 Long userId = (Long) session.getAttribute("userId");
			  User u = userService.findUserById(userId);
			  String type = u.getType();
			 if(userId == null || type.equals("guest")) {
					redirect.addFlashAttribute("please", "Please Login or Register before entering the site");
					return "redirect:/";
				}
			 	Listing listing = listingService.findListing(id);
		        model.addAttribute("listing", listing);
		        return "editListing.jsp";
		    }
		    
		    @RequestMapping(value="/listings/edit/{id}", method=RequestMethod.PUT)
		    public String updateListing(@Valid @ModelAttribute("listing") Listing listing, BindingResult result) {
		        if (result.hasErrors()) {
		            return "editListing.jsp";
		        } else {
		            listingService.saveListing(listing);
		            return "redirect:/dashboard";
		        }
		    }
		 
		 
		 
		 
	 //==================================================================
	 // LOGOUT ROUTES
	 //==================================================================
	 
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
			return "redirect:/";
	 }
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
