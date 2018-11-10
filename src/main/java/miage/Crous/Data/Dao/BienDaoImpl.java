package miage.Crous.Data.Dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.Personne;

/**
 * Classe de gestion des biens. 
 * @author linda
 *
 */
@Repository("bienRepository")
public class BienDaoImpl implements BienDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void ajouter(Bien b) {
		sessionFactory.getCurrentSession().saveOrUpdate(b);
	}

	@Override
	public void supprimer(Bien b)  {

		if (!bienEnlocation(b))
		{
			this.deletePossesses(b);
			
			/** Supression du bien*/
			String hqlDelete = "delete Bien b where b.id = :id";

			sessionFactory.getCurrentSession().createQuery( hqlDelete )
			.setParameter( "id", b.getIdBien() )
			.executeUpdate();

			return;
		}
		throw new IllegalArgumentException("le bien peut pas être location");

	}

	@Override
	public Bien getById(Integer id) {
		return sessionFactory.getCurrentSession().get(Bien.class, id);
	}

	@Override
	public List<Bien> getAllBien() {
		@SuppressWarnings("unchecked")
		TypedQuery<Bien> query=sessionFactory.getCurrentSession().createQuery("from Bien");
		return query.getResultList();
	}

	@Override
	public List<Bien> getAllBienByLocataire(Personne p) {
		Query<Bien> query = sessionFactory.getCurrentSession().createNativeQuery("Select b.* from BIEN b "
				+ "inner join LOCATION l on l.id_bien=b.id_bien where l.id_personne=:idp",Bien.class );
		query.setParameter("idp", p.getIdPersonne());
		return query.getResultList();
	}

	@Override
	public List<Bien> getAllBienByProprietaire(Personne p) {	
		Query<Bien> query = sessionFactory.getCurrentSession().createNativeQuery("Select b.* from BIEN b "
				+ "inner join POSSEDE p on p.id_bien = b.id_bien where p.id_personne=:idp",Bien.class );
		query.setParameter("idp", p.getIdPersonne());
		return query.getResultList();
	}

	@Override
	public List<Bien> getAllBienVide() {

		Query<Bien> query = sessionFactory.getCurrentSession().createNativeQuery("Select b.* from BIEN b "
				+ "left join LOCATION l on l.id_bien = b.id_bien where l.id_personne is null",Bien.class );

		return query.getResultList();
	}

	@Override
	public List<Bien> getAllBienSansProprietaire() {
		Query<Bien> query = sessionFactory.getCurrentSession().createNativeQuery("Select b.* from BIEN b "
				+ "left join POSSEDE p on p.id_bien = b.id_bien where p.id_personne is null",Bien.class );

		return query.getResultList();
	}

	/**
	 * Recherhe si le bien a une location.
	 * @param b Bien à tester.
	 * @return true si bien possede une location
	 */
	private boolean bienEnlocation(Bien b) {
		Integer idb = b.getIdBien();
		b = sessionFactory.getCurrentSession().find(Bien.class, idb);
		return (b.getLocations().size() > 0);
	}
	private void deletePossesses(Bien b)
	{
		if(b.getPossedes().size() > 0) {
			/*** Supression du lien de propriéte**/
			b.getPossedes().forEach((po)->{
				sessionFactory.getCurrentSession().createQuery("delete from Possede where id = :id").setParameter("id",po.getId()).executeUpdate();
			});
		}
	}
}
