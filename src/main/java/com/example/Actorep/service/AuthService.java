package com.example.Actorep.service;

import com.example.Actorep.dao.CompteRepository;
import com.example.Actorep.entities.Compte;
import com.example.Actorep.model.InscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private CompteRepository cr;

    public InscriptionModel CheckAuth(InscriptionModel inscriptionModel) {

        Compte compte = cr.findCompteByUsername(inscriptionModel.getUsername());

        if (compte != null) {
            if (compte.getPassword().equals(inscriptionModel.getPassword())) {

                inscriptionModel.setNom(compte.getActeur().getNom());
                inscriptionModel.setMail((compte.getActeur().getMail()));
                inscriptionModel.setTelephone(compte.getActeur().getTelephone());
                inscriptionModel.setPresentation(compte.getActeur().getPresentation());
                inscriptionModel.setImage(compte.getActeur().getImage());
                inscriptionModel.setVideo(compte.getActeur().getVideo());
                inscriptionModel.setValid(compte.isValid());
                inscriptionModel.setAdmin(compte.isAdmin());

                return inscriptionModel;
            }else{
                inscriptionModel = null;
            }
        } else {

            inscriptionModel = null;
        }
        return inscriptionModel;
    }

    public Compte searchCompte(InscriptionModel inscriptionModel) {

        Compte compte = cr.findCompteByUsername(inscriptionModel.getUsername());

        if (compte != null) {
            if (compte.getPassword().equals(inscriptionModel.getPassword())) {

                return compte;
            }else{
                compte = null;
            }
        } else {

            compte = null;
        }
        return compte;
    }
}
