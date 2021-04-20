package dev.johnmedeiros.ninjagame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
	
	public ArrayList<String> activities  = new ArrayList<String>();
	
	@RequestMapping("/")
	public String ninjaGame(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		
		if( session.getAttribute("count") == null) {
			
			session.setAttribute("count", 0);
		}
		
		model.addAttribute("activities", activities);
		
		return "index.jsp";
	}
	
	
	//=======================================================//
	//				      Get Gold Route					 //
	//=======================================================//	
	
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="getGold") String getGold, HttpSession session, Model model) {
		
		Integer count = (Integer) session.getAttribute("count");
		Random r = new Random();
		Date date = new Date();
		String strdate = String.format("%1$tB, %1$te  %1$tY %1$tI:%1$tM %1$tp", date);
		String text = "You entered a ";
		String gained = "gained ";
		int n = 0; 
		session.setAttribute("color", "success");
		
		
		if(getGold.equals("farm")) {
			
			n = r.nextInt(11) + 10;
			count = count + n;
			text += "farm and " + gained + n + " gold. (" + strdate + ")";
			activities.add(text);
			
			
		} else if(getGold.equals("cave")) {
			
			n = r.nextInt(6) + 5;
			count = count + n;
			text += "cave and " + gained + n + " gold. (" + strdate + ")";
			activities.add(text);
		
		} else if(getGold.equals("house")) {
			n = r.nextInt(4) + 2;
			count = count + n;
			text += "house and " + gained + n + " gold. (" + strdate + ")";
			activities.add(text);
		
		} else if(getGold.equals("casino")) {
			n = r.nextInt(101) - 50 ;
				
			if(n < 0) {
				gained = "lost ";
				session.setAttribute("color", "danger");
			}
			count = count + n;
			text += "casino and " + gained + n + " gold. (" + strdate + ")";
			activities.add(text);
		}
		
		session.setAttribute("count", count);
		return "redirect:/";
	}

	
	//=======================================================//
	//				      Clear Count Route					 //
	//=======================================================//	
	
	@RequestMapping("/clear")
	public String clearCount(HttpSession session) {
		session.invalidate();
		activities.clear();
		return "redirect:/";
	}
	
}
