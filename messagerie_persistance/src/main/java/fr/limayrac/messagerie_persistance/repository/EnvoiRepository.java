package com.banque.persistance.repository;

import com.banque.persistance.model.Envoi;
import com.banque.persistance.model.Message;
import com.banque.persistance.model.Utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnvoiRepository extends JpaRepository<Envoi, Integer> {

	/*
	 * @Query("SELECT e FROM Envoi m WHERE m.id = ?1") Optional<Message>
	 * findEnvoiById(int Id);
	 */
	
	/*
	 * @Query("SELECT e FROM Envoi e WHERE e.id_destinataire = ?1") List<Envoi>
	 * findEnvoiById(int Id);
	 */
	
}
