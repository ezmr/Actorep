package com.example.Actorep.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActeurActiviteKey implements Serializable {

    @Column(name = "idActeur")
    int idActeur;

    @Column(name = "idActivite")
    int idActivite;

    public ActeurActiviteKey() {
    }

    public ActeurActiviteKey(int idActeur, int idActivite) {
        this.idActeur = idActeur;
        this.idActivite = idActivite;
    }

    public int getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(int idActeur) {
        this.idActeur = idActeur;
    }

    public int getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(int idActivite) {
        this.idActivite = idActivite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActeurActiviteKey that = (ActeurActiviteKey) o;
        return idActeur == that.idActeur &&
                idActivite == that.idActivite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActeur, idActivite);
    }
}
