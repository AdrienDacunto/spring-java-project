package com.banque.persistance.model;

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
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Message getEnvoi() {
		return envoi;
	}

	public void setEnvoi(Message envoi) {
		this.envoi = envoi;
	}
}

