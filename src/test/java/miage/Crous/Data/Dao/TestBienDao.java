/**
 * 
 */
package miage.Crous.Data.Dao;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.lang.RuntimeException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import miage.Crous.Config.AppConfig;
import miage.Crous.Data.Entity.Bien;
import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Services.CrousService;

/**
 * @author linda
 *
 */
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(JUnitPlatform.class)
@SelectClasses( BienDao.class )
class TestBienDao {

	private static AnnotationConfigApplicationContext context;
	
	private static CrousService serviceCrous;
	
	private static Integer lastidInsert = -1;
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
	 * Test method for {@link miage.Crous.Data.Dao.BienDaoImpl#ajouter(miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	@DisplayName("Ajout d'un bien")
	void testAjouter() {  
        Bien b = new Bien("Addres1",1);
        assertDoesNotThrow(()->{serviceCrous.addorUpdateBien(b);});
    
        b.setAddressB("lolo");
        assertDoesNotThrow(()->{serviceCrous.addorUpdateBien(b);});
        assertTrue(b.getAddressB().equals("lolo"));
		assertNotNull(b.getIdBien());        
		
		lastidInsert = b.getIdBien();
		System.out.println("EndtestAjouter");
	}
	
	/**
	 * Test method for {@link miage.Crous.Data.Dao.BienDaoImpl#getById(java.lang.Integer)}.
	 */
	@Test
	@DisplayName("Obtenir un bien à partir de son identifiant")
	void testGetById() {
		assertNotNull(serviceCrous.getBienById(1));
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.BienDaoImpl#getAllBien()}.
	 */
	@Test
	@DisplayName("Obtenir Tous les biens du crous")
	void testGetAllBien() {
		List<Bien> lst = serviceCrous.getAllBien();
		assertNotNull(lst);
		assertEquals(true,lst.size()>0);
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.BienDaoImpl#getAllBienByLocataire(miage.Crous.Data.Entity.Personne)}.
	 */
	@Test
	@DisplayName("Liste des biens en  location par une personne")
	void testGetAllBienByLocataire() {
		Personne p = serviceCrous.getPersonneById(4);
		List<Bien> lstBien = serviceCrous.getAllBienByLocataire(p);
		assertNotNull(lstBien);
		assertEquals(true,lstBien.size()>0);
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.BienDaoImpl#getAllBienByProprietaire(miage.Crous.Data.Entity.Personne)}.
	 */
	@Test
	@DisplayName("Liste des biens appatenant à un propriétaire")
	void testGetAllBienByProprietaire() {
		Personne p = serviceCrous.getPersonneById(1);
		List<Bien> lstBien = serviceCrous.getAllBienByProprietaire(p);
		assertNotNull(lstBien);
		assertEquals(true,lstBien.size()>0);
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.BienDaoImpl#getAllBienVide()}.
	 */
	@Test
	@DisplayName("Liste des biens sans locataire")
	void testGetAllBienVide() {
		List<Bien> lstBien = serviceCrous.getAllBienSansLocataire();
		assertNotNull(lstBien);
		assertEquals(true,lstBien.size()>0);
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.BienDaoImpl#getAllBienSansProprietaire()}.
	 */
	@Test
	@DisplayName("Liste des biens sans proprietaire")
	void testGetAllBienSansProprietaire() {
		List<Bien> lstBien = serviceCrous.getAllBienSansProprietaire();
		assertNotNull(lstBien);
		assertEquals(true,lstBien.size()>0);
	}
	
	/**
	 * Test method for {@link miage.Crous.Data.Dao.BienDaoImpl#supprimer(miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	@DisplayName("Suppression d'un bien")
	void testSupprimer() {
		
		Bien b= serviceCrous.getBienById(lastidInsert);
		assertNotNull(b);
		assertDoesNotThrow(()->serviceCrous.SupprimerUneBien(b));
		assertThrows(RuntimeException.class, ()->{
			serviceCrous.SupprimerUneBien(b);
			}); 
	}

}
