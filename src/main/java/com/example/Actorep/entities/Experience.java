package com.example.Actorep.entities;

import javax.persistence.*;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExperience;
    private String dateDebut;
    private String dateFin;
    private String objet;
    private String description;

   @ManyToOne
   private Acteur acteur;



    public Experience() {
    }

    public Experience(int idExperience, String dateDebut, String dateFin, String objet, String description) {
        this.idExperience = idExperience;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.objet = objet;
        this.description = description;
    }

    public int getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }
}
