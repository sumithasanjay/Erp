package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Employee;
import com.example.demo.service.ErpService;
import com.example.demo.service.ErpServiceImpl;



@RestController
public class ErpController {

	@Autowired

 private ErpService erpservice;
	
	@GetMapping("/")
	public ModelAndView home() {
	ModelAndView m=new ModelAndView();
	m.setViewName("home");
	return m;
	}
	@GetMapping("/customer")
	public ModelAndView customer(Model model) {
		ModelAndView mv1=new ModelAndView();
		mv1.setViewName("customer");
		model.addAttribute("employees", erpservice.findAll());
	return mv1;
	}
	@GetMapping("/employee/create")
	public ModelAndView create(Model model) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("form");
		model.addAttribute("employee", new Employee());
	    return mv;
	}
	@RequestMapping(value="/employee/save",method=RequestMethod.POST)
	public ModelAndView save(@Valid Employee employee, BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) {
			ModelAndView mv=new ModelAndView("form");
			return mv;
		}
		erpservice.save(employee);
		ModelAndView n=new ModelAndView("redirect:/customer");
		redirect.addFlashAttribute("success", "Saved Employee Successfully!");
		return n;
	}
	
	@GetMapping("/employee/search")
	public ModelAndView search(@RequestParam("s") String s) {
		if (s.equals("")) {
			ModelAndView k= new ModelAndView("redirect:/customer");
			return k;
		}
				ModelAndView v= new ModelAndView("customer");
	v.addObject("employees", erpservice.search(s));
		return v;

	}
	
	
	@GetMapping("/employee/{id}/delete")
	public ModelAndView delete(@PathVariable int id,RedirectAttributes redirect) {
		erpservice.delete(id);
		ModelAndView s=new ModelAndView("redirect:/customer");
		redirect.addFlashAttribute("success","Deleted Successfully!");
		return s;
	}
	
	

}
