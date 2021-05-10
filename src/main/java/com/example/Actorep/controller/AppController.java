package com.example.Actorep.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Actorep.entities.*;
import com.example.Actorep.model.*;
import com.example.Actorep.service.*;

@RestController
public class AppController {
	
	HttpSession session;
	String username = "visiteur";
	boolean isAdmin = false;
	
	@Autowired
    private ActeurService acteurService;
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private MetierService metierService;
	
	@Autowired
	private ActiviteActeurService activiteActeurService;
	
	@Autowired
    AuthService authService;

    @Autowired
    InscriptionService inscriptionService;

    @Autowired
    PaysService paysService;

    @Autowired
    ExperienceService experienceService;
    
    @Autowired
    CompteService compteService;
    
    @Autowired
	private ActiviteService activiteService;

	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////// ANOUJEAN ////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
	
	//chargement vue------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/Actorep")
    public ModelAndView viewHome(Model model) { // AJB
		RechercheHomeModel rhm = new RechercheHomeModel();
		model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
		model.addAttribute("RechercheHomeModel", rhm);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
        return mv;
    }
	
	
	@RequestMapping("/Actorep/Recherche")
    public ModelAndView searchActor(Model model, @ModelAttribute("RechercheHomeModel") RechercheHomeModel rhm) { //AJB
		List<Acteur> lesActeurs = acteurService.findAllByNomContaining(rhm.getRecherche());
		model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
		model.addAttribute("RechercheHomeModel", rhm);
		model.addAttribute("lesActeurs", lesActeurs);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recherche.html");
        return mv;
    }
	
	@RequestMapping("/Actorep/Profile")
    public ModelAndView profilActor(Model model, @RequestParam("idActeur") int idActeur) { //AJB
		Acteur acteur = acteurService.findActeurById(idActeur);
		model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
		model.addAttribute("acteur", acteur);
		model.addAttribute("services", activiteActeurService.getServicesByActor(acteur));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("profile.html");
        return mv;
    }
	
	
	//Appel Ajax ----------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping ("/getCategorie")
    public List<Categorie> findAllCategorie(){ //AJB
        return categorieService.findAllCategorie();
    }
	
	@RequestMapping ("/getMetier")
    public List<Metier> findAllMetier(){ //AJB
        return metierService.findAllMetier();
    }
	
	@RequestMapping ("/getActeurService")
    public List<ActiviteActeur> findAllActeurActivite(){ //AJB
        return activiteActeurService.getAll();
    }
	
	@RequestMapping ("/getAllActeurByAttribute")
	public List<Acteur> findAllActeurValidByAttribute( @RequestParam("recherche") String recherche,  @RequestParam("type") String type){ //AJB
		if ("metier".equals(type)) {
			return acteurService.findAllByMetierContains(recherche);
		}
		if ("categorie".equals(type)) {
			return acteurService.findAllByCategorieContains(recherche);
		}
		if("pays".equals(type)) {
			return acteurService.findAllByPaysContains(recherche);
		}
		if("service".equals(type)) {
			return acteurService.findAllByActiviteIn(recherche);
		}
		return acteurService.findAllByNomContaining(recherche);
    }
	
	@RequestMapping ("/getAllActeurByFiltre")
	public List<Acteur> findAllActeurValidByFiltre (@RequestParam("recherche") String recherche,  @RequestParam("type") String type, @RequestParam("rechercheFiltre") String rechercheFiltre,  @RequestParam("typeFiltre") String typeFiltre){ //AJB
		List<Acteur> lesActeurs = acteurService.findAllByNomContaining(recherche);
		
		if ("metier".equals(type)) {
			if ("categorie".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByMetierAndCategorieContains(recherche, rechercheFiltre);
			}
			else if ("location".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByMetierAndLocation(recherche, rechercheFiltre, rechercheFiltre);
			}
			else if ("service".equals(typeFiltre)) {
				// à implémenter
			}
			else if ("acteur".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByMetierAndActeur(recherche, rechercheFiltre);
			}
		}
		
		if ("categorie".equals(type)) {
			if ("service".equals(typeFiltre)) {
				//à implémenter
			}
			else if ("location".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByCategorieAndLocation(recherche, rechercheFiltre, rechercheFiltre);
			}
			else if ("metier".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByMetierAndCategorieContains(rechercheFiltre, recherche);
			}
			else if ("acteur".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByCategorieAndActeur(recherche, rechercheFiltre);
			}
		}
		
		if("acteur".equals(type)) {
			if ("categorie".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByCategorieAndActeur(rechercheFiltre, recherche);
			}
			else if ("location".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByActeurAndLocation(recherche, rechercheFiltre, rechercheFiltre);
			}
			else if ("metier".equals(typeFiltre)) {
				lesActeurs = acteurService.findAllByMetierAndActeur(rechercheFiltre, recherche);
			}
			else if ("service".equals(typeFiltre)) {
				//à implémenter
			}
		}
		
		if("service".equals(type)) {
			if ("categorie".equals(typeFiltre)) {}
			else if ("location".equals(typeFiltre)) {}
			else if ("metier".equals(typeFiltre)) {}
			else if ("acteur".equals(typeFiltre)) {}
		}
		
		return lesActeurs;
    }
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////// AHMED ///////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// ******************************************************
    // Chargement de vue
    // ******************************************************

