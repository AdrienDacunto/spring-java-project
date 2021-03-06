package fr.limayrac.messagerie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.limayrac.messagerie.model.Utilisateur;
import fr.limayrac.messagerie.service.UtilisateurService;


@RestController
public class InscriptionFormController {
  @Autowired
  private UtilisateurService utilisateurService;


  @GetMapping("/inscription")
  public ModelAndView inscriptionForm(Model model) {
	Utilisateur user = new Utilisateur();
    return new ModelAndView("inscriptionForm","user",user);
  }

  @PostMapping("/inscription")
  public ModelAndView registerNewUser(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
	  Utilisateur user = new Utilisateur();
	  utilisateurService.addNewUser(utilisateur);
	  return new ModelAndView("inscriptionSuccess","user",user);
  }
}

