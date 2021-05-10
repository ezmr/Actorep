package com.example.Actorep.model;

public class CompteModel {

    private String username;
    private String password;
    private boolean isAdmin;
    private boolean isValid;

    public CompteModel() {
    }

    public CompteModel(String username, String password, boolean isAdmin, boolean isValid) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isValid = isValid;
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
}
