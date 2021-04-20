package dev.johnmedeiros.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.johnmedeiros.relationships.models.License;
import dev.johnmedeiros.relationships.models.Person;
import dev.johnmedeiros.relationships.services.LicenseService;
import dev.johnmedeiros.relationships.services.PersonService;

@Controller
public class MainController {
	
private final PersonService personService;
private final LicenseService licenseService;
	public MainController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	Integer count = 000000;
	
	// New Person Page	
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person, Model model) {
		return "persons.jsp";
	}
	
	//Person Show Page	
	
	@RequestMapping("/persons/{id}")
	public String personShow(@PathVariable("id") Long id, Model model) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "show.jsp";
		}
	
	// New License Page	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
		return "license.jsp";
	}
	
	// New Person Route	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String create(@ModelAttribute("person") Person person, BindingResult result) {
		personService.createPerson(person);
		return "redirect:/licenses/new";
	}
	
	// New License Route
	@RequestMapping(value="/license", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        	count = count +1;
        	String number = String.valueOf(count);
        	license.setNumber(number);
        	licenseService.createLicense(license);
        	return "redirect:/persons/new";
        }
	}

