package dev.johmedeiros.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class Hello {
	@RequestMapping("/")
	public String index(@RequestParam(value="firstName", required=false) String firstName, String lastName) {
		if(firstName == null && lastName == null) {
			return "Hello Human!";
		} else {
			return "Hello " + firstName + " " + lastName;
		}
	}
}
