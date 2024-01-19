package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Soliste;

/**
 * @author Eloïc Ferdinand
 */

@Service
public interface ISolisteService {

	public List<Soliste> getAllSoliste();
	public Soliste saveSoliste(Soliste s);
	public Soliste getSoliste(Long id);
	public List<Soliste> getSolisteByName(String nom);
	public boolean updateSoliste(Soliste s);
	public void deleteSoliste(Long id);
}
