package miage.Crous.Data.Dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.LocationId;
import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.PossedeId;

@Repository
public class PersonneDaoImpl implements PersonneDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void ajoutBien(Personne p, Bien b) {
		PossedeId po = new PossedeId(b.getIdBien(),p.getIdPersonne());
		sessionFactory.getCurrentSession().saveOrUpdate(po);
		return ;

	}

	@Override
	public void AjoutLocation(Personne p, Bien b) {
		LocationId po = new LocationId(b.getIdBien(),p.getIdPersonne());
		sessionFactory.getCurrentSession().saveOrUpdate(po);
		return ;
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
	public void SupresionBienEnLocation(Personne p, Bien b) {
		PossedeId po = new PossedeId(b.getIdBien(),p.getIdPersonne());
		sessionFactory.getCurrentSession().delete(po);
		return ;	
	}

	@Override
	public Personne getById(Integer id) {
		return sessionFactory.getCurrentSession().find(Personne.class, id);
	}
	

}
