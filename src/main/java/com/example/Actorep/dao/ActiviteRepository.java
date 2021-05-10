package com.example.Actorep.dao;

import com.example.Actorep.entities.Activite;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ActiviteRepository extends JpaRepository<Activite,Integer> {

	public List<Activite> findAllByLibelleActiviteContains (String libelleActivite); //AJB
	
}


