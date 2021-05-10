package com.example.Actorep.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPays;
    private String libellePays;

    @OneToMany(mappedBy = "pays")
    @JsonIgnore
    private List<Adresse> lesAdresses;

    public Pays() {
    }

    public Pays(int idPays, String libellePays) {
        this.idPays = idPays;
        this.libellePays = libellePays;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public String getLibellePays() {
        return libellePays;
    }

    public void setLibellePays(String libellePays) {
        this.libellePays = libellePays;
    }

    public List<Adresse> getLesAdresses() {
        return lesAdresses;
    }

    public void setLesAdresses(List<Adresse> lesAdresses) {
        this.lesAdresses = lesAdresses;
    }
}
