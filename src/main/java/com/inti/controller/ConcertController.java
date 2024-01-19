package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Concert;
import com.inti.repository.IOeuvreRepository;
import com.inti.service.IConcertService;

@Controller
@RequestMapping("api/concert")
public class ConcertController {

	@Autowired
	private IConcertService iConcertService;
	
	@Autowired
	private IOeuvreRepository iOeuvreRepository;

	@GetMapping("getAllConcert")
	public String getAllConcert(Model m) {
		List<Concert> listConcerts = iConcertService.getAllConcert();

		m.addAttribute("listConcerts", listConcerts);

		return "listeConcert";
	}
	
	@GetMapping("formulaire")
	public String getFormulaire(Model m) {
		m.addAttribute("oeuvres", iOeuvreRepository.findAll());
		return "formulaireConcert";
	}
	
	@PostMapping("saveConcert")
	public String saveConcert(@ModelAttribute("oeuvre") Concert oeuvre) {

		iConcertService.saveConcert(oeuvre);
		return "redirect:getAllConcert";
	}
	
	@GetMapping("majConcert/{id}")
	public String majConcert(@PathVariable Long id, Model m) {
		m.addAttribute("soliste", iConcertService.getConcert(id));
		m.addAttribute("oeuvres", iOeuvreRepository.findAll());
		return "formulaireUpdate";
	}
	
	@PostMapping("majConcert")
	public String majConcert(@ModelAttribute("solist") Concert soliste) {
		iConcertService.updateConcert(soliste);

		return "redirect:getAllConcert";
	}

	@RequestMapping("deleteConcert/{id}")
	public String deleteConcert(@PathVariable Long id) {
		iConcertService.deleteConcert(id);

		return "redirect:/api/concert/getAllConcert";
	}
}
