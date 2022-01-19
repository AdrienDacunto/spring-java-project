
  package com.banque.persistance.controller;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import
  org.springframework.stereotype.Controller; import
  org.springframework.ui.Model; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.ModelAttribute; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RestController; import
  org.springframework.web.servlet.ModelAndView; import
  com.banque.persistance.model.Utilisateur;
import com.banque.persistance.service.MessageService;
import
  com.banque.persistance.service.UtilisateurService;
  
  
  @RestController 
  public class ConnexionFormController {
  
  @Autowired 
  private UtilisateurService utilisateurService;
  @Autowired
  private MessageService messageService;
  
  @GetMapping("/welcome") 
  public ModelAndView welcome(Model model,String error, String logout) {
	  Utilisateur user = new Utilisateur(); 
	  return new ModelAndView("welcome","user",user); 
	  }
  
  @GetMapping("/reception") 
  public ModelAndView reception(Model model) {
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  String username = auth.getName();
	  System.out.println(username);
	  if(username.isEmpty()) {
		  return new ModelAndView("connexionForm","user", username);
	  }
	  return new ModelAndView("getMessageInterface","users", messageService.getMessageByEmail(username));
  }
  
  @GetMapping("/envoie") 
  public ModelAndView envoi(Model model) {
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  String username = auth.getName();
	  System.out.println(username);
	  if(username.isEmpty()) {
		  return new ModelAndView("connexionForm","user", username);
	  }
	  return new ModelAndView("sendMessageInterface","users", messageService.sendInterfaceByEmail(username));
  }
}
  
 

 