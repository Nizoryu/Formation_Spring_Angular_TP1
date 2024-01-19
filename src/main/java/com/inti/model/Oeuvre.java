package com.inti.model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author EFF
 * 
 *         Classe Oeuvre.
 */

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private LocalTime duree;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "oeuvre_soliste", joinColumns = @JoinColumn(name = "id_oeuvre"), inverseJoinColumns = @JoinColumn(name = "id_soliste"))
	private List<Soliste> solistes;
	@OneToMany(mappedBy = "oeuvre")
	private List<Concert> concerts;

	@OneToMany(mappedBy = "oeuvre")
	private List<ChefOrchestre> chefOrchestres;
	@Override
	public String toString() {
		return "Oeuvre [id=" + id + ", nom=" + nom + ", duree=" + duree + "]";
	}

}
