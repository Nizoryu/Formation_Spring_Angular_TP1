package com.inti.repository;

import com.inti.model.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILieuRepository extends JpaRepository<Lieu, Long> {

}
