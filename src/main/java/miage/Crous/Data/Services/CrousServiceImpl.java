package miage.Crous.Data.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miage.Crous.Data.Dao.BienDao;
import miage.Crous.Data.Dao.PersonneDao;
import miage.Crous.Data.Dao.TypeIndividuDao;
import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.TypeIndividu;

@Service("crousService")
@Transactional
public class CrousServiceImpl implements CrousService {

	@Autowired
	private PersonneDao personneDao;
	@Autowired
	private TypeIndividuDao typeIndividuDao;
	@Autowired
	private BienDao bienDao;
	
	@Override
	public void addOrUpdatePersonne(Personne user) {
		personneDao.addOrUpdate(user);
		
	}
	@Override
	public List<Personne> getAllPersonne() {
		return personneDao.getAllPersonne();
	}
	@Override
	public List<TypeIndividu> GetAllType() {
		return typeIndividuDao.getAll();
	}
	@Override
	public void addorUpdateType(TypeIndividu type) {
		typeIndividuDao.add(type);		
	}
	@Override
	public TypeIndividu getTypeById(Integer id) {
		return typeIndividuDao.getById(id);
	}
	@Override
	public List<Personne> getAllPersonneByType(TypeIndividu type) {
		return typeIndividuDao.GetListPersonne(type);
	}
	@Override
	public void addorUpdateBien(Bien bien) {
		bienDao.ajouter(bien);
		
	}
	@Override
	public Bien getBienById(Integer id) {
		return bienDao.getById(id);
	}
	@Override
	public void AjouterUnbienEnPropriete(Personne p, Bien b) {
		personneDao.addOrUpdate(p);
		bienDao.ajouter(b);
		personneDao.ajoutPropriete(p, b);
	}
	@Override
	public void AjouterUnbienEnLocation(Personne p, Bien b) {
		personneDao.addOrUpdate(p);
		bienDao.ajouter(b);
		personneDao.AjoutLocation(p, b);
	}
	@Override
	public void SupprimerUneLocationByPersonne(Personne p) {
		personneDao.SupresionBienEnLocation(p);
		
	}
	@Override
	public void SupprimerUneBien(Bien b) {
		bienDao.supprimer(b);
	}
	@Override
	public List<Bien> getAllBien() {
		return bienDao.getAllBien();
	}
	@Override
	public Personne getPersonneById(Integer id) {
		return personneDao.getById(id);
	}
	@Override
	public List<Bien> getAllBienByLocataire(Personne p) {
		return bienDao.getAllBienByLocataire(p);
	}
	@Override
	public List<Bien> getAllBienByProprietaire(Personne p) {
		return bienDao.getAllBienByProprietaire(p);
	}
	@Override
	public List<Bien> getAllBienSansProprietaire() {
		return bienDao.getAllBienSansProprietaire();
	}
	@Override
	public List<Bien> getAllBienSansLocataire() {
		return bienDao.getAllBienVide();
	}
}
