package com.example.Actorep.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Metier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetier;
    private String libelleMetier;

   @OneToMany(mappedBy = "metier")
   @JsonIgnore
   private List<Acteur> lesActeurs;

    public Metier() {
    }

    public Metier(int idMetier, String libelleMetier) {
        this.idMetier = idMetier;
        this.libelleMetier = libelleMetier;
    }

    public int getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(int idMetier) {
        this.idMetier = idMetier;
    }

    public String getLibelleMetier() {
        return libelleMetier;
    }

    public void setLibelleMetier(String libelleMetier) {
        this.libelleMetier = libelleMetier;
    }

    public List<Acteur> getLesActeurs() {
        return lesActeurs;
    }

    public void setLesActeurs(List<Acteur> lesActeurs) {
        this.lesActeurs = lesActeurs;
    }
    
    public void getLesActeursValid() {}
}
