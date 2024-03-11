package fr.laposte.briefPlantdex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.laposte.briefPlantdex.model.Categorie;

@SpringBootApplication
public class BriefPlantdexApplication {

	public static void main(String[] args) {
		SpringApplication.run(BriefPlantdexApplication.class, args);
	}

	@Bean // indique toutes les autres classes gerees par spring vont se partager cette	// liste.
	List<Categorie> personnes() {
		return new ArrayList<Categorie>();

	}

}
