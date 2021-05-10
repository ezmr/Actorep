package com.example.Actorep.service;

import com.example.Actorep.dao.*;
import com.example.Actorep.entities.*;
import com.example.Actorep.model.InscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InscriptionService {

    @Autowired
    ActeurRepository acteurRepository;

    @Autowired
    AdresseRepository adresseRepository;

    @Autowired
    PaysRepository paysRepository;

    @Autowired
    MetierRepository metierRepository;

    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    CompteRepository compteRepository;

    public void save(InscriptionModel inscriprionModel){
        Acteur acteur = new Acteur();
        Adresse adresse = new Adresse();
        Pays pays = new Pays();
        Metier metier = new Metier();
        Compte compte = new Compte();

        Categorie categorie = categorieRepository.findCategorieByLibelleCategorie(inscriprionModel.getLibelleCategorie());

        acteur.setCategorie(categorie);

        metier = metierRepository.findMetierByLibelleMetier(inscriprionModel.getLibelleMetier());

        acteur.setMetier(metier);

        acteur.setNom(inscriprionModel.getNom());
        acteur.setMail(inscriprionModel.getMail());
        acteur.setTelephone(inscriprionModel.getTelephone());
        acteur.setImage(inscriprionModel.getImage());
        acteur.setVideo(inscriprionModel.getVideo());
        acteur.setPresentation(inscriprionModel.getPresentation());
        acteurRepository.save(acteur);
        adresse.setActeur(acteur);

        pays = paysRepository.findPaysByLibellePays(inscriprionModel.getLibellePays());

        adresse.setPays(pays);

        adresse.setLibelleAdresse(inscriprionModel.getAdresse());
        adresse.setVille(inscriprionModel.getVille());
        adresse.setCodePosal(inscriprionModel.getCodePostal());
        adresseRepository.save(adresse);
        adresse.setActeur(acteur);

        compte.setUsername(inscriprionModel.getMail());
        compte.setPassword(inscriprionModel.getPassword());
        compte.setValid(false);
        compte.setAdmin(false);
        compteRepository.save(compte);
        compte.setActeur(acteur);

    }

    public InscriptionModel getActeur(Compte compte){
        InscriptionModel inscriptionModel = new InscriptionModel();
        Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur()).get();
        //Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur());
        Adresse adresse = adresseRepository.findAdresseByActeurIdActeur(compte.getActeur().getIdActeur());


        inscriptionModel.setNom(acteur.getNom());
        inscriptionModel.setMail(acteur.getMail());
        inscriptionModel.setTelephone(acteur.getTelephone());
        inscriptionModel.setPresentation(acteur.getPresentation());
        inscriptionModel.setImage(acteur.getImage());
        inscriptionModel.setVideo(acteur.getVideo());

        inscriptionModel.setAdresse(adresse.getLibelleAdresse());
        inscriptionModel.setVille(adresse.getVille());
        inscriptionModel.setCodePostal(adresse.getCodePosal());

        inscriptionModel.setLibellePays(adresse.getPays().getLibellePays());

        inscriptionModel.setLibelleMetier(acteur.getMetier().getLibelleMetier());

        inscriptionModel.setLibelleCategorie(acteur.getCategorie().getLibelleCategorie());

        inscriptionModel.setUsername(acteur.getCompte().getUsername());
        inscriptionModel.setPassword(acteur.getCompte().getPassword());


        return inscriptionModel;
    }

    public void updateActeur(InscriptionModel inscriprionModel, Compte compte){
        Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur()).get();
        //Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur());
        acteur.setNom(inscriprionModel.getNom());
        acteur.setMail(inscriprionModel.getMail());
        acteur.setTelephone(inscriprionModel.getTelephone());
        acteur.setPresentation(inscriprionModel.getPresentation());
        acteur.setImage(inscriprionModel.getImage());
        acteur.setVideo(inscriprionModel.getVideo());

        Adresse adresse = adresseRepository.findAdresseByActeurIdActeur(compte.getActeur().getIdActeur());
        adresse.setLibelleAdresse(inscriprionModel.getAdresse());
        adresse.setVille(inscriprionModel.getVille());
        adresse.setCodePosal(inscriprionModel.getCodePostal());


        Pays pays= paysRepository.findPaysByLibellePays(inscriprionModel.getLibellePays());
        adresse.setPays(pays);

        Metier metier = metierRepository.findMetierByLibelleMetier(inscriprionModel.getLibelleMetier());
        acteur.setMetier(metier);

        Categorie categorie = categorieRepository.findCategorieByLibelleCategorie(inscriprionModel.getLibelleCategorie());
        acteur.setCategorie(categorie);

        acteurRepository.save(acteur);

    }

//serice + controleur

    public void updatePasswordActeur(InscriptionModel inscriprionModel, Compte compte){
        Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur()).get();
        //Acteur acteur = acteurRepository.findById(compte.getActeur().getIdActeur());

        compte.setUsername(inscriprionModel.getUsername());
        compte.setPassword(inscriprionModel.getPassword());
        compte.setValid(false);
        compte.setActeur(acteur);
        compteRepository.save(compte);


    }
}
