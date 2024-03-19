package fr.laposte.briefPlantdex;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.laposte.briefPlantdex.model.Categorie;
import fr.laposte.briefPlantdex.model.Plante;

@SpringBootApplication
public class BriefPlantdexApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriefPlantdexApplication.class, args);
	}

	@Bean // indique toutes les autres classes gerees par spring vont se partager cette //
			// liste.
	List<Categorie> categories() {
		return new ArrayList<Categorie>();
	}

	@Bean // indique toutes les autres classes gerees par spring vont se partager cette //
			// liste.
	List<Plante> plantes() {
		return new ArrayList<Plante>();
	}

	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
