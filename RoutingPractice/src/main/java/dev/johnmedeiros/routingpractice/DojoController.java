package dev.johnmedeiros.routingpractice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DojoController {
	
	@RequestMapping("{dojo}/{burbank-dojo}/{san-jose}")
	public String Dojo(@PathVariable("dojo") String dojo,  @PathVariable("burbank-dojo") String burbank, @PathVariable("san-jose") String SJ ){
		
		dojo =  "The dojo is awesome! ";
		burbank = "Burbank Dojo is located in Southern California. ";
		SJ = "SJ dojo is the headquarters." ;
			
		
		return dojo + burbank +  SJ;	
		}

	
}
