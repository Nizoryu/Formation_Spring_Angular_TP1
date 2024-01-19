package com.inti.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Oeuvre;
import com.inti.service.IOeuvreService;

@Controller
@RequestMapping("api/oeuvre")
public class OeuvreController {

	@Autowired
	private IOeuvreService iOeuvreService;

	@GetMapping("getAllOeuvre")
	public String getAllOeuvre(Model m) {
		List<Oeuvre> listOeuvres = iOeuvreService.getAllOeuvre();

		m.addAttribute("listOeuvres", listOeuvres);

		return "listeOeuvre";
	}
	
	@GetMapping("formulaire")
	public String getFormulaire() {
		return "formulaireOeuvre";
	}
	
	@PostMapping("saveOeuvre")
	public String saveOeuvre(@ModelAttribute("oeuvre") Oeuvre oeuvre) {

		iOeuvreService.saveOeuvre(oeuvre);
		return "redirect:getAllOeuvre";
	}
	
	@PostMapping("getOeuvreById")
	public String getOeuvreById(@RequestParam("id") Long id, Model model) {
		
		List<Oeuvre> listOeuvre = new ArrayList<>(Arrays.asList(iOeuvreService.getOeuvre(id)));
				
		model.addAttribute("listOeuvres",listOeuvre);
		
		return "listeOeuvre";
	}
	
	@PostMapping("getOeuvreByName")
	public String getOeuvreByName(@RequestParam("nom") String nom, Model model) {
	
		 List<Oeuvre> listOeuvre = iOeuvreService.getOeuvreByName(nom);
		
		model.addAttribute("listOeuvres",listOeuvre);
		
		return "listeOeuvre";
	}
}
