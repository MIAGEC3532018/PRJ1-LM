package miage.Crous.Data.Entity;
// Generated 4 nov. 2018 à 15:41:25 by Hibernate Tools 5.0.6.Final

import static javax.persistence.GenerationType.IDENTITY;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONNE")
public class Personne implements java.io.Serializable {

	/**
	 * Identifiant de la sérialisation.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identifiant de la personne.
	 */
	private Integer idPersonne;
	/**
	 * Type d'individu.
	 */
	private TypeIndividu type;

	/**
	 *  Nom de la personne.
	 */
	private String nom;

	/**
	 * Prenom de la personne.
	 */
	private String prenom;

	/**
	 * Adresse de la personne.
	 */
	private String adresse;
	
	private Set<Possede> possedes = new HashSet<Possede>(0);
	private Set<Location> locations = new HashSet<Location>(0);

	/**
	 * Constructeur de la classe personne.
	 */
	public Personne() {
	}

	/**
	 * Contructeur de la classe personne.
	 * @param type Type de personne.
	 * @param nom nom de la personne.
	 * @param prenom prénom de la personne.
	 * @param adresse Adresse de la personne.
	 */
	public Personne(TypeIndividu type, String nom, String prenom, String adresse) {
		this.type = type;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	public Personne(int idPersonne, TypeIndividu type, String nom, String prenom, String adresse, Set<Possede> possedes,
			Set<Location> locations) {
		this.idPersonne = idPersonne;
		this.type = type;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.possedes = possedes;
		this.locations = locations;
	}

	/**
	 * Obtient l'id de la personne. 
	 * @return Identifiant de la personne.
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_personne", unique = true, nullable = false)
	public Integer getIdPersonne() {
		return this.idPersonne;
	}

	/**
	 * défini le valeur de l'identifiant.  
	 * @param idPersonne identifiant de la personne.
	 */
	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	/**
	 * Obtient le type de personne.
	 * @return le type de personne.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type", nullable = false)
	public TypeIndividu getType() {
		return this.type;
	}

	public void setType(TypeIndividu type) {
		this.type = type;
	}

	@Column(name = "nom", nullable = false, length = 30)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 30)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "adresse", nullable = false, length = 30)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Possede> getPossedes() {
		return this.possedes;
	}

	public void setPossedes(Set<Possede> possedes) {
		this.possedes = possedes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}
}