package com.example.Actorep.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;

@Entity
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActeur;
    private String nom;
    private String mail;
    private String telephone;
    @Column(length = 1500)
    private String presentation;
    @Column(length = 1500)
    private String image;
    @Column(length = 1500)
    private String video;

   @OneToMany(mappedBy = "acteur")
   @JsonIgnore
   private List<Experience> lesExperiences;

   @ManyToOne
   private Metier metier;

   @ManyToOne
   private Categorie categorie;

   @OneToMany(mappedBy = "acteur" )
   private List<Adresse> lesAdresses;


    @OneToMany(mappedBy = "acteur")
    @JsonIgnore
    Set<Acteur> acteur;

    @OneToOne(mappedBy="acteur")
    private Compte compte ;


    public Acteur() {
    }

    public Acteur(int idActeur, String nom, String mail, String telephone, String presentation, String image, String video) {
        this.idActeur = idActeur;
        this.nom = nom;
        this.mail = mail;
        this.telephone = telephone;
        this.presentation = presentation;
        this.image = image;
        this.video = video;
    }
    
    //methode add expériences à ajouter

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
    
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    public Set<Acteur> getActeur() {
        return acteur;
    }

    public void setActeur(Set<Acteur> acteur) {
        this.acteur = acteur;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
