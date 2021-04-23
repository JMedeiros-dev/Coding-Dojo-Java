package dev.johnmedeiros.thecode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		return "index.jsp";
	}
	
	@RequestMapping(value="/secret_code", method=RequestMethod.POST)
	public String secretCode(@RequestParam(value="magicWord") String magicWord, HttpSession session, RedirectAttributes redirectAttributes) {
		session.setAttribute("magicWord", magicWord);
		if (magicWord.equals("bushido")) {
			return "redirect:/code";			
		} else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/code")
	public String theCode() {
		return "code.jsp";
	}
	
}
