package com.inti.model;

import java.time.LocalDate;
import java.util.List;

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
	@OneToMany(mappedBy = "concert")
	private List<Lieu> listeLieu;
	
	public String getNomOeuvre() {
		if(this.oeuvre !=null) {
			return this.oeuvre.getNom();			
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Concert [id=" + id + ", nom=" + nom + ", dateConcert=" + dateConcert + "]";
	}
	
}
