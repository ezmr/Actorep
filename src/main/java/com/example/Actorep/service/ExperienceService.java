package com.example.Actorep.service;

import com.example.Actorep.dao.ActeurRepository;
import com.example.Actorep.dao.ExperienceRepository;
import com.example.Actorep.entities.Acteur;
import com.example.Actorep.entities.Compte;
import com.example.Actorep.entities.Experience;
import com.example.Actorep.model.ExperienceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    ActeurRepository acteurRepository;



    public List<ExperienceModel> getExperienceByIdActeur(Compte compte){
        List<Experience> lesExperiences = experienceRepository.findExperienceByActeurIdActeur(compte.getActeur().getIdActeur());
        List<ExperienceModel> lesExperiencesModel = new ArrayList();

        for(Experience e : lesExperiences){
            ExperienceModel experienceModel = new ExperienceModel();
            experienceModel.setIdExperience(e.getIdExperience());
            experienceModel.setObjet(e.getObjet());
            experienceModel.setDateDebut(e.getDateDebut());
            experienceModel.setDateFin(e.getDateFin());
            experienceModel.setDescription(e.getDescription());
            lesExperiencesModel.add(experienceModel);

        }

        return lesExperiencesModel;
    }

    public ExperienceModel saveExperience(ExperienceModel experienceModel, Compte compte){

        Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur()).get();
        //Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur());
        Experience experience = new Experience();
        experience.setObjet(experienceModel.getObjet());
        experience.setDateDebut(experienceModel.getDateDebut());
        experience.setDateFin(experienceModel.getDateFin());
        experience.setDescription(experienceModel.getDescription());
        experience.setActeur(acteur);
        experienceRepository.save(experience);

        ExperienceModel e = new ExperienceModel();
        e.setIdExperience(experience.getIdExperience());
        e.setObjet(experience.getObjet());
        e.setDateDebut(experience.getDateDebut());
        e.setDateFin(experience.getDateFin());
        e.setDescription(experience.getDescription());

        return e;

    }

    public void deleteExperience(ExperienceModel experienceModel){

        experienceRepository.deleteById(experienceModel.getIdExperience());


    }
}

