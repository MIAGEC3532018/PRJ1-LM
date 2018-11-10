package miage.Crous.Data.Dao;

import java.util.List;

import javax.persistence.TypedQuery;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.TypeIndividu;

@Repository
public class TypeIndividuDaoImpl implements TypeIndividuDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void add(TypeIndividu typeI) {
		sessionFactory.getCurrentSession().saveOrUpdate(typeI);
	}

	@Override
	public List<TypeIndividu> getAll() {
		@SuppressWarnings("unchecked")
		TypedQuery<TypeIndividu> query=sessionFactory.getCurrentSession().createQuery("from TypeIndividu");
	      return query.getResultList();
	}

	@Override
	public TypeIndividu getById(Integer id) {
		
		return sessionFactory.getCurrentSession().get(TypeIndividu.class, id);
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Personne> GetListPersonne(TypeIndividu ty) {
		// Construction de la requête
		StringBuilder hqlQuery = new StringBuilder();
		hqlQuery.append("from Personne as p ");
		hqlQuery.append("where p.type = :type");	
		Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery.toString());
		query.setParameter("type", ty);
		return query.list();
	}

}
