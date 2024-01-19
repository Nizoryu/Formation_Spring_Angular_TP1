package com.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Concert;
import com.inti.repository.IConcertRepository;

@Service
public class ConcertServiceImpl implements IConcertService {

	@Autowired
	IConcertRepository solisteRepository;

	@Override
	public List<Concert> getAllConcert() {
		return solisteRepository.findAll();
	}

	@Override
	public Concert saveConcert(Concert c) {
		if (c != null) {
			return solisteRepository.save(c);
		}
		return null;
	}

	@Override
	public Concert getConcert(Long id) {
		if (id != null) {
			return solisteRepository.getReferenceById(id);
		}
		return null;
	}

	@Override
	public boolean updateConcert(Concert c) {
		if (c != null) {
			solisteRepository.save(c);
			return true;
		}
		return false;
	}

	@Override
	public void deleteConcert(Long id) {
		if (id != null) {
			solisteRepository.deleteById(id);
		}
	}

}
