package com.amdocs.springwebapp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.springwebapp.Employee;

@Controller
public class MVCController {
	
	@Autowired
	RestTemplate rt;
	final String url="http://localhost:8080/";
	
	@RequestMapping("/home")
	public ModelAndView getHome()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/show")
	public ModelAndView showAll()
	{
		ModelAndView mv = new ModelAndView();
		List<Employee> obj = Arrays.asList(rt.getForObject(url, Employee[].class));
		mv.addObject("List", obj);
		mv.setViewName("show");
		return mv;
	}
	
	@RequestMapping("/putdata")
	public ModelAndView getPost()
	{
		ModelAndView mv = new ModelAndView();
		List<Employee> obj = Arrays.asList(rt.getForObject(url, Employee[].class));
		mv.addObject("List", obj);
		mv.setViewName("putdata");
		return mv;
	}
	

	@RequestMapping("/delete")
	public ModelAndView delete()
	{
		ModelAndView mv = new ModelAndView();
		List<Employee> obj = Arrays.asList(rt.getForObject(url, Employee[].class));
		mv.addObject("List", obj);
		mv.setViewName("delete");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("update");
		return mv;
	}

	@RequestMapping(value="/update/emp")
	public ModelAndView updatedata(@ModelAttribute("employee") Employee employee)
	{
		ModelAndView mv = new ModelAndView();
		rt.put(url+"emp", employee);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/postdata/")
	public ModelAndView postdata(@ModelAttribute("employee") Employee employee)
	{
		ModelAndView mv = new ModelAndView();
		rt.postForObject(url+"", employee, Employee.class);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/del")
	public ModelAndView deleteId(HttpServletRequest request)
	{
		String id = request.getParameter("id");
		ModelAndView mv = new ModelAndView();
		rt.delete(url +"/" + id);
		mv.setViewName("home");
		return mv;
	}

}
