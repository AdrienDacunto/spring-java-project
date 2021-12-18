package fr.limayrac.controller;

import fr.limayrac.models.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class InscriptionFormController {

  @GetMapping("/inscription")
  public String inscriptionForm(Model model) {
    model.addAttribute("user", new Utilisateur());
    return "inscriptionForm";
  }

  @PostMapping("/inscription")
  public String inscriptionSubmit(@ModelAttribute Utilisateur user) {
    return "inscriptionSuccess";
  }

}

