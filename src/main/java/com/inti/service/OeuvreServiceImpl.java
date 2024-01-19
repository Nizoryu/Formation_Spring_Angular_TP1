package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Oeuvre;
import com.inti.repository.IOeuvreRepository;

@Service
public class OeuvreServiceImpl implements IOeuvreService {

	@Autowired
	IOeuvreRepository oeuvreRepository;

	@Override
	public List<Oeuvre> getAllOeuvre() {
		return oeuvreRepository.findAll();
	}

	@Override
	public Oeuvre saveOeuvre(Oeuvre o) {
		if (o != null) {
			return oeuvreRepository.save(o);
		}
		return null;
	}

	@Override
	public Oeuvre getOeuvre(Long id) {
		return oeuvreRepository.getReferenceById(id);
	}

	@Override
	public boolean updateOeuvre(Oeuvre o) {
		if (o != null) {
			oeuvreRepository.save(o);
			return true;
		}
		return false;
	}

	@Override
	public void deleteOeuvre(Long id) {
		if (id != null) {
			oeuvreRepository.deleteById(id);
		}

	}

	@Override
	public List<Oeuvre> getOeuvreByName(String nom) {
		if (nom != null) {			
			return oeuvreRepository.findByNom(nom);
		}
		return null;
	}

}
