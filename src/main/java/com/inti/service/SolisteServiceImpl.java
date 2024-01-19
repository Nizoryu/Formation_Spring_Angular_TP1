package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

@Service
public class SolisteServiceImpl implements ISolisteService {

	@Autowired
	ISolisteRepository solisteRepository;

	@Override
	public List<Soliste> getAllSoliste() {
		return solisteRepository.findAll();
	}

	@Override
	public Soliste saveSoliste(Soliste s) {
		if (s != null) {
			return solisteRepository.save(s);
		}
		return null;
	}

	@Override
	public Soliste getSoliste(Long id) {
		if (id != null) {
			return solisteRepository.getReferenceById(id);
		}
		return null;
	}

	@Override
	public boolean updateSoliste(Soliste s) {
		if (s != null) {
			solisteRepository.save(s);
			return true;
		}
		return false;
	}

	@Override
	public void deleteSoliste(Long id) {
		if (id != null) {
			solisteRepository.deleteById(id);
		}
	}


	@Override
	public List<Soliste> getSolisteByName(String nom) {
		if (nom != null) {
			return solisteRepository.findByNom(nom);
		}
		return null;
	}
}
