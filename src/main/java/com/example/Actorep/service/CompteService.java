package com.example.Actorep.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.Actorep.dao.*;
import com.example.Actorep.entities.*;

@Service
@Transactional
public class CompteService {
	
	@Autowired
	private CompteRepository compteRepository, cr;
	
	public List<Compte> getAllValidCompte (){
		return compteRepository.findAllByIsValid(true);
	}
	
	public List<Compte> GetAllCompte() {
        return cr.findAll();
    }
	
	
	public List<Compte> GetAllFalseCompte() {
      return cr.findAllByIsValid(false);
	}
	
	
	public void deleteByIdCompte(int idCompte){
		Compte c1 = cr.findById(idCompte).get();
		c1.setValid(false);
		cr.save(c1);
	}
	
	public void modifierIsValid(int idCompte) {
		Compte c1 = cr.findById(idCompte).get();
		c1.setValid(true);
		cr.save(c1);
	}

}
