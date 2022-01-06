package fr.limayrac.messagerie_persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.limayrac.messagerie_persistance.models.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
}
