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
import miage.Crous.Data.Entity.Personne;
import miage.Crous.Data.Entity.TypeIndividu;
import miage.Crous.Data.Entity.TypeIndividuEnum;
import miage.Crous.Data.Services.CrousService;
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(JUnitPlatform.class)
@SelectClasses( TypeIndividuDao.class )
@Transactional
@Rollback(true)
class TestTypeIndividuDao {
private static AnnotationConfigApplicationContext context;
	
	private static CrousService serviceCrous;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		serviceCrous = context.getBean(CrousService.class);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@DisplayName("Obtenir tous les types")
	void testGetAll() {
		List<TypeIndividu> lst = serviceCrous.GetAllType();
		assertNotNull(lst);
		assertEquals(true,lst.size()>0);
	}

	@Test
	@DisplayName("Obtenir toutes les personnes suivant le type")
	void testGetListPersonne() {
		TypeIndividu ty = serviceCrous.getTypeById(TypeIndividuEnum.Locataire.getId());
		List<Personne> lst = serviceCrous.getAllPersonneByType(ty);
		assertNotNull(lst);
		assertEquals(true,lst.size()>0);
	}
}
