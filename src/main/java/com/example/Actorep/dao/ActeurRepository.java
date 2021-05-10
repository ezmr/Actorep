package com.example.Actorep.dao;

import com.example.Actorep.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur,Integer> {
	
	public List<Acteur> findAllByNomContainingAndCompteIsValidTrue(String nom); //AJB
	
	//public Acteur findById (int idActeur); //AJB
	
	public List<Acteur> findDistinctAllByMetierLibelleMetierContainsAndCompteIsValidTrue (String libelleMetier); //AJB
	
	public List<Acteur> findDistinctAllByCategorieLibelleCategorieContainsAndCompteIsValidTrue (String libelleCategorie); //AJB
	
	public List<Acteur> findDistinctAllByLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue (String libellePays); //AJB
	
	//
	public List<Acteur> findDistinctAllByMetierLibelleMetierContainsAndCategorieLibelleCategorieContainsAndCompteIsValidTrue (String libelleMetier, String libelleCategorie); //AJB
	
	//Acteur par location(ville ou pays)
	public List<Acteur> findDistinctAllByLesAdressesVilleContainsOrLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue(String ville, String libellePays);//AJB
	
	//metier location
	public List<Acteur> findDistinctAllByMetierLibelleMetierContainsAndLesAdressesVilleContainsOrLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue(String libelleMetier, String ville, String libellePays);//AJB
	
	//metier acteurNom
	public List<Acteur> findDistinctAllByMetierLibelleMetierContainsAndNomContainsAndCompteIsValidTrue(String libelleMetier, String nom);
	
	//categorie location
	public List<Acteur> findDistinctAllByCategorieLibelleCategorieContainsAndLesAdressesVilleContainsOrLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue(String libelleCategorie, String ville, String libellePays);
	
	//categorie ActeurNom
	public List<Acteur> findDistinctAllByCategorieLibelleCategorieContainsAndNomContainsAndCompteIsValidTrue (String libelleCategorie, String nom);
	
	//Acteur location
	public List<Acteur> findDistinctAllByNomContainsAndLesAdressesVilleContainsOrLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue(String nom, String ville, String libellePays);

}
