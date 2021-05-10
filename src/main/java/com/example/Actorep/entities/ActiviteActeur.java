package com.example.Actorep.entities;

import javax.persistence.*;

@Entity
public class ActiviteActeur {

    @EmbeddedId
    private ActeurActiviteKey id;


    @ManyToOne
    @MapsId("idActeur")
    @JoinColumn(name = "idActeur")
    private Acteur acteur;

    @ManyToOne
    @MapsId("idActivite")
    @JoinColumn(name = "idActivite")
    private Activite activite;

    private int prixActiviteActeur;

    public ActiviteActeur() {
    }

    public ActiviteActeur(ActeurActiviteKey id, Acteur acteur, Activite activite, int prixActiviteActeur) {
        this.id = id;
        this.acteur = acteur;
        this.activite = activite;
        this.prixActiviteActeur = prixActiviteActeur;
    }

    public ActeurActiviteKey getId() {
        return id;
    }

    public void setId(ActeurActiviteKey id) {
        this.id = id;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public int getPrixActiviteActeur() {
        return prixActiviteActeur;
    }

    public void setPrixActiviteActeur(int prixActiviteActeur) {
        this.prixActiviteActeur = prixActiviteActeur;
    }
}
