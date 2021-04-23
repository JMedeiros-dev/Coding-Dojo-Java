package dev.johnmedeiros.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CounterController {
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
        return "counter.jsp";
	}
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count = count + 1;
		session.setAttribute("count", count);
        return "index.jsp";
	}
	
	@RequestMapping("/by-two")
	public String byTwo(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count = count + 2;
		session.setAttribute("count", count);
        return "byTwo.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
        return "redirect:/counter";
	}

}
