package com.example.Actorep.model;

public class RechercheHomeModel {
	
	private String recherche;
	private String type;
	
	public RechercheHomeModel() {
		
	}
	
	public RechercheHomeModel(String recherche, String type) {
		this.recherche = recherche;
		this.type = type;
	}

	public String getRecherche() {
		return recherche;
	}

	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
