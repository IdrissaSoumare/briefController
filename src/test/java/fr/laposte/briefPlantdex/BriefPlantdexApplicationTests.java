package fr.laposte.briefPlantdex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.briefPlantdex.model.Categorie;
import fr.laposte.briefPlantdex.model.Ensoleillement;
import fr.laposte.briefPlantdex.model.Plante;
import fr.laposte.briefPlantdex.repository.CategorieRepository;
import fr.laposte.briefPlantdex.repository.PlanteRepository;

@SpringBootTest
class BriefPlantdexApplicationTests {

	@Autowired
	private CategorieRepository categories;

	@Autowired
	private PlanteRepository plantes;

	@BeforeEach
	void clean() {
		plantes.deleteAll();
		categories.deleteAll();
	}

	@Test
	void contextLoads() {

		Categorie planteVerte = new Categorie();
		planteVerte.setLibelle("plante verte");
		categories.save(planteVerte);

		Categorie bonsai = new Categorie();
		bonsai.setLibelle("bonsai");
		categories.save(bonsai);

		Categorie baobab = new Categorie();
		baobab.setLibelle("baobab");
		categories.save(baobab);
		
		Categorie planteBulbe = new Categorie();
		planteBulbe.setLibelle("plante bulbe");
		categories.save(planteBulbe);
		
		Categorie herbaces = new Categorie();
		herbaces.setLibelle("herbace");
		categories.save(herbaces);
	

		Plante marguerite = new Plante();
		marguerite.setArrosage(2);
		marguerite.setEnsoleillement(Ensoleillement.BEAUCOUP);
		marguerite.setNom("marguerite");
		marguerite.setCategorie(baobab);
		plantes.save(marguerite);

		Plante iris = new Plante();
		iris.setArrosage(1);
		iris.setEnsoleillement(Ensoleillement.MOYEN);
		iris.setNom("iris");
		iris.setCategorie(bonsai);
		plantes.save(iris);
		
		

	}

}
