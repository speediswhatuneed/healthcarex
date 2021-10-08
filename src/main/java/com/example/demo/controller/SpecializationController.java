package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Specialization;
import com.example.demo.service.ISpecializationService;
import com.example.demo.seviceimpl.SpecialziationImp;

@Controller
@RequestMapping("/spec")
public class SpecializationController {
	
	/**** 
	 * 1/ show Register page
	 */
	
	@GetMapping("/register")
	public String displayRegister()
	{
		return "SpecializationRegister";
	}
	
	@Autowired
	private SpecialziationImp service;
	
	@GetMapping(value = "/all")
	public String viewAll(Model model)
	
	{
		List<Specialization> list = service.getAllSpecializations();
		model.addAttribute("list", list);
		return "SpecializationData";
	}
	
	@PostMapping(value ="/save")
	public String saveForm(
			@ModelAttribute Specialization specialization,
			Model model)
	{
		System.out.println("inside save form");
		Long id = service.saveSpecialization(specialization);
		String message2 ="Record("+id+") is created";
		model.addAttribute("message", message2);
		return "SpecializationRegister";
		
	}
	

}
