package com.example.Actorep.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompte;
    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isValid;

    @OneToOne
    @JsonIgnore
    private Acteur acteur ;

    public Compte() {
    }

    public Compte(int idCompte, String username, String password, boolean isAdmin, boolean isValid) {
        this.idCompte = idCompte;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isValid = isValid;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

}
