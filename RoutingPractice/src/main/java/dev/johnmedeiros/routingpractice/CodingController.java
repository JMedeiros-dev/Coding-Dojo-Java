package dev.johnmedeiros.routingpractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String HelloCoding() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String PythonDjango() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("/java")
	public String JavaSpring() {
		return "Java/Spring is better!";
	}
}

