package com.banque.persistance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.banque.persistance.model.Envoi;
import com.banque.persistance.model.Message;
import com.banque.persistance.model.Utilisateur;
import com.banque.persistance.repository.EnvoiRepository;
import com.banque.persistance.repository.MessageRepository;
import com.banque.persistance.repository.UtilisateurRepository;

import lombok.Data;

@Data
@Service
public class MessageService {
	
	private final MessageRepository messageRepository;
	private final EnvoiRepository envoiRepository;
	private final UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public MessageService(MessageRepository messageRepository, EnvoiRepository envoiRepository,
			UtilisateurRepository utilisateurRepository) {
		super();
		this.messageRepository = messageRepository;
		this.envoiRepository = envoiRepository;
		this.utilisateurRepository = utilisateurRepository;
	}
	

	public void addNewMessage(Message message, Envoi envoi, List<String> Emails) {
		//Save Message
		
		messageRepository.save(message);
		
		//Get id of Message
		
		int id = message.getId();
		
		//Get id of User
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		Utilisateur utilisateur = utilisateurRepository.findByUsernameOrEmail(username);
		
		//int userid = utilisateur.getId();
		
		//Update message request
		
		message.setIdPredecesseur(0);
		message.setStatus("non-lu");
		message.setUtilisateur(utilisateur);
		
		messageRepository.save(message);
		
		//Get Email of every users concerned
		
		
		for (String email : Emails){
			
			//Insert in Envoi with idDestinataire of every mails + the idMessage
		
			Utilisateur utilisateur_envoi = utilisateurRepository.findByUsernameOrEmail(email);
		
			//int id_envoi = utilisateur_envoi.getId();
		
		
			Envoi envoi_email = new Envoi();
		
			envoi_email.setUtilisateur(utilisateur_envoi);
		
			envoi_email.setEnvoi(message);
		
			envoiRepository.save(envoi_email);
		}
	}
	
	
	


	public List<Message> getMessageByEmail(String username) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username1 = auth.getName();
		
		Utilisateur utilisateur = utilisateurRepository.findByUsernameOrEmail(username1);
		
		int id_user = utilisateur.getId();
		
		//Get all envoi
		
		Utilisateur utilisateur_envoi = new Utilisateur();
		List<Envoi> envois = envoiRepository.findAll();
		List<Message> message = new ArrayList<Message>();
		
		for (Envoi envoi : envois) {
			 utilisateur_envoi = envoi.getUtilisateur();
			 if(utilisateur_envoi == utilisateur ) {
				 message.add(envoi.getEnvoi());
			 }
	    }
		
		return message;		
		
	}
	
	public List<Message> sendInterfaceByEmail(String username){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username1 = auth.getName();
		
		Utilisateur utilisateur = utilisateurRepository.findByUsernameOrEmail(username1);
		
		int id_user = utilisateur.getId();
		
	
		
		List<Message> messages = messageRepository.findAll();
		List<Message> message = new ArrayList<Message>();
		
		for (Message message_envoi : messages) {
			 if(message_envoi.getUtilisateur() == utilisateur ) {
				 message.add(message_envoi);
			 }
	    }
		return message;
	}
	
	
	
}
