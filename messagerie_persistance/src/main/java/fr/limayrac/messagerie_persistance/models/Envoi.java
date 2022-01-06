package fr.limayrac.messagerie_persistance.models;

import javax.persistence.*;

@Entity
@Table(name = "envoi")

public class Envoi {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@ManyToOne
    @JoinColumn(name = "idDestinataire")
    private Utilisateur utilisateur;
	
	@OneToOne
    @JoinColumn(name = "idMessage")
    private Message envoi;
}

