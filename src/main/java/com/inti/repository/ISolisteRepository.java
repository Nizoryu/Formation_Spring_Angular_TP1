package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Soliste;

@Repository
public interface ISolisteRepository extends JpaRepository<Soliste, Long> {

	public List<Soliste> findByNom(String nom);
	public long count();
}
