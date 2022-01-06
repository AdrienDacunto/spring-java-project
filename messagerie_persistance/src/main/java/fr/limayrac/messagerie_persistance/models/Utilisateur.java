package fr.limayrac.messagerie_persistance.models;


import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class Utilisateur
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Utilisateur(Integer id, String nom, String prenom, LocalDate dateNaissance, String email, String motDePasse,
			String sexe, List<Message> message) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.motDePasse = motDePasse;
		this.sexe = sexe;
		this.message = message;
	}
    
    

	public Utilisateur(String nom, String prenom, LocalDate dateNaissance, String email, String motDePasse,
			String sexe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.motDePasse = motDePasse;
		this.sexe = sexe;
	}

	public Utilisateur(String nom, String prenom, LocalDate dateNaissance, String email, String motDePasse, String sexe,
			List<Message> message) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.motDePasse = motDePasse;
		this.sexe = sexe;
		this.message = message;
	}

	public Utilisateur() {
		super();
	}




	@Column(name = "nom", length = 30, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length = 30, nullable = false)
	private String prenom;
	
	@Column(name = "dateNaissance", nullable = false)
	private LocalDate dateNaissance;
	
	@Column(name = "email", length = 30, nullable = false, unique= true)
	private String email;
	
	@Column(name = "motDePasse", length = 30, nullable = false)
	private String motDePasse;
	
	@Column(name = "sexe", length = 30, nullable = false)
	private String sexe;
	
    @OneToMany(mappedBy = "utilisateur")
    private List<Message> message = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", email=" + email + ", motDePasse=" + motDePasse + ", sexe=" + sexe + ", message=" + message + "]";
	}
    
    
	
	
}