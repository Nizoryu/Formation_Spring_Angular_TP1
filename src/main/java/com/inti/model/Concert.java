package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.*;
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
	@ManyToOne
	@JoinColumn(name = "lieu_id")
	private Lieu lieu;
	
	@Override
	public String toString() {
		return "Concert [id=" + id + ", nom=" + nom + ", dateConcert=" + dateConcert + "]";
	}
	
}
