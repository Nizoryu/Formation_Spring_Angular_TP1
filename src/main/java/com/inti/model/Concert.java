package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author EFF
 * 
 *         Classe Concert.
 */

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Concert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private LocalDate dateConcert;
	@ManyToOne
	@JoinColumn(name="oeuvre_id")
	private Oeuvre oeuvre;
	
	@Override
	public String toString() {
		return "Concert [id=" + id + ", nom=" + nom + ", dateConcert=" + dateConcert + "]";
	}
	
}
