package fr.limayrac.messagerie_persistance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.limayrac.messagerie_persistance.service.UtilisateurService;

import fr.limayrac.messagerie_persistance.models.Utilisateur;


@RestController
public class ConnexionFormController {

	@Autowired
	  private UtilisateurService utilisateurService;


@GetMapping("/connexion")
public ModelAndView connexionForm(Model model) {
		Utilisateur user = new Utilisateur();
	    return new ModelAndView("connexionForm","user",user);
	  }

@PostMapping("/connexion")
public String connexionUser(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
	  utilisateurService.checkUserConnection(utilisateur);
	  return "connexionSuccess";
}

}

