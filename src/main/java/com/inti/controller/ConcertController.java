package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Concert;
import com.inti.service.IConcertService;

@Controller
@RequestMapping("api/concert")
public class ConcertController {

	@Autowired
	private IConcertService iCService;

	@GetMapping("getAllConcert")
	public String getAllConcert(Model m) {
		List<Concert> listConcerts = iCService.getAllConcert();

		m.addAttribute("listConcerts", listConcerts);

		return "listeConcert";
	}
	
	@GetMapping("formulaire")
	public String getFormulaire() {
		return "formulaireConcert";
	}
	
	@PostMapping("saveConcert")
	public String saveConcert(@ModelAttribute("oeuvre") Concert oeuvre) {

		iCService.saveConcert(oeuvre);
		return "redirect:getAllConcert";
	}
}
