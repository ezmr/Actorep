package com.example.Actorep.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivite;
    private String libelleActivite;
    private String descriptionActivite;



    @OneToMany(mappedBy = "activite")
    @JsonIgnore
    Set<Activite> activite;

    public Activite() {
    }

    public Activite(int idActivite, String libelleActivite, String descriptionActivite) {
        this.idActivite = idActivite;
        this.libelleActivite = libelleActivite;
        this.descriptionActivite = descriptionActivite;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    public String getLibelleActivite() {
        return libelleActivite;
    }

    public void setLibelleActivite(String libelleActivite) {
        this.libelleActivite = libelleActivite;
    }

    public Set<Activite> getActivite() {
        return activite;
    }

    public void setActivite(Set<Activite> activite) {
        this.activite = activite;
    }

    public String getDescriptionActivite() {
        return descriptionActivite;
    }

    public void setDescriptionActivite(String descriptionActivite) {
        this.descriptionActivite = descriptionActivite;
    }
}

