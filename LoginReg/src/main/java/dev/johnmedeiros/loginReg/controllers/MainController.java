package dev.johnmedeiros.loginReg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.johnmedeiros.loginReg.models.User;
import dev.johnmedeiros.loginReg.services.UserService;
import dev.johnmedeiros.loginReg.validator.UserValidator;

@Controller
public class MainController {
	
	private final UserService userService;
	private final UserValidator userValidator;
	 
	 public MainController(UserService userService, UserValidator userValidator) {
	     this.userService = userService;
	     this.userValidator = userValidator;
	 }
	 
	 //==================================================================
	 // REGISTRATION ROUTES
	 //==================================================================
	 
	 
	 
	 @RequestMapping("/")
	 public String registerForm(Model model) {
		 model.addAttribute("user", new User());
	     return "index.jsp";
	 }
	 
	 
	 @RequestMapping(value="/registration", method=RequestMethod.POST)
	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		 userValidator.validate(user, result);
		 if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            User u = userService.registerUser(user);
	            session.setAttribute("userId", u.getId());
	            return "redirect:/dashboard";
	        }
	    }
	
	 
	 //==================================================================
	 // LOGIN ROUTE
	 //==================================================================
	 
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirect) {
	     if(userService.authenticateUser(email, password)) {
	    	 User u = userService.findByEmail(email);
	         session.setAttribute("userId", u.getId());
	         return "redirect:/dashboard";
	     } else {
	    	 redirect.addFlashAttribute("error", "Invalid Login Credentials");
	    	 return "redirect:/";
	     }

	 }
	 
	 
	 //==================================================================
	 // DASHBOARD
	 //==================================================================
	 
	 @RequestMapping("/dashboard")
	 public String home(HttpSession session, Model model, RedirectAttributes redirect) {
		 Long userId = (Long) session.getAttribute("userId");
		 if(userId == null) {
				redirect.addFlashAttribute("please", "Please Login or Register before entering the site");
				return "redirect:/";
			}
		 model.addAttribute("user", userService.findUserById(userId));
	     return "dashboard.jsp";
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

