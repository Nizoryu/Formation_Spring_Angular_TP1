package com.inti.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Oeuvre;
import com.inti.model.Soliste;
import com.inti.repository.IOeuvreRepository;
import com.inti.repository.ISolisteRepository;
import com.inti.service.ISolisteService;

@Controller
@RequestMapping("api")
public class SolisteController {

	@Autowired
	private ISolisteService iSolisteService;

	@Autowired
	private ISolisteRepository iSolisteRepository;

	@Autowired
	private IOeuvreRepository iOeuvreRepository;

	@GetMapping("getAllSoliste")
	public String getAllSoliste(Model m) {
		List<Soliste> listSolistes = iSolisteService.getAllSoliste();

		m.addAttribute("listSolistes", listSolistes);

		return "listeSoliste";
	}

	@PostMapping("getSolisteById")
	public String getSolisteById(@RequestParam("id") Long id, Model m) {

		List<Soliste> listSolistes = new ArrayList<>(Arrays.asList(iSolisteService.getSoliste(id)));
		m.addAttribute("listSolistes", listSolistes);

		return "listeSoliste";
	}

	@GetMapping("count")
	public String getSolisteCount(Model m) {
		m.addAttribute("count", iSolisteRepository.count());
		return "listeSoliste";
	}

	@GetMapping("formulaire")
	public String getFormulaire(Model m) {
		m.addAttribute("oeuvres", iOeuvreRepository.findAll());
		return "formulaire";
	}

	@PostMapping("saveSoliste")
	public String saveSoliste(@ModelAttribute("soliste") Soliste soliste,
			@RequestParam(value="oeuvres", required =false) List<Long> oeuvreId) {
		if (oeuvreId != null) {
			List<Oeuvre> oeuvres = iOeuvreRepository.findAllById(oeuvreId);
			soliste.setOeuvres(oeuvres);
		}
		iSolisteService.saveSoliste(soliste);
		return "redirect:getAllSoliste";
	}

	@GetMapping("majSoliste/{id}")
	public String majSoliste(@PathVariable Long id, Model m) {
		m.addAttribute("soliste", iSolisteService.getSoliste(id));
		m.addAttribute("oeuvres", iOeuvreRepository.findAll());
		return "formulaireUpdate";
	}

	@PostMapping("majSoliste")
	public String majSoliste(@ModelAttribute("solist") Soliste soliste) {
		iSolisteService.updateSoliste(soliste);

		return "redirect:getAllSoliste";
	}

	@RequestMapping("deleteSoliste/{id}")
	public String deleteSoliste(@PathVariable Long id) {
		iSolisteService.deleteSoliste(id);

		return "redirect:/api/getAllSoliste";
	}

	@PostMapping("getSolisteByName")
	public String getSolisteByName(@RequestParam("nom") String nom, Model m) {

		m.addAttribute("listSolistes", iSolisteService.getSolisteByName(nom));

		return "listeSoliste";
	}

}
