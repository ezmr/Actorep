package com.example.Actorep.service;

import com.example.Actorep.dao.MetierRepository;
import com.example.Actorep.entities.Acteur;
import com.example.Actorep.entities.Activite;
import com.example.Actorep.entities.Metier;
import com.example.Actorep.model.MetierModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MetierService {

    @Autowired
    private MetierRepository mr;

    public List<MetierModel> getAllMetier(){
        List<Metier> lesMetiers = mr.findAll();
        List<MetierModel> lesMetiersModel = new ArrayList<>();
        for(Metier metier : lesMetiers){
            MetierModel metierModel = new MetierModel();
            metierModel.setLibelleMetier(metier.getLibelleMetier());
            lesMetiersModel.add(metierModel);
        }
        return lesMetiersModel ;
    }
    
    public List<Metier> getAllMetiers(){
        return mr.findAll(); 
        
    }
    
    public MetierModel getByIdMetier(int idMetier){
        Metier metier = mr.findById(idMetier).get();
        MetierModel metierModel = new MetierModel();
        metierModel.setLibelleMetier(metier.getLibelleMetier());
        return metierModel;
    }

    public void saveMetier(MetierModel metierModel){
        Metier metier = new Metier();
        metier.setLibelleMetier(metierModel.getLibelleMetier());
        mr.save(metier);
    }

    public void deleteMetier(MetierModel metierModel){
        Metier metier = new Metier();
        metier.setLibelleMetier(metierModel.getLibelleMetier());
        mr.delete(metier);
    }

    public void deleByIdMetier(int idMetier){
        mr.deleteById(idMetier);
    }
    
    //------------------------------------------
    public List<Metier> findAllMetier(){ //AJB
        List<Metier> lesMetiers = mr.findAll();
        return lesMetiers ;
    }
    
    public void addMetier(String s) { //Elias
		
		Metier metier = new Metier();
		metier.setLibelleMetier(s);
		mr.save(metier);  
		
	}
}
