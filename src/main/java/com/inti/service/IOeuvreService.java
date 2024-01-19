package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Oeuvre;

@Service
public interface IOeuvreService {

	public List<Oeuvre> getAllOeuvre();
	public Oeuvre saveOeuvre(Oeuvre o);
	public Oeuvre getOeuvre(Long id);
	public List<Oeuvre> getOeuvreByName(String nom);
	public boolean updateOeuvre(Oeuvre o);
	public void deleteOeuvre(Long id);
}
