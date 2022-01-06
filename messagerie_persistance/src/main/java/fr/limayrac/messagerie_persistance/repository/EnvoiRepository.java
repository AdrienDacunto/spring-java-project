package fr.limayrac.messagerie_persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.limayrac.messagerie_persistance.models.Envoi;
public interface EnvoiRepository extends JpaRepository<Envoi, Integer> {

}
