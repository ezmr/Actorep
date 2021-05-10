package com.example.Actorep.model;


public class ActiviteModel {
	
	private String libelleActivite;
	private String descriptionActivite;
	
	
	public ActiviteModel() {
    }
	
	public ActiviteModel(String libelle, String description) {
		
		this.libelleActivite = libelle;
		this.descriptionActivite = description;
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
	
	public void setDescriptionActivité(String description) {
        this.descriptionActivite = description;
    }
	
	

}
