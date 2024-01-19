package com.inti.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delphagregory
 *
 * Classe Lieu
 */
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private Long nombreFauteuils;
    @OneToMany(mappedBy = "lieu")
    private List<Concert> concerts;

    @Override
    public String toString(){
        return "Lieu [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", nombreFauteuils=" + nombreFauteuils + "]";
    }
}
