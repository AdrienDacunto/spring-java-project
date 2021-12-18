package fr.limayrac.controller;

import fr.limayrac.models.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class sendMessageForm {

  @GetMapping("/envoi_formulaire")
  public String envoiForm(Model model) {
    model.addAttribute("user", new Utilisateur());
    return "sendMessageForm";
  }

  @PostMapping("/envoi_formulaire")
  public String envoiSubmit(@ModelAttribute Utilisateur user) {
    return "sendFormSuccess";
  }

}