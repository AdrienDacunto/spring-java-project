package fr.limayrac.controller;

import fr.limayrac.models.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ConnexionFormController {

  @GetMapping("/connexion")
  public String connexionForm(Model model) {
    model.addAttribute("user", new Utilisateur());
    return "connexionForm";
  }

  @PostMapping("/connexion")
  public String connexionSubmit(@ModelAttribute Utilisateur user) {
    return "connexionSuccess";
  }

}

