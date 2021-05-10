package com.example.Actorep.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Actorep.dao.ActiviteRepository;
import com.example.Actorep.entities.*;


@Service
@Transactional
public class ActiviteService {

	@Autowired
    private ActiviteRepository acr;
	
	public List<Activite> findAllActivite() {
        return acr.findAll();
    }
	
	/*public List<Acteur> getAllActeurByService (String libelleActivite){ //AJB
		List<Activite> resultService = acr.findAllByLibelleActiviteContains(libelleActivite);
		List<Acteur> lesActeursDoublons = new ArrayList<>();
		for (Activite uneActivite : resultService) {
			//lesActeursDoublons.addAll(uneActivite.getlesActeurs());
		}
		Set<Acteur> ActeurSet = new HashSet<Acteur>(lesActeursDoublons);
		List<Acteur> lesActeurs = new ArrayList<>(ActeurSet);
		return lesActeurs;
	}*/
	
	public void addAct(String s) {
		
		Activite activite = new Activite();
		activite.setLibelleActivite(s);;
		acr.save(activite);  
		
	}
	
}
