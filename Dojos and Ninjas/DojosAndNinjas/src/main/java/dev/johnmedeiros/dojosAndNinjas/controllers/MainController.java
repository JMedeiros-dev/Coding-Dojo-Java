package dev.johnmedeiros.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.johnmedeiros.dojosAndNinjas.models.Dojo;
import dev.johnmedeiros.dojosAndNinjas.models.Ninja;
import dev.johnmedeiros.dojosAndNinjas.services.DojoService;
import dev.johnmedeiros.dojosAndNinjas.services.NinjaService;



@Controller
public class MainController {

	 private final DojoService dojoService;
	 private final NinjaService ninjaService;
	    
	 public MainController(DojoService dojoService, NinjaService ninjaService) {
		 this.dojoService = dojoService;
		 this.ninjaService = ninjaService;
	    }


	//============================= 
	//		Dojo Routes
	//=============================	
	
	@RequestMapping("/dojos/new")
	public String newDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "index.jsp";
	}
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }
	
	@RequestMapping("/dojos/{id}")
    public String index(@PathVariable("id") Long id,Model model) {
        Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
        return "dojoShow.jsp";
    }
	
	//============================= 
	//		Ninja Routes
	//=============================	

	@RequestMapping("/ninjas/new")
	public String newNinja(Model model) {
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
		model.addAttribute("ninja", new Ninja());
		return "ninja.jsp";
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
            return "ninja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
    }
}
