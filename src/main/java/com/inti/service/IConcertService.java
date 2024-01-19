package com.inti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.model.Concert;

@Service
public interface IConcertService {

	public List<Concert> getAllConcert();
	public Concert saveConcert(Concert c);
	public Concert getConcert(Long id);
	public boolean updateConcert(Concert c);
	public void deleteConcert(Long id);
}
