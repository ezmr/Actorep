package com.example.Actorep.dao;

import com.example.Actorep.entities.Experience;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
	
	public List<Experience> findExperienceByActeurIdActeur(int ActeuridActeur);
	
}


