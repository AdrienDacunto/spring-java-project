package com.banque.persistance.repository;

import com.banque.persistance.model.Envoi;
import com.banque.persistance.model.Message;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnvoiRepository extends JpaRepository<Envoi, Integer> {

	/*
	 * @Query("SELECT e FROM Envoi m WHERE m.id = ?1") Optional<Message>
	 * findEnvoiById(int Id);
	 */
	/*
	 * @Query("") Optional<Message> insertEnvoiById(int Id);
	 */
	
	//@Query("insert into Envoi (id)")
}
