package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Utilisateur;
import com.inti.repository.IUtilisateurRepository;

@Controller
public class MainController {

	@Autowired
	IUtilisateurRepository iUtilisateurRepository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/inscription")
	public String inscription() {
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String setInscription(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		utilisateur.setMotDePasse(new BCryptPasswordEncoder().encode(utilisateur.getMotDePasse()));
		iUtilisateurRepository.save(utilisateur);	
		return "redirect:/login";
	}
	
	@GetMapping("/hello")
	@Secured({"ROLE_ADMIN"})
	public String getMethodName() {
		return "hello";
	}
	
}
