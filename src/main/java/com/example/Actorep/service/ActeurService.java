package com.example.Actorep.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Actorep.dao.ActeurRepository;
import com.example.Actorep.dao.ActiviteActeurRepository;
import com.example.Actorep.dao.ActiviteRepository;
import com.example.Actorep.entities.*;

@Service
@Transactional
public class ActeurService {
	
	@Autowired
    private ActeurRepository ac;
	
	@Autowired
	private ActiviteActeurRepository aar;
	
	@Autowired
	private ActiviteRepository ar;
	
	public List<Acteur> findAllActeur() {
        return ac.findAll();
    }
	
	public Acteur findActeurById(int id) {
		return ac.findById(id).get();
	}
	
	public List<Acteur> findAllByNomContaining(String nom) {
        return ac.findAllByNomContainingAndCompteIsValidTrue(nom);
    }
	
	public List<Acteur> findAllValidByNomContaining(String nom) { //àsupprimmer si
        List<Acteur> lesActeurs = ac.findAllByNomContainingAndCompteIsValidTrue(nom);
        List<Acteur> lesActeursValid = new ArrayList<>();
		for (Acteur unActeur : lesActeurs) {
			if (unActeur.getCompte().isValid()) {
				lesActeursValid.add(unActeur);
			}
		}
		return lesActeursValid;
    }
	
	public List<Acteur> findAllByMetierContains (String libelleMetier){
		return ac.findDistinctAllByMetierLibelleMetierContainsAndCompteIsValidTrue(libelleMetier);
	}
	
	public List<Acteur> findAllByCategorieContains (String libelleCategorie){
		return ac.findDistinctAllByCategorieLibelleCategorieContainsAndCompteIsValidTrue(libelleCategorie);
	}
	
	public List<Acteur> findAllByPaysContains (String libellePays){
		return ac.findDistinctAllByLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue(libellePays);
	}
	
	public List<Acteur> findAllByMetierAndCategorieContains (String libelleMetier, String libelleCategorie){
		return ac.findDistinctAllByMetierLibelleMetierContainsAndCategorieLibelleCategorieContainsAndCompteIsValidTrue(libelleMetier, libelleCategorie);
	}
	
	public List<Acteur> findAllByActiviteIn (String libelleActivite){
		List<ActiviteActeur> lesActiviteActeur = aar.findDistinctActeurByActiviteIn(ar.findAllByLibelleActiviteContains(libelleActivite));
		List<Acteur> lesActeurs = new ArrayList<>();
		for (ActiviteActeur activiteActeur : lesActiviteActeur) {
			lesActeurs.add(activiteActeur.getActeur());
		}
		return lesActeurs;
	}
	
	public List<Acteur> findAllByMetierAndLocation(String libelleMetier, String ville, String libellePays){
		return ac.findDistinctAllByMetierLibelleMetierContainsAndLesAdressesVilleContainsOrLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue(libelleMetier, ville, libellePays);
	}
	
	public List<Acteur> findAllByMetierAndActeur (String libelleMetier, String nom){
		return ac.findDistinctAllByMetierLibelleMetierContainsAndNomContainsAndCompteIsValidTrue(libelleMetier, nom);
	}
	
	public List<Acteur> findAllByCategorieAndLocation(String libelleCategorie, String ville, String libellePays){
		return ac.findDistinctAllByCategorieLibelleCategorieContainsAndLesAdressesVilleContainsOrLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue(libelleCategorie, ville, libellePays);
	}
	
	public List<Acteur> findAllByCategorieAndActeur (String libelleCategorie, String nom){
		return ac.findDistinctAllByCategorieLibelleCategorieContainsAndNomContainsAndCompteIsValidTrue(libelleCategorie, nom);
	}
	
	public List<Acteur> findAllByActeurAndLocation(String nom, String ville, String libellePays){
		return ac.findDistinctAllByNomContainsAndLesAdressesVilleContainsOrLesAdressesPaysLibellePaysContainsAndCompteIsValidTrue(nom, ville, libellePays);
	}
	
	
	public void deletebyIdActeur(int idActeur){
		Acteur a1 = ac.findById(idActeur).get();
		a1.getCompte().setValid(false);
		ac.save(a1);
		
	}
	
	
	

}
