package miage.Crous.Data.Services;

import java.util.List;


import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.TypeIndividu;
import miage.Crous.Data.Entity.Bien;
/**
 * Interface de service du Crous.
 * @author linda
 *
 */
public interface CrousService {
	/**
	 * Ajouter ou mise à jour d'une personne.
	 * @param user Personne à mettre à jour.
	 */
	void addOrUpdatePersonne(Personne user);
    
	/**
     * Obtenir la liste de toutes personnes.
     * @return la liste de personnes.
     */
	List<Personne> getAllPersonne();
	
	/**
	 * Obtient la liste des types.
	 * @return tous les types.
	 */
	List<TypeIndividu> GetAllType();
	
	/**
	 *  Permet l'ajout d'un type d'individu.
	 * @param type Type d'individu.
	 */
	void addorUpdateType(TypeIndividu type);
	
	/**
	 * Obtient un type à partir de son identfiant. 
	 * @param id identifiant.
	 * @return Type trouvé.
	 */
	TypeIndividu getTypeById(Integer id);
	
	/**
	 * Permet d'obtenir la liste de type à partir du type
	 * @param type Type d'individu.
	 * @return liste des personnes.
	 */
	List<Personne> getAllPersonneByType(TypeIndividu type);
	
	/**
	 * Permet d'obtenir une personne à partir de son identifient. 
	 * @param id Identifiant de la persone.
	 * @return la personne trouvée.
	 */
	Personne getPersonneById(Integer id);
	
	/**
	 * Ajout ou mise à jour d'un bien.
	 * @param bien Le bien à mettre à jour
	 */
	void addorUpdateBien(Bien bien);
	
	/**
	 * Obtient un bien à partir de son Identifant. 
	 * @param id identifiant du bien.
	 * @return le bien.
	 */
	Bien getBienById(Integer id);
	
	/**
	 * Ajout un bien a un propriétaire. 
	 * @param p Personne propriétaire
	 * @param b bien du propriétaire.
	 */
	void AjouterUnbienEnPropriete(Personne p, Bien b);

	/**
	 * Ajout une bien en location.
	 * @param p Personne locataire.
	 * @param b Bien qui loue.
	 */
	void AjouterUnbienEnLocation(Personne p, Bien b);
	
	/**
	 * Supprime une location d'une personne.
	 * @param p personne en location.
	 */
	void SupprimerUneLocationByPersonne(Personne p);
	
	/**
	 * Supprime une bien non en location. 
	 * @param b bien à supprimer.
	 */
	void SupprimerUneBien(Bien b);
	
	/**
     * Obtenir la liste de toutes les biens.
     * @return la liste des biens.
     */
	List<Bien> getAllBien();

	/**
	 * Obtient tous les biens en location d'une personne.
	 * @param p personne.
	 * @return liste des biens.
	 */
	List<Bien> getAllBienByLocataire(Personne p);
	
	/**
	 * Obtient la liste des biens d'un propriétaire.
	 * @param p personne propriétaire.
	 * @return la liste des biens.
	 */
	List<Bien> getAllBienByProprietaire(Personne p);
	
	/**
	 * Obtient la liste des biens sans propriétaire.
	 * @return la liste des biens.
	 */
	List<Bien> getAllBienSansProprietaire();

	/**
	 * Obtient la liste des biens sans locataire.
	 * @return liste des biens.
	 */
	List<Bien> getAllBienSansLocataire();
}
