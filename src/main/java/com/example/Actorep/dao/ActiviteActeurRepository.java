package com.example.Actorep.dao;

import com.example.Actorep.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiviteActeurRepository extends JpaRepository<ActiviteActeur,Integer>{
	
	public List<ActiviteActeur> findActiviteByActeur(Acteur acteur);
	
	public List<ActiviteActeur> findDistinctActeurByActiviteIn (List<Activite> activite);
	
	public List<ActiviteActeur> findActiviteByActeurIdActeur(int idActeur);
	
	
	//public List<Acteur> findActeurByActivite();
	
	//public List<ActiviteActeur> findDistinctAllbyActiviteLibelleActiviteContains(String libelleActivite);

}
