package fr.limayrac.messagerie_persistance.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class SendController {

  @GetMapping("/envoie")
  public String envoie(Model model) {
    return "sendMessageInterface";
  }
}