    @GetMapping("/compte")
    public ModelAndView viewCompte(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
        modelAndView.setViewName("compte.html");
        return modelAndView;
    }

    @GetMapping("/service")
    public ModelAndView viewService(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
        modelAndView.setViewName("service.html");
        return modelAndView;
    }

    @GetMapping("/experience")
    public ModelAndView viewExperience(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
        modelAndView.setViewName("experience.html");
        return modelAndView;
    }

    @GetMapping("/inscription")
    public ModelAndView viewInscription(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
        modelAndView.setViewName("inscription.html");
        return modelAndView;
    }

    // AHMED
    @RequestMapping("/service") // permet d'aller vers la page service
    public ModelAndView showServicePage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
        modelAndView.setViewName("service.html");
        return modelAndView;
    }



    // ******************************************************
    // Méthodes Post
    // ******************************************************


    @RequestMapping(value = {"/identification"})
    public InscriptionModel identification(@RequestBody InscriptionModel inscriptionModel, HttpServletRequest request) throws IOException {


        InscriptionModel inscriptionModel1= authService.CheckAuth(inscriptionModel);
        if(inscriptionModel1!= null) {
            Compte compte = authService.searchCompte(inscriptionModel);
            session = request.getSession();
            session.setAttribute("compte", compte);
            username = compte.getUsername();
            isAdmin = compte.isAdmin();
           return inscriptionModel;

        }else{

            return inscriptionModel;
        }


    }

    @RequestMapping(value="/save",  method = RequestMethod.POST )
    public void inscription(@RequestBody InscriptionModel inscriprionModel) {

        inscriptionService.save(inscriprionModel);

    }

    @RequestMapping("/update")
    public void update(@RequestBody InscriptionModel inscriprionModel) {

        inscriptionService.updateActeur(inscriprionModel, (Compte) session.getAttribute("compte"));

    }

    @RequestMapping("/deconnexion")
    public RedirectView Deconnexion() {
    	    	
    	if(session==null){
    		username = "visiteur";
            isAdmin = false;

    	}
    	else {
    		session.setAttribute("compte", null);
            username = "visiteur";
            isAdmin = false;
    	}

        
        
        return new RedirectView("/inscription");

    }


    // AHMED
    @RequestMapping("/updatePassword")
    public void updatePasswordActeur(@RequestBody InscriptionModel inscriptionModel) {
        inscriptionService.updatePasswordActeur(inscriptionModel,(Compte) session.getAttribute("compte"));

    }

    @RequestMapping(value="/addExperience",  method = RequestMethod.POST )
    public ExperienceModel addExperience(@RequestBody ExperienceModel experienceModel) {

        ExperienceModel e =experienceService.saveExperience(experienceModel,(Compte) session.getAttribute("compte"));


        return e;
    }

    @RequestMapping(value="/addService",  method = RequestMethod.POST )
    public ActiviteActeurModel addService(@RequestBody ActiviteActeurModel activiteActeurModel) {

        ActiviteActeurModel a = activiteActeurService.saveActiviteActeur(activiteActeurModel,(Compte) session.getAttribute("compte"));
        return a;
    }

    // ******************************************************
    // Méthodes Get
    // ******************************************************


    @RequestMapping (value="/getPays",  method = RequestMethod.GET)
    private List<PaysModel> getAllPays(){
        return paysService.getAllPays();

    }

    @RequestMapping (value="/getMetier",  method = RequestMethod.GET)
    private List<MetierModel> getAllMetier(){
        return metierService.getAllMetier();

    }

    @RequestMapping (value="/getCategorie",   method = RequestMethod.GET)
    private List<CategorieModel> getAllCategorie(){
        return categorieService.getAllCategorie();

    }

    @RequestMapping (value="/getCompte",   method = RequestMethod.GET)
    private InscriptionModel getInscriptionModel(){
        return inscriptionService.getActeur((Compte) session.getAttribute("compte"));

    }

    @RequestMapping (value="/getExperience",   method = RequestMethod.GET)
    private List<ExperienceModel> getExperienceModel(){
        return experienceService.getExperienceByIdActeur((Compte) session.getAttribute("compte"));

    }

    @RequestMapping (value="/getService",   method = RequestMethod.GET)
    private List<ActiviteActeurModel> getActiviteActeurModelModel(){
        return activiteActeurService.getActiviteActeurByIdActeur((Compte) session.getAttribute("compte"));


    }

    // ******************************************************
    // Méthodes Delete
    // ******************************************************

    @RequestMapping (value="/deleteExperience",   method = RequestMethod.POST)
    private void deleteExperience(@RequestBody ExperienceModel experienceModel){
        experienceService.deleteExperience(experienceModel);

    }

    @RequestMapping (value="/deleteService",  method = RequestMethod.POST)
    private void deleteService(@RequestBody ActiviteActeurModel activiteActeurModel){
        activiteActeurService.deleteActiviteActeur(activiteActeurModel);

    }
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////// ELIAS ///////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @RequestMapping("/Actorep/valideradmin")
    public ModelAndView vue(Model model) {
        List<Compte> lesComptes = compteService.GetAllFalseCompte();
		model.addAttribute("lesComptes", lesComptes);
		
		
      
		model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("valideradmin.html");
        return modelAndView;
        
        
    }
	
	@RequestMapping("/Actorep/modereradmin")
    public ModelAndView vuemoderer(Model model) {
		
		List<Compte> lesComptes = compteService.GetAllCompte();
		model.addAttribute("lesComptes", lesComptes);
      
		model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("modereradmin.html");
        return modelAndView;
        
        
    }
	
	@RequestMapping("/Actorep/datafeedadmin")
    public ModelAndView vuedatafeed(Model model, @ModelAttribute("ChampsajouterModel") ChampsajouterModel cam) {
		
		
		model.addAttribute("ChampsajouterModel", cam);
		
		
		
		List<Categorie> lesCategories = categorieService.GetAllCategorie();
		for( Categorie c : lesCategories) {
			System.out.println(c.getLibelleCategorie());
		}
		
		model.addAttribute("lesCategories", lesCategories);
		
		List<Activite> lesActivites = activiteService.findAllActivite();
		for( Activite a : lesActivites) {
			System.out.println(a.getLibelleActivite());
		}
		
		model.addAttribute("lesActivites", lesActivites);
		
		List<Metier> lesMetiers = metierService.getAllMetiers();
		for( Metier m : lesMetiers) {
			System.out.println(m.getLibelleMetier());
		}
		
		model.addAttribute("lesMetiers", lesMetiers);
		
		
		model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("datafeedadmin.html");
        return modelAndView;
        
        
    }
	
	@RequestMapping("/Actorep/datafeedadmin1")
    public RedirectView vuedatafeed1(Model model, @ModelAttribute("ChampsajouterModel") ChampsajouterModel cam) {
		
		
		model.addAttribute("ChampsajouterModel", cam);
		
		
		categorieService.addcat(cam.getChamps());
		
		
        return new RedirectView("/Actorep/datafeedadmin");
        
        
    }
	
	
	
	@RequestMapping("/Actorep/datafeedadmin2")
    public RedirectView vuedatafeed2(Model model, @ModelAttribute("ChampsajouterModel") ChampsajouterModel cam) {
		
		
		model.addAttribute("ChampsajouterModel", cam);
		
		
		activiteService.addAct(cam.getChamps());
		
		
		
		model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
		
		
		return new RedirectView("/Actorep/datafeedadmin");
        
        
    }
	
	
	@RequestMapping("/Actorep/datafeedadmin3")
    public RedirectView vuedatafeed3(Model model, @ModelAttribute("ChampsajouterModel") ChampsajouterModel cam) {
		
		
		model.addAttribute("ChampsajouterModel", cam);
		
		
		metierService.addMetier(cam.getChamps());
		
		
		
		model.addAttribute("user",username);
		model.addAttribute("admin",isAdmin);
		
	 return new RedirectView("/Actorep/datafeedadmin");
        
        
    }
	
	
	
	@RequestMapping("/valideradmin")
    public RedirectView vue( @RequestParam("section") String section,  @RequestParam("idCompte") int idcompte, @RequestParam("idActeur") int idacteur) {
		
		
		
		if ("validerprofil".equals(section)) {
			
			compteService.modifierIsValid(idcompte);
			
		}
		if ("profilcomplet".equals(section)) {
			
		}
		if ("deleteprofil".equals(section)) {
			
		
		
		compteService.deleteByIdCompte(idcompte);	
		}

		return new RedirectView("/Actorep/valideradmin");
		
		
		
        
    }
	
	
	@RequestMapping("/modereradmin")
    public RedirectView vue2( @RequestParam("section") String section,  @RequestParam("idCompte") int idcompte, @RequestParam("idActeur") int idacteur) {
		
		
		
		
		if ("profilcomplet".equals(section)) {
			
		}
		if ("deleteprofil".equals(section)) {
			
		
		
		compteService.deleteByIdCompte(idcompte);	
		}

		return new RedirectView("/Actorep/modereradmin");
		
		
		
        
    }
	

}
