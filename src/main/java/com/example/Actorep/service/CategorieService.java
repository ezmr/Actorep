package com.example.Actorep.service;

import com.example.Actorep.dao.CategorieRepository;
import com.example.Actorep.entities.Acteur;
import com.example.Actorep.entities.Categorie;
import com.example.Actorep.entities.Metier;
import com.example.Actorep.model.CategorieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository cr;

    public List<CategorieModel> getAllCategorie(){
        List<Categorie> lesCategories = cr.findAll();
        List<CategorieModel> lesCategoriesModel = new ArrayList();
        for(Categorie categorie : lesCategories){
            CategorieModel categorieModel = new CategorieModel();
            categorieModel.setLibelleCategorie(categorie.getLibelleCategorie());
            lesCategoriesModel.add(categorieModel);
        }
        return lesCategoriesModel ;
    }

    public CategorieModel getByIdCategorie(int idCategorie){
        Categorie categorie = cr.findById(idCategorie).get();
        CategorieModel categorieModel = new CategorieModel();
        categorieModel.setLibelleCategorie(categorie.getLibelleCategorie());
        return categorieModel;
    }

    public void saveCategorie(CategorieModel categorieModel){
        Categorie categorie = new Categorie();
        categorie.setLibelleCategorie(categorieModel.getLibelleCategorie());
        cr.save(categorie);
    }

    public void deleteCategorie(CategorieModel categorieModel){
        Categorie categorie = new Categorie();
        categorie.setLibelleCategorie(categorieModel.getLibelleCategorie());
        cr.delete(categorie);
    }

    public void deleByIdCategorie(int idCategorie){
        cr.deleteById(idCategorie);
    }
    
    
    //-----------------------------------------------------------
    public List<Categorie> findAllCategorie(){ //AJB
        List<Categorie> lesCategories = cr.findAll();
        return lesCategories ;
    }
    
    public List<Categorie> GetAllCategorie() { //Elias
        return cr.findAll();
    }
	
	public void addcat(String s) { //Elias
		
		Categorie categorie = new Categorie();
		categorie.setLibelleCategorie(s);
		cr.save(categorie);  
		
	}
    
    
    
    
}

