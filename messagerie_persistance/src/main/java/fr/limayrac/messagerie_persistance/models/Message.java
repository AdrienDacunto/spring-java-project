package fr.limayrac.messagerie_persistance.models;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "contenu", length = 30, nullable = false)
	private String contenu;
	
	@Column(name = "dateTime", nullable = false)
	private LocalDate dateTime;
	
	@Column(name = "status", length = 30, nullable = false)
	private String status;
	
    @ManyToOne
    @JoinColumn(name = "idEmmeteur")
    private Utilisateur utilisateur;
    
    @Column(name = "idPredecesseur", length = 30, nullable = true)
	private Integer idPredecesseur;

    @OneToOne(mappedBy = "envoi")
    private Envoi envoies;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Integer getIdPredecesseur() {
		return idPredecesseur;
	}

	public void setIdPredecesseur(Integer idPredecesseur) {
		this.idPredecesseur = idPredecesseur;
	}

	public Envoi getEnvoies() {
		return envoies;
	}

	public void setEnvoies(Envoi envoies) {
		this.envoies = envoies;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", contenu=" + contenu + ", dateTime=" + dateTime + ", status=" + status
				+ ", utilisateur=" + utilisateur + ", idPredecesseur=" + idPredecesseur + ", envoies=" + envoies + "]";
	}
    
    
}

