package com.example.Actorep.dao;

import com.example.Actorep.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetierRepository extends JpaRepository<Metier,Integer> {
	
	public List<Metier> findAllByLibelleMetierContaining(String libelleMetier);
	
	public List<Acteur> findDistinctLesActeursByLibelleMetierContaining(String libelleMetier);
	
	public Metier findMetierByLibelleMetier(String libelleMetier);// recupère les metier par libelleMetier dans la Bdd. Ahmed
	
}
