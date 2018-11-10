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
	Personne getPersonneById(Integer id);
	
	void addorUpdateBien(Bien bien);
	
	Bien getBienById(Integer id);
	
	void AjouterUnbienEnPropriete(Personne p, Bien b);
	
	void AjouterUnbienEnLocation(Personne p, Bien b);
	void SupprimerUneLocation(Personne p, Bien b);
	void SupprimerUneBien(Bien b);
	
	/**
     * Obtenir la liste de toutes les biens.
     * @return la liste des biens.
     */
	List<Bien> getAllBien();
	List<Bien> getAllBienByLocataire(Personne p);
	List<Bien> getAllBienByProprietaire(Personne p);
	List<Bien> getAllBienSansProprietaire();
	List<Bien> getAllBienSansLocataire();
}
