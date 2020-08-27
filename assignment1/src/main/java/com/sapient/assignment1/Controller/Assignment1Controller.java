package com.sapient.assignment1.Controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.assignment1.Date1;

@Controller
public class Assignment1Controller 
{
	@GetMapping({"/","/index"})
	public String home(Model model)
	{
		return "index";
	}
	@RequestMapping("calculate1")
	public String add(Model m,@RequestParam String date1, @RequestParam String date2,String operation ) throws ParseException{
		
		Date1 d = new Date1();
		if(operation.equals("add"))
			m.addAttribute("date",d.addDate(date1, date2));
		else
			m.addAttribute("date",d.substractDate(date1, date2));
		
		return  "index";
	}
}
