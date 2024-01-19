package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.ChefOrchestre;

/**
 * @author Karim.K
 */
@Service
public interface IChefOrchestreService {

	public List<ChefOrchestre> getAllChefOrchestre();
	public ChefOrchestre getById(Long id);
	public ChefOrchestre saveChefOrchestre(ChefOrchestre chefOrchestre);
	public boolean updateChefOrchestre(ChefOrchestre chefOrchestre);
	public void deleteChefOrchestre (Long id);
}
