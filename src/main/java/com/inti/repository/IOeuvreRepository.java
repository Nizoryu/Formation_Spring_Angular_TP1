package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Oeuvre;

@Repository
public interface IOeuvreRepository extends JpaRepository<Oeuvre, Long> {

	public List<Oeuvre> findByNom(String nom);
	public long count();
}
