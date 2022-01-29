package fr.limayrac.messagerie.repository;

import fr.limayrac.messagerie.model.Envoi;
import fr.limayrac.messagerie.model.Message;
import fr.limayrac.messagerie.model.Utilisateur;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnvoiRepository extends JpaRepository<Envoi, Integer> {


}
