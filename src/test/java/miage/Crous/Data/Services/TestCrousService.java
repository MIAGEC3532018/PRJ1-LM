package miage.Crous.Data.Services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
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

@Transactional
@Rollback(false)
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(JUnitPlatform.class)
class TestCrousService {

	private static AnnotationConfigApplicationContext context;
	private static CrousService crousService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		crousService = context.getBean(CrousService.class);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@DisplayName("Mise à jour ou Ajout d'une personne.")
	void testAddOrUpdatePersonne() {
		TypeIndividu ty = crousService.getTypeById(TypeIndividuEnum.Locataire.getId());
		
		Personne p = new Personne();
		p.setNom("Nom1");
		p.setPrenom("Prenom");
		p.setAdresse("ADDD");
		p.setType(ty);
		assertDoesNotThrow(()-> {crousService.addOrUpdatePersonne(p);});
		p.setPrenom("To");
		assertDoesNotThrow(()-> {crousService.addOrUpdatePersonne(p);});
		assertTrue(p.getPrenom().equals("To"));
	}

	@Test
	@DisplayName("Mise à jour ou Ajout d'un type.")
	void testAddorUpdateTypeTypeIndividu() {
		TypeIndividu ty = crousService.getTypeById(TypeIndividuEnum.Locataire.getId());
		ty.setNameType("LOCA");
		assertDoesNotThrow(()-> {crousService.addorUpdateType(ty);});
		assertTrue(ty.getNameType().equals("LOCA"));
		ty.setNameType("Locataire");
		assertDoesNotThrow(()-> {crousService.addorUpdateType(ty);});
	}

	@Test
	@DisplayName("Mise à jour ou Ajout d'un bien.")
	void testAddorUpdateTypeBien() {
		Bien bien = crousService.getBienById(1);
		bien.setAddressB("New");
		assertDoesNotThrow(()-> {crousService.addorUpdateBien(bien);});
		assertTrue(bien.getAddressB().equals("New"));
		bien.setAddressB("Ancien");
		assertDoesNotThrow(()-> {crousService.addorUpdateBien(bien);});
		assertTrue(bien.getIdBien().equals(1L));
	}

	@Test
	@DisplayName("Supression d'un bien avec une location.")
	void testSupprimerUneBien() {
		Bien b = crousService.getBienById(1);
		assertThrows(IllegalArgumentException.class,()->{
			crousService.SupprimerUneBien(b);
			});
	}

}
