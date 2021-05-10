package com.example.Actorep.model;


public class InscriptionModel {


    private String nom;
    private String mail;
    private String telephone;
    private String presentation;
    private String image;
    private String video;
    private String adresse;
    private String ville;
    private String codePostal;
    private String libellePays;
    private String libelleMetier;
    private String libelleCategorie;
    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isValid;

    public InscriptionModel() {
    }

    public InscriptionModel(String nom, String mail, String telephone, String presentation, String image, String video, String adresse, String ville, String codePostal, String libellePays, String libelleMetier, String libelleCategorie, String username, String password, boolean isAdmin, boolean isValid) {
        this.nom = nom;
        this.mail = mail;
        this.telephone = telephone;
        this.presentation = presentation;
        this.image = image;
        this.video = video;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.libellePays = libellePays;
        this.libelleMetier = libelleMetier;
        this.libelleCategorie = libelleCategorie;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isValid = isValid;
    }

    public InscriptionModel(String nom, String mail, String telephone, String presentation, String image, String video, String adresse, String ville, String codePostal, String libellePays, String libelleMetier, String libelleCategorie, String username, String password) {
        this.nom = nom;
        this.mail = mail;
        this.telephone = telephone;
        this.presentation = presentation;
        this.image = image;
        this.video = video;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.libellePays = libellePays;
        this.libelleMetier = libelleMetier;
        this.libelleCategorie = libelleCategorie;
        this.username = username;
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getLibellePays() {
        return libellePays;
    }

    public void setLibellePays(String libellePays) {
        this.libellePays = libellePays;
    }

    public String getLibelleMetier() {
        return libelleMetier;
    }

    public void setLibelleMetier(String libelleMetier) {
        this.libelleMetier = libelleMetier;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }
}
