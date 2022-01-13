package com.banque.persistance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.banque.persistance.model.Utilisateur;
import com.banque.persistance.service.UtilisateurService;


@RestController
public class InscriptionFormController {
  @Autowired
  private UtilisateurService utilisateurService;


  @GetMapping("/inscription")
  public ModelAndView inscriptionForm(Model model) {
	Utilisateur user = new Utilisateur();
    return new ModelAndView("inscriptionForm","user",user);
  }

	/*
	 * @PostMapping("/inscription") public String inscriptionSubmit(@ModelAttribute
	 * Utilisateur user) { return "inscriptionSuccess"; }
	 */

  @PostMapping("/inscription")
  public ModelAndView registerNewUser(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
	  Utilisateur user = new Utilisateur();
	  utilisateurService.addNewUser(utilisateur);
	  return new ModelAndView("inscriptionSuccess","user",user);
  }
}

