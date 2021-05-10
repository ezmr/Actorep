package com.example.Actorep.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategorie;
    private String libelleCategorie;

    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
    private List<Acteur> lesActeurs;

    public Categorie() {
    }

    public Categorie(int idCategorie, String libelleCategorie) {
        this.idCategorie = idCategorie;
        this.libelleCategorie = libelleCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public List<Acteur> getLesActeurs() {
        return lesActeurs;
    }

    public void setLesActeurs(List<Acteur> lesActeurs) {
        this.lesActeurs = lesActeurs;
    }
}
