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
	public String addSubstractDate(Model m,@RequestParam String date1, @RequestParam String date2,String operation ) throws ParseException
	{
		
		Date1 d = new Date1();
		if(operation.equals("add"))
			m.addAttribute("date","Ans" +d.addDate(date1, date2));
		else
			m.addAttribute("date","Ans "+d.substractDate(date1, date2));
		
		return  "index";
	}
	@RequestMapping("calculate2")
	public String addSubstractDate(Model m,@RequestParam String date3, @RequestParam int days,@RequestParam int months,@RequestParam int weeks,String operation1 ) throws ParseException
	{
		
		Date1 d = new Date1();
		if(operation1.equals("add"))
			m.addAttribute("date4", d.addDays(date3, days, weeks, months));
		else
			m.addAttribute("date4","Ans "+d.substractDays(date3, days, weeks, months) );
		
		return  "index";
	}
	
	@RequestMapping("calculate3")
	public String dayOfWeek(Model m,@RequestParam String date) throws ParseException
	{
		Date1 d=new Date1();
		m.addAttribute("week",d.dayOfWeek(date));
		return "index";
	}
	@RequestMapping("calculate4")
	public String weekNumber(Model m,@RequestParam String date) throws ParseException
	{
		Date1 d=new Date1();
		m.addAttribute("weekNumber",d.weekNumber(date));
		return "index";
	}
	
}
