package com.banque.persistance.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.banque.persistance.model.Message;
import com.banque.persistance.model.Utilisateur;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	/*
	 * @Modifying
	 * 
	 * @Query("INSERT into Message(contenu,date_time,id_predecesseur,status,id_emmeteur,objet) VALUES (:contenu, :date_time, :id_predecesseur, :status, :id_emmeteur, :objet)"
	 * )
	 * 
	 * @Transactional void insertNewMessage(String contenu, LocalDate date_time, int
	 * id_predecesseur, String status, int id_emmeteur, String objet);
	 */
	@Modifying
	@Query("update Message m set id_predecesseur = 0, status = 'non-lu', id_emmeteur = ?1 where m.id = ?2")
	void updateMessage(int idEmmeteur, int Id);
	
	@Query("SELECT m FROM Message m WHERE m.id = ?1")
	Optional<Message> findMessageById(int Id);
	
}
