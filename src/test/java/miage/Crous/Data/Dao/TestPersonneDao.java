/**
 * 
 */
package miage.Crous.Data.Dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import miage.Crous.Config.AppConfig;
import miage.Crous.Data.Services.CrousService;

/**
 * @author linda
 *
 */
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(JUnitPlatform.class)
@SelectClasses( PersonneDao.class )
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
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#ajoutBien(miage.Crous.Data.Entity.Personne, miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	void testAjoutBien() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#AjoutLocation(miage.Crous.Data.Entity.Personne, miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	void testAjoutLocation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#addOrUpdate(miage.Crous.Data.Entity.Personne)}.
	 */
	@Test
	void testAddOrUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#getAllPersonne()}.
	 */
	@Test
	void testGetAllPersonne() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link miage.Crous.Data.Dao.PersonneDaoImpl#SupresionBienEnLocation(miage.Crous.Data.Entity.Personne, miage.Crous.Data.Entity.Bien)}.
	 */
	@Test
	void testSupresionBienEnLocation() {
		fail("Not yet implemented");
	}

}
