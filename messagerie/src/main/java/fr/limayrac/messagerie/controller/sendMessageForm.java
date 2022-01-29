package fr.limayrac.messagerie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.limayrac.messagerie.model.*;
import fr.limayrac.messagerie.service.MessageService;
import fr.limayrac.messagerie.service.UtilisateurService;


@Controller
public class sendMessageForm {
	
  @Autowired
  private MessageService messageService;
	
  @GetMapping("/envoi_formulaire")
  public String envoiForm(Model model) {
    model.addAttribute("message", new Message());
    return "sendMessageForm";
  }

  @PostMapping("/envoi_formulaire")
  public String envoiSubmit(@ModelAttribute Message message, @ModelAttribute Envoi envoi, @RequestParam(required = false, name="emails") List<String> emails) {
	messageService.addNewMessage(message, envoi, emails);
    return "sendFormSuccess";
  }

}