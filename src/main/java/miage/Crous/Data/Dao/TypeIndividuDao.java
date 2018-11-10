package miage.Crous.Data.Dao;

import java.util.List;

import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.TypeIndividu;
/**
 * Interface des gestions des types d'individus.
 * @author linda
 *
 */
public interface TypeIndividuDao {
	/**
	 * Ajouter ou mise à jour d'une type.
	 * @param typeI Type D'individu.
	 */
	void add(TypeIndividu typeI);
	
	/**
	 * Obtient un individu à partir son identifiant.
	 * @param id identifant du type.
	 * @return L'identifiant rechercher.
	 */
	TypeIndividu getById(Integer id);
	
	/**
	 * Recherche tous les types disponibles.
	 * @return liste des types.
	 */
	List<TypeIndividu> getAll();
	
	/**
	 * Obtient la liste des personnes d'un type d'individu.
	 * @param type Type d'individus. 
	 * @return liste des personnes d'un type.
	 */
	List<Personne> GetListPersonne(TypeIndividu type);
	

}
