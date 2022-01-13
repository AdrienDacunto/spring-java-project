package com.banque.persistance.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.persistance.model.Utilisateur;
import com.banque.persistance.repository.UtilisateurRepository;
import lombok.Data;

@Data
@Service
public class UtilisateurService {
	
	
	private final UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		super();
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public List<Utilisateur> getUtilisateurs(){
		return utilisateurRepository.findAll();
	}

	public void addNewUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		Optional<Utilisateur> userOptional = utilisateurRepository.findUserByEmail(utilisateur.getEmail());
		
		if(userOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		utilisateurRepository.save(utilisateur);
	}
	public void checkUserConnection(Utilisateur utilisateur) {
		Optional<Utilisateur> userOptional = utilisateurRepository.isCorrectUser(utilisateur.getEmail(), utilisateur.getMotDePasse());
		
		if(userOptional.isEmpty()) {
			throw new IllegalStateException("email or password incorrect");
		}
		
		
	}
	@Transactional(readOnly = true)
	public Utilisateur FindUsernameByMail (String Email) {
		Utilisateur user = null;
		try {
			user = utilisateurRepository.findByUsernameOrEmail(Email);
		} catch (Exception e) {
			throw e;
		}
		return user;
	}
	
}
