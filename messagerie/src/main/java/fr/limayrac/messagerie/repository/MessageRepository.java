package fr.limayrac.messagerie.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.limayrac.messagerie.model.Message;
import fr.limayrac.messagerie.model.Utilisateur;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	@Modifying
	@Query("update Message m set id_predecesseur = 0, status = 'non-lu', id_emmeteur = ?1 where m.id = ?2")
	void updateMessage(int idEmmeteur, int Id);
	
	@Query("SELECT m FROM Message m WHERE m.id = ?1")
	Optional<Message> findMessageById(int Id);
	
}
