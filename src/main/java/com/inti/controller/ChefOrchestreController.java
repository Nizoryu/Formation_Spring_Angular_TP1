package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *  @author Karim.K
 *  
 *  Controller pour Chef D'orchestre
 */

import com.inti.model.ChefOrchestre;
import com.inti.repository.IOeuvreRepository;
import com.inti.service.IChefOrchestreService;

@Controller
@RequestMapping("/api/cheforchestre")
public class ChefOrchestreController {

	@Autowired
	private IChefOrchestreService iOrchestreService;
	
	@Autowired
	private IOeuvreRepository iOeuvreRepository;

	@GetMapping("/getAll")
	public String getAllChefOrchestre(Model model) {
		System.out.println("Test passage");
		System.out.println(iOrchestreService.getAllChefOrchestre());
		model.addAttribute("listeChefOrchestre", iOrchestreService.getAllChefOrchestre());
		return "listeChefOrchestre";
	}

	@GetMapping("/formulaire")
	public String getFormulaire() {
		return "formulaireOeuvre";
	}

	@PostMapping("/saveChefOrchestre")
	public String saveChefOrchestre(@ModelAttribute("chefOrchestre") ChefOrchestre chefOrchestre) {
		iOrchestreService.saveChefOrchestre(chefOrchestre);
		return "redirect:getAll";
	}
	
	@GetMapping("/deleteChefOrchestres/{id}")
	public String deleteChefOrchestre(@PathVariable Long id) {
		iOrchestreService.deleteChefOrchestre(id);
		return "redirect:/api/cheforchestre/getAll";
	}
	
	@GetMapping("/majChefOrchestre/{id}")
	public String majChefOrchestre(@PathVariable Long id, Model m) {
		m.addAttribute("chefOrchestre", iOrchestreService.getById(id));
		m.addAttribute("oeuvres", iOeuvreRepository.findAll());
		return "formulaireUpdateChefOrchestre";
	}
	
	@PostMapping("/majChefOrchestre")
	public String majChefOrchestre(@ModelAttribute("chefOrchestre") ChefOrchestre chefOrchestre) {
		iOrchestreService.updateChefOrchestre(chefOrchestre);

		return "redirect:getAll";
	}
	
}
