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
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(JUnitPlatform.class)
@SelectClasses( TypeIndividuDao.class )
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
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetListPersonne() {
		fail("Not yet implemented");
	}

}
