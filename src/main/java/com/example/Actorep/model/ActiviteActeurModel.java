package com.example.Actorep.model;


public class ActiviteActeurModel {

    private int idActivie;
    private int idActeur;
    private int prixActiviteActeur;
	private String libelleActivite;
	private String descriptionActivite;
	
	
	public ActiviteActeurModel() {
    }

    public ActiviteActeurModel(int idActivie, int idActeur, int prixActiviteActeur, String libelleActivite, String descriptionActivite) {
        this.idActivie = idActivie;
        this.idActeur = idActeur;
        this.prixActiviteActeur = prixActiviteActeur;
        this.libelleActivite = libelleActivite;
        this.descriptionActivite = descriptionActivite;
    }

    public ActiviteActeurModel(int prixActiviteActeur, String libelleActivite, String descriptionActivite) {
        this.prixActiviteActeur = prixActiviteActeur;
        this.libelleActivite = libelleActivite;
        this.descriptionActivite = descriptionActivite;
    }

    public int getIdActivie() {
        return idActivie;
    }

    public void setIdActivie(int idActivie) {
        this.idActivie = idActivie;
    }

    public int getPrixActiviteActeur() {
        return prixActiviteActeur;
    }

    public void setprixActiviteActeur(int prixActiviteActeur) {
        this.prixActiviteActeur = prixActiviteActeur;
    }

    public String getLibelleActivite() {
        return libelleActivite;
    }

	public void setLibelleActivite(String libelle) {
        this.libelleActivite = libelle;
    }


	public String getDescriptionActivite() {
        return descriptionActivite;
    }

	public void setDescriptionActivite(String description) {
        this.descriptionActivite = description;
    }

    public int getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(int idActeur) {
        this.idActeur = idActeur;
    }
}
