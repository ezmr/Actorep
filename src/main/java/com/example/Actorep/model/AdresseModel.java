package com.example.Actorep.model;

public class AdresseModel {

    private String libelleAdresse;
    private String codePosal;
    private String ville;

    public AdresseModel() {
    }

    public AdresseModel(String libelleAdresse, String codePosal, String ville) {
        this.libelleAdresse = libelleAdresse;
        this.codePosal = codePosal;
        this.ville = ville;
    }

    public String getLibelleAdresse() {
        return libelleAdresse;
    }

    public void setLibelleAdresse(String libelleAdresse) {
        this.libelleAdresse = libelleAdresse;
    }

    public String getCodePosal() {
        return codePosal;
    }

    public void setCodePosal(String codePosal) {
        this.codePosal = codePosal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
