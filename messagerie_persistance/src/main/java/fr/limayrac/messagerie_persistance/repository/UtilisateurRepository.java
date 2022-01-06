package fr.limayrac.messagerie_persistance.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.limayrac.messagerie_persistance.models.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

		@Query("SELECT u FROM Utilisateur u WHERE u.email = ?1")
		Optional<Utilisateur> findUserByEmail(String Email);
		
		@Query("SELECT u FROM Utilisateur u WHERE u.email = ?1 AND u.motDePasse = ?2")
		Optional<Utilisateur> isCorrectUser(String Email, String motDePasse);
}
