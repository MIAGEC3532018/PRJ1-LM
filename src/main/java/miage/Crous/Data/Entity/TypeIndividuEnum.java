package miage.Crous.Data.Entity;

/**
 * Type des individus possibles.
 * @author linda
 *
 */
public enum TypeIndividuEnum {

	Proprietaire("Propriétaire",1),
	Locataire("Locataire",2);

	/**
	 * Nom de l'énumération.
	 */
	private String name = "";

	/**
	 * Identifiant du type d'individu. 
	 */
	private Integer id = 0;

	/**
	 * Constructeur de l'énumération.
	 * @param name nom de l'énumération.
	 * @param id identifiant.
	 */
	TypeIndividuEnum(String name, Integer id){

		this.name = name;

		this.id = id;

	}
	/**
	 *  Obtient l'identifiant du Type. 
	 * @return identifant.
	 */
	public Integer getId(){
		return this.id;
	}

	/**
	 * Obtient le nom du type pour les affichages. 
	 */
	public String toString(){

		return name;
	}
}
