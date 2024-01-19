package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Concert;

@Repository
public interface IConcertRepository extends JpaRepository<Concert, Long> {

	public List<Concert> findByNom(String nom);
	public long count();
}
