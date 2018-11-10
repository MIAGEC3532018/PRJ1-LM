package miage.Crous.Data.Entity;
// Generated 4 nov. 2018 à 15:41:25 by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LocationId generated by hbm2java
 */
@Embeddable
public class LocationId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idBien;
	private int idPersonne;

	public LocationId() {
	}

	public LocationId(int idBien, int idPersonne) {
		this.idBien = idBien;
		this.idPersonne = idPersonne;
	}

	@Column(name = "id_bien", nullable = false)
	public int getIdBien() {
		return this.idBien;
	}

	public void setIdBien(int idBien) {
		this.idBien = idBien;
	}

	@Column(name = "id_personne", nullable = false)
	public int getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LocationId))
			return false;
		LocationId castOther = (LocationId) other;

		return (this.getIdBien() == castOther.getIdBien()) && (this.getIdPersonne() == castOther.getIdPersonne());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdBien();
		result = 37 * result + this.getIdPersonne();
		return result;
	}

}
