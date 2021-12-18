package fr.limayrac.controller;


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