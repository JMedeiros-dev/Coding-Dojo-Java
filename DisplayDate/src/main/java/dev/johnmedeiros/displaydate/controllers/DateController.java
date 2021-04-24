package dev.johnmedeiros.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new java.util.Date();
		String strdate = String.format(" %1$tA, the %1$te of %1$tB  %1$tY", date);
		
		model.addAttribute("date", strdate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date time = new java.util.Date();
		SimpleDateFormat t = new SimpleDateFormat("hh:mm a");
		String strtime = t.format(time);
		model.addAttribute("time", strtime);
		return "time.jsp";
	}
}
