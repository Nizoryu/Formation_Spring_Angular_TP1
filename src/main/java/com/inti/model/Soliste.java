package com.inti.model;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Eloïc Ferdinand
 * 
 * Classe Soliste.
 */

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Soliste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "oeuvre_soliste", joinColumns = @JoinColumn(name = "id_soliste"), inverseJoinColumns = @JoinColumn(name = "id_oeuvre"))
	private List<Oeuvre> oeuvres;
	
	@Override
	public String toString() {
		return "Soliste [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", nationalite=" + nationalite + "]";
	}
		
}
