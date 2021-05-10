package com.example.Actorep.model;

public class ExperienceModel {

    private int idExperience;
    private String objet;
    private String dateDebut;
    private String dateFin;
    private String description;


    public ExperienceModel() {

    }


    public ExperienceModel(int idExperience, String objet, String dateDebut, String dateFin, String description) {
        this.idExperience = idExperience;
        this.objet = objet;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }


}
