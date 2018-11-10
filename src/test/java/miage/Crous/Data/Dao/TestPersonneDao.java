/**
 * 
 */
package miage.Crous.Data.Dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import miage.Crous.Config.AppConfig;
import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.TypeIndividu;
import miage.Crous.Data.Entity.TypeIndividuEnum;
import miage.Crous.Data.Services.CrousService;

/**
 * @author linda
 *
 */
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(JUnitPlatform.class)
@SelectClasses(PersonneDao.class )
@Transactional
@Rollback(true)
class TestPersonneDao {

private static AnnotationConfigApplicationContext context;
	
	private static CrousService serviceCrous;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		serviceCrous = context.getBean(CrousService.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		context.close();
	}
	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#getAllPersonne()}.
	 */
	@Test
	@DisplayName("Obtenir toutes les personnes du system")
	void testGetAllPersonne() {
		List<Personne> lst = serviceCrous.getAllPersonne();
		assertNotNull(lst);
		assertEquals(true,lst.size()>0);
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#ajoutBien(miage.Crous.Data.Entity.Personne, miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	@DisplayName("Ajout d'une propriete mode classique")
	void testAjoutPropriete() {
		TypeIndividu typeProprietaire = serviceCrous.getTypeById(TypeIndividuEnum.Proprietaire.getId());
		Personne p = new Personne(typeProprietaire,"Nom_p","Prenom_p","adre_p");
		Bien b = new Bien("Adrdess_test_CLA",1);
		assertDoesNotThrow(()->{
			serviceCrous.AjouterUnbienEnPropriete(p, b);	
		});
	}
	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#ajoutBien(miage.Crous.Data.Entity.Personne, miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	@DisplayName("Ajout d'un propriete non authorisé")
	void testAjoutProprieteException() {
		TypeIndividu typeLocataire = serviceCrous.getTypeById(TypeIndividuEnum.Locataire.getId());
		Personne p = new Personne(typeLocataire,"Nom_LocatKO","Prenom_LocaKO","adre_Locataire");
		Bien b = new Bien("Adrdess_test_KO",1);
		assertThrows(IllegalArgumentException.class, ()->{
			serviceCrous.AjouterUnbienEnPropriete(p, b);	
		});
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#AjoutLocation(miage.Crous.Data.Entity.Personne, miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	@DisplayName("Ajout d'une Location classique")
	void testAjoutLocation() {
		TypeIndividu typeLocataire = serviceCrous.getTypeById(TypeIndividuEnum.Locataire.getId());
		Personne p = new Personne(typeLocataire,"Nom_p","Prenom_p","adre_p");
		Bien b = new Bien("Adrdess_test",1);
		assertDoesNotThrow(()->{
			serviceCrous.AjouterUnbienEnLocation(p, b);	
		});
	}
	
	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#AjoutLocation(miage.Crous.Data.Entity.Personne, miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	@DisplayName("Ajout d'une Location avec exception")
	void testAjoutLocationException() {
		TypeIndividu typeProprietaire = serviceCrous.getTypeById(TypeIndividuEnum.Proprietaire.getId());
		Personne p = new Personne(typeProprietaire,"Nom_Loca","Prenom_Loca","adre_p");
		Bien b = new Bien("Adrdess_test Not loca",1);
		assertThrows(IllegalArgumentException.class,()->{
			serviceCrous.AjouterUnbienEnLocation(p, b);	
		});
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#addOrUpdate(miage.Crous.Data.Entity.Personne)}.
	 */
	@Test
	@DisplayName("Ajoute et mise à jour d'une personne")
	void testAddOrUpdate() {
		TypeIndividu typeProprietaire = serviceCrous.getTypeById(TypeIndividuEnum.Proprietaire.getId());
		Personne p = new Personne(typeProprietaire,"Nom_p","Prenom_p","adre_p");
		serviceCrous.addOrUpdatePersonne(p);
		assertNotNull(p.getIdPersonne());
		Integer idsave= p.getIdPersonne();
		p.setAdresse("NewAdress");
		serviceCrous.addOrUpdatePersonne(p);
		assertEquals(idsave,p.getIdPersonne());
		assertEquals("NewAdress",p.getAdresse());
	}

	
	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#SupresionBienEnLocation(miage.Crous.Data.Entity.Personne, miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	@DisplayName("Supression d'une location d'une personne")
	void testSupresionBienEnLocation() {
		Personne p = serviceCrous.getPersonneById(4); 
		assertDoesNotThrow(()->{
			serviceCrous.SupprimerUneLocationByPersonne(p);
			});
	}

}
