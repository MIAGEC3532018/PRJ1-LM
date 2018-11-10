package miage.Crous.Data.Dao;

import java.util.List;

import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.Personne;

/**
 * Interface de gestion des biens.
 * @author linda
 *
 */
public interface BienDao {
	/**
	 * Ajout ou mise à jour d'un bien.
	 * @param b
	 */
	void ajouter(Bien b);

	/**
	 * Suppression d'un Bien.
	 * @param b
	 */
	void supprimer(Bien b);
	
	/**
	 * Obtient le bien à partir de son identiant.
	 * @param id identifiant du bien
	 * @return retourne le bien.
	 */
	Bien getById(Integer id);

	/**
	 * Permet d'obtenir tous les biens.
	 * @return la liste des biens.
	 */
	List<Bien> getAllBien();

	/**
	 * Obtient la liste des biens d'un locatiare.
	 * @param p
	 * @return
	 */
	List<Bien> getAllBienByLocataire(Personne p);

	/**
	 * Obtient la liste des biens d'un proprietaire
	 * @param p Propriétaire.
	 * @return liste des biens du propriétaire.
	 */
	List<Bien> getAllBienByProprietaire(Personne p);
	
	
	/**
	 * Obtient la liste des biens vides.
	 * @return liste des biens disponible.
	 */
	List<Bien> getAllBienVide();
	
	/**
	 * Obtient la liste des biens sans propriétaire.
	 * @return liste des biens sans propritaire.
	 */
	List<Bien> getAllBienSansProprietaire();
}
