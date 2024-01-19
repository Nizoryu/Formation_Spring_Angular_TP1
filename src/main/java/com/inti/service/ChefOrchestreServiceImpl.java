package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.ChefOrchestre;
import com.inti.repository.IChefOrchestreRepository;

@Service
public class ChefOrchestreServiceImpl  implements IChefOrchestreService{

	@Autowired
	private IChefOrchestreRepository chefOrchestreRepository;
	
	@Override
	public List<ChefOrchestre> getAllChefOrchestre() {
		return chefOrchestreRepository.findAll();
	}

	@Override
	public ChefOrchestre getById(Long id) {
		if (id != null) {
			return chefOrchestreRepository.getReferenceById(id);
		}
		return null;
	}

	@Override
	public ChefOrchestre saveChefOrchestre(ChefOrchestre chefOrchestre) {
		if (chefOrchestre != null) {
			return chefOrchestreRepository.save(chefOrchestre);
		}
		return null;
	}

	@Override
	public boolean updateChefOrchestre(ChefOrchestre chefOrchestre) {
		if (chefOrchestre != null) {
			chefOrchestreRepository.save(chefOrchestre);
			return true;
		}
		return false;
	}

	@Override
	public void deleteChefOrchestre(Long id) {
		chefOrchestreRepository.deleteById(id);
		
	}

	
}
