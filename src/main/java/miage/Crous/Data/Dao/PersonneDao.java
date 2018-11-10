package miage.Crous.Data.Dao;

import java.util.List;

import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.Personne;

/***
 * Interface de la gestion des personnes.
 * @author linda
 *
 */
public interface PersonneDao {
	/**
	 * Permet la mise à jour ou la création d'une personne.
	 * @param user personne à ajouter ou mettre à jour.
	 */
	void addOrUpdate(Personne user);
	
	/**
	 *  Liste des personnes.
	 * @return la liste des personnes.
	*/
	List<Personne> getAllPersonne();

	/**
	 * Ajout d'un bien à une propriétaire.
	 * @param p Personne.
	 * @param b bien.
	 */
	void ajoutPropriete(Personne p,Bien b);

	/**
	 * Suppression d'un bien en location.
	 * @param p
	 * @param b
	 */
	void SupresionBienEnLocation(Personne p);

	/**
	 * Ajout d'un bien en location.
	 * @param p locataire.
	 * @param b Bien à louer.
	 */
	void AjoutLocation(Personne p,Bien b);	
	
	/**
	 * Obtient une personne.
	 * @param id identifiant de la personne.
	 * @return la Personne trouvée.
	 */
	Personne getById(Integer id);
}
