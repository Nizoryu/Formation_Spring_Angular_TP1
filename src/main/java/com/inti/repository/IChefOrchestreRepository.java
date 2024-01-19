package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.ChefOrchestre;

@Repository
public interface IChefOrchestreRepository extends JpaRepository<ChefOrchestre, Long>{

}
