package com.example.Actorep.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Actorep.dao.*;
import com.example.Actorep.entities.*;
import com.example.Actorep.model.*;

@Service
@Transactional
public class ActiviteActeurService {
	
	@Autowired
    private ActiviteActeurRepository activiteActeurRepository;
	
	@Autowired
    ActiviteRepository activiteRepository;

    @Autowired
    ActeurRepository acteurRepository;
	
	public List<ActiviteActeur> getServicesByActor(Acteur acteur){ //AJB
		return activiteActeurRepository.findActiviteByActeur(acteur);
	}
	
	public List<ActiviteActeur> getAll(){
		System.out.println(activiteActeurRepository.findAll());
		return activiteActeurRepository.findAll();
	}
	
	
	
	public List<ActiviteActeurModel> getActiviteActeurByIdActeur(Compte compte){
	     List<ActiviteActeur> lesActivitesActeur = activiteActeurRepository.findActiviteByActeurIdActeur(compte.getActeur().getIdActeur());
	    List<ActiviteActeurModel> lesActivitesActeurModel = new ArrayList();


	    for(ActiviteActeur activiteActeur : lesActivitesActeur){
	        ActiviteActeurModel activiteActeurModel=new ActiviteActeurModel();
	        activiteActeurModel.setIdActivie(activiteActeur.getActivite().getIdActivite());
	        activiteActeurModel.setLibelleActivite(activiteActeur.getActivite().getLibelleActivite());
	        activiteActeurModel.setDescriptionActivite(activiteActeur.getActivite().getDescriptionActivite());
	        activiteActeurModel.setIdActeur(activiteActeur.getActeur().getIdActeur());
	        activiteActeurModel.setprixActiviteActeur(activiteActeur.getPrixActiviteActeur());

	       lesActivitesActeurModel.add(activiteActeurModel);

	}

	        return lesActivitesActeurModel;
	    }

	    public ActiviteActeurModel saveActiviteActeur(ActiviteActeurModel actviteActeurModel, Compte compte){

	        Activite activite = new Activite();
	        activite.setDescriptionActivite(actviteActeurModel.getDescriptionActivite());
	        activite.setLibelleActivite(actviteActeurModel.getLibelleActivite());
	        activiteRepository.save(activite);


	        Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur()).get();
	        ActiviteActeur activiteActeur = new ActiviteActeur();
	        activiteActeur.setActeur(acteur);
	        activiteActeur.setActivite(activite);
	        activiteActeur.setPrixActiviteActeur(actviteActeurModel.getPrixActiviteActeur());
	        ActeurActiviteKey acteurActiviteKey= new ActeurActiviteKey();
	        acteurActiviteKey.setIdActivite(activite.getIdActivite());
	        acteurActiviteKey.setIdActeur(acteur.getIdActeur());
	        activiteActeur.setId(acteurActiviteKey);
	        activiteActeurRepository.save(activiteActeur);

	        ActiviteActeurModel a = new ActiviteActeurModel();
	        a.setIdActeur(activiteActeur.getActeur().getIdActeur());
	        a.setIdActivie(activiteActeur.getActivite().getIdActivite());
	        a.setLibelleActivite(activiteActeur.getActivite().getLibelleActivite());
	        a.setDescriptionActivite(activiteActeur.getActivite().getDescriptionActivite());
	        a.setprixActiviteActeur(activiteActeur.getPrixActiviteActeur());

	        return a;
	    }

	    public void deleteActiviteActeur(ActiviteActeurModel activiteActeurModel){
	        Activite activite = activiteRepository.findById(activiteActeurModel.getIdActivie()).get();
	       Acteur acteur = acteurRepository.findById(activiteActeurModel.getIdActeur()).get();
	       ActeurActiviteKey acteurActiviteKey = new ActeurActiviteKey(activiteActeurModel.getIdActeur(),activiteActeurModel.getIdActivie());


	        ActiviteActeur activiteActeur = new ActiviteActeur(acteurActiviteKey,acteur,activite,activiteActeurModel.getPrixActiviteActeur());

	        activiteActeurRepository.delete(activiteActeur);
	        activiteRepository.deleteById(activiteActeurModel.getIdActivie());
	    }
	    
	    

}
