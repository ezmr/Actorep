package com.example.Actorep.dao;


import com.example.Actorep.entities.Pays;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends JpaRepository<Pays,Integer> {
	
	public List<Pays> findAllByLibellePaysContains (String libellePays);
	
	public Pays findPaysByLibellePays(String libellePays);// recupère les pays par libellePays dans la Bdd. Ahmed

}
