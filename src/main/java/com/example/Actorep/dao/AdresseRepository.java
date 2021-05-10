package com.example.Actorep.dao;

import com.example.Actorep.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse,Integer> {
	
	public Adresse findAdresseByActeurIdActeur(int ActeuridActeur);// recupère les Adresse par idActeur dans la Bdd. Ahmed

}
