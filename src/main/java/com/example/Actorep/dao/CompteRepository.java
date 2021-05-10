package com.example.Actorep.dao;

import com.example.Actorep.entities.Compte;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {

    public Compte findCompteByUsername(String username);
    
    public List<Compte> findAllByIsValid(boolean isValid);
    
    public Compte findCompteByActeurIdActeur(int ActeuridActeur);
}
