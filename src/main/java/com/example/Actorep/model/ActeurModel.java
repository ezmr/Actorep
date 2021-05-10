package com.example.Actorep.model;

import java.io.Serializable;
import java.util.*;

import com.example.Actorep.entities.*;

public class ActeurModel{
	
	private int idActeur;
    private String nom;
    private String mail;
    private String telephone;
    private String presentation;
    private String image;
    
    private List<Experience> lesExperiences;

    private Metier metier;

    private Categorie categorie;

    private List<Adresse> lesAdresses;
    
     //Set<Acteur> acteur;

     private Compte compte ;


     public ActeurModel() {
     }

     public ActeurModel(int idActeur, String nom, String mail, String telephone, String presentation, String image) {
         this.idActeur = idActeur;
         this.nom = nom;
         this.mail = mail;
         this.telephone = telephone;
         this.presentation = presentation;
         this.image = image;
     }
     
     public ActeurModel(String nom, String mail, String telephone, String presentation, String image) {
         this.nom = nom;
         this.mail = mail;
         this.telephone = telephone;
         this.presentation = presentation;
         this.image = image;
     }
     
     public int getIdActeur() {
         return idActeur;
     }

     public void setIdActeur(int idActeur) {
         this.idActeur = idActeur;
     }

     public String getNom() {
         return nom;
     }

     public void setNom(String nom) {
         this.nom = nom;
     }


     public String getMail() {
         return mail;
     }

     public void setMail(String mail) {
         this.mail = mail;
     }

     public String getTelephone() {
         return telephone;
     }

     public void setTelephone(String telephone) {
         this.telephone = telephone;
     }

     public String getPresentation() {
         return presentation;
     }

     public void setPresentation(String presentation) {
         this.presentation = presentation;
     }

     public String getImage() {
         return image;
     }

     public void setImage(String image) {
         this.image = image;
     }

     public List<Experience> getLesExperiences() {
         return lesExperiences;
     }

     public void setLesExperiences(List<Experience> lesExperiences) {
         this.lesExperiences = lesExperiences;
     }

     public Metier getMetier() {
         return metier;
     }

     public void setMetier(Metier metier) {
         this.metier = metier;
     }

     public Categorie getCategorie() {
         return categorie;
     }

     public void setCategorie(Categorie categorie) {
         this.categorie = categorie;
     }

     public List<Adresse> getLesAdresses() {
         return lesAdresses;
     }

     public void setLesAdresses(List<Adresse> lesAdresses) {
         this.lesAdresses = lesAdresses;
     }

     /*public Set<Acteur> getActeur() {
         return acteur;
     }

     public void setActeur(Set<Acteur> acteur) {
         this.acteur = acteur;
     }*/

     public Compte getCompte() {
         return compte;
     }

     public void setCompte(Compte compte) {
         this.compte = compte;
     }

}
