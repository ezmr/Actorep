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
public class PaysService {
	
	@Autowired
	PaysRepository paysRepository, pr;
	
	public List<Acteur> getAllActeurbyPaysContaining (String libellePays){ //AJB
		List<Pays> lesPays = paysRepository.findAllByLibellePaysContains(libellePays);
		List<Acteur> lesActeursDoublons = new ArrayList<>();
		for (Pays unPays : lesPays) {
			for (Adresse uneAdresse : unPays.getLesAdresses()) {
				
			}
		}
		return null;
	}
	
	public List<PaysModel> getAllPays(){
        List<Pays> lesPays = pr.findAll();
        List<PaysModel> lesPaysModel = new ArrayList();
        for(Pays pays : lesPays){
            PaysModel paysModel = new PaysModel();
            paysModel.setLibellePays(pays.getLibellePays());
            lesPaysModel.add(paysModel);
        }
        return lesPaysModel ;
    }

    public PaysModel getByIdPays(int idPays){
        Pays pays = pr.findById(idPays).get();
        PaysModel paysModel = new PaysModel();
        paysModel.setLibellePays(pays.getLibellePays());
        return paysModel;
    }

    public void savePays(PaysModel paysModel){
        Pays pays = new Pays();
        pays.setLibellePays(paysModel.getLibellePays());
        pr.save(pays);
    }

    public void deletePays(PaysModel paysModel){
        Pays pays = new Pays();
        pays.setLibellePays(paysModel.getLibellePays());
        pr.delete(pays);
    }

    public void deleByIdPays(int idPays){
       pr.deleteById(idPays);
    }

}
