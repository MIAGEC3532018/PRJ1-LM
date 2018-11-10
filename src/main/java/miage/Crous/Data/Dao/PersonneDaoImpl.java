package miage.Crous.Data.Dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.Location;
import miage.Crous.Data.Entity.LocationId;
import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.Possede;
import miage.Crous.Data.Entity.PossedeId;
import miage.Crous.Data.Entity.TypeIndividuEnum;

@Repository
public class PersonneDaoImpl implements PersonneDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void ajoutPropriete(Personne p, Bien b) {
		if (this.isProprietaire(p))
		{
			PossedeId poi = new PossedeId(b.getIdBien(),p.getIdPersonne());
			Possede po = new Possede(poi,b,p);
			sessionFactory.getCurrentSession().saveOrUpdate(po);
			return ;
		}
		throw new IllegalArgumentException("Un locataire ne peut pas être propriétaire");
	}

	@Override
	public void AjoutLocation(Personne p, Bien b) {
		if (isLocataire(p))
		{
			if(p.getLocations().size()>0)
			{
				throw new IllegalArgumentException("Un locataire ne peut pas avoir 2 locations");
			}
			LocationId loi = new LocationId(b.getIdBien(),p.getIdPersonne());
			Location lo = new Location(loi,b,p);
			sessionFactory.getCurrentSession().saveOrUpdate(lo);
			return ;
		}
		throw new IllegalArgumentException("Un proprietaire ne peut pas être locataire");
	}

	@Override
	public void addOrUpdate(Personne user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	public List<Personne> getAllPersonne() {
		@SuppressWarnings("unchecked")
		TypedQuery<Personne> query=sessionFactory.getCurrentSession().createQuery("from Personne");
		return query.getResultList();
	}

	@Override
	public void SupresionBienEnLocation(Personne p) {
		p = sessionFactory.getCurrentSession().find(Personne.class,p.getIdPersonne());
		if (p.getLocations().size()>0)
		{
			p.getLocations().forEach((lo)->{
				int result = sessionFactory.getCurrentSession().createQuery("delete from Location where id = :id").setParameter("id",lo.getId()).executeUpdate();
				if (result > 0) {
				    System.out.println("location supprimée");
				}
			});
			return;
		}
		throw new IllegalArgumentException("Pas de location à supprimer");
	}

	@Override
	public Personne getById(Integer id) {
		return sessionFactory.getCurrentSession().find(Personne.class, id);
	}

	/**
	 * Test du type proprietaire.
	 * @return true si le type est un proprietaire.
	 */
	private boolean isProprietaire(Personne p) {
		if(p.getType()!= null && p.getType().getIdType()!= null)
		{
			return p.getType().getIdType().equals(TypeIndividuEnum.Proprietaire.getId());
		}
		return false;
	}
	
	/**
	 * Test du type Locataire.
	 * @return true si le type est un locataire.
	 */
	private boolean isLocataire(Personne p) {
		if(p.getType()!= null && p.getType().getIdType()!= null)
		{
			return p.getType().getIdType().equals(TypeIndividuEnum.Locataire.getId());
		}
		return false;
	}
}
