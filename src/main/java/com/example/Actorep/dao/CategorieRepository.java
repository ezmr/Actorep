package com.example.Actorep.dao;

import com.example.Actorep.entities.Categorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
	
	public List<Categorie> findAllByLibelleCategorieContaining(String libelleCategorie); //AJB
	
	public Categorie findCategorieByLibelleCategorie(String libelleCategorie); // recupère les categories par libelleCategorie dans la Bdd. Ahmed

	void save(String s); //Elias
}
