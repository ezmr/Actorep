package com.example.Actorep.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdresse;
    private String libelleAdresse;
    private String codePosal;
    private String ville;

    @ManyToOne
    @JsonIgnore
    private Acteur acteur;

    @ManyToOne
    private Pays pays;


    public Adresse() {
    }

    public Adresse(int idAdresse, String libelleAdresse, String codePosal, String ville) {
        this.idAdresse = idAdresse;
        this.libelleAdresse = libelleAdresse;
        this.codePosal = codePosal;
        this.ville = ville;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getLibelleAdresse() {
        return libelleAdresse;
    }

    public void setLibelleAdresse(String libelleAdresse) {
        this.libelleAdresse = libelleAdresse;
    }

    public String getCodePosal() {
        return codePosal;
    }

    public void setCodePosal(String codePosal) {
        this.codePosal = codePosal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
}
