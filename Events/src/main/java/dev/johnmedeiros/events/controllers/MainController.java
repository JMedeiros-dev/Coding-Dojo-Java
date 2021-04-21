package dev.johnmedeiros.events.controllers;

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

import dev.johnmedeiros.events.models.Event;
import dev.johnmedeiros.events.models.Message;
import dev.johnmedeiros.events.models.User;
import dev.johnmedeiros.events.services.EventService;
import dev.johnmedeiros.events.services.MessageService;
import dev.johnmedeiros.events.services.UserService;
import dev.johnmedeiros.events.validators.UserValidator;



@Controller
public class MainController {
	
	private final UserService userService;
	private final UserValidator userValidator;
	private final EventService eventService;
	private final  MessageService messageService;
	 
	 public MainController(UserService userService, UserValidator userValidator, EventService eventService, MessageService messageService) {
	     this.userService = userService;
	     this.userValidator = userValidator;
	     this.eventService = eventService;
	     this.messageService = messageService;
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
	     List<Event> events = eventService.allEvents();
		 if(userId == null) {
				redirect.addFlashAttribute("please", "Please Login or Register before entering the site");
				return "redirect:/";
			}
		 model.addAttribute("user", userService.findUserById(userId));
		 model.addAttribute("events", events);
		 model.addAttribute("event", new Event());
	     return "Dashboard.jsp";
	 }
	 
	 
	 
	 //==================================================================
	 // NEW EVENT
	 //==================================================================
	 
	 
	 @RequestMapping(value="/events", method=RequestMethod.POST)
	    public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model) {
		 List<Event> events = eventService.allEvents();
		 Long userId = (Long) session.getAttribute("userId");
	        if (result.hasErrors()) {
	   		 model.addAttribute("user", userService.findUserById(userId));
	   		 model.addAttribute("events", events);
	            return "Dashboard.jsp";
	        } else {
	            eventService.createEvent(event);
	            return "redirect:/dashboard";
	        }
	    }
	 
	 
	 
	 //==================================================================
	 // EVENTS ROUTES
	 //==================================================================
	 
	 @RequestMapping("/events/{id}")
		public String Song(@PathVariable("id") Long id, Model model, HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
		 Event event = eventService.findEvent(id);
		 List<Message> messages = event.getMessages();
		 	model.addAttribute("user", userService.findUserById(userId));
			model.addAttribute("event", event);
			model.addAttribute("messages", messages);
			model.addAttribute("message", new Message()); 
			return "event.jsp";
		}
	 
	 
		@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	    public String destroy(@PathVariable("id") Long id) {
	        eventService.deleteEvent(id);
	        return "redirect:/dashboard";
	    }
		
		 @RequestMapping("/events/{id}/edit")
		    public String edit(@PathVariable("id") Long id, Model model) {
		        Event event = eventService.findEvent(id);
		        model.addAttribute("event", event);
		        return "edit.jsp";
		    }
		    
		    @RequestMapping(value="/event/{id}", method=RequestMethod.PUT)
		    public String update(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		        if (result.hasErrors()) {
		            return "edit.jsp";
		        } else {
		            eventService.createEvent(event);
		            return "redirect:/dashboard";
		        }
		    }
		    
		    
		    
	//==================================================================
	// JOIN ROUTE
	//==================================================================
	 
		    @RequestMapping("/events/join/{id}")
			public String joinEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
				
				
				Long userId = (Long) session.getAttribute("userId");
				User u = userService.findUserById(userId);
				Event event = eventService.findEvent(id);
				
				List<User> attendees = event.getAttendees();
				
				attendees.add(u);
				
				event.setAttendees(attendees);
				
				eventService.createEvent(event);
				
				return "redirect:/dashboard";
			}
		    
		    
		    
	//==================================================================
	// CANCEL ROUTE
	//==================================================================
			 
		    @RequestMapping("/events/cancel/{id}")
			public String leaveEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
				
				
				Long userId = (Long) session.getAttribute("userId");
				User u = userService.findUserById(userId);
				Event event = eventService.findEvent(id);
				
				List<User> attendees = event.getAttendees();
				
				attendees.remove(u);
				
				event.setAttendees(attendees);
				
				eventService.createEvent(event);
				
				return "redirect:/dashboard";
			}
		    
	 
		    
	//==================================================================
	// MESSAGE ROUTES
	//==================================================================	    
		    
		    @RequestMapping(value="/addComment", method=RequestMethod.POST)
		    public String addComment(@Valid @ModelAttribute("message") Message message, BindingResult result) {
		        if (result.hasErrors()) {
		            return "redirect:/events/{id}";
		        } else {
		        	messageService.saveMessage(message);
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

