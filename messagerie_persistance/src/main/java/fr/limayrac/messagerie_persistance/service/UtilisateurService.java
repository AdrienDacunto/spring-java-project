package fr.limayrac.messagerie_persistance.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.limayrac.messagerie_persistance.models.Utilisateur;
import fr.limayrac.messagerie_persistance.repository.UtilisateurRepository;
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
		//utilisateurRepository.
	}
}
