package fr.laposte.briefPlantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import fr.laposte.briefPlantdex.model.Categorie;

public class InitData implements ApplicationRunner {

	@Autowired
	private List<Categorie> categories;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Categorie categorie1 = new Categorie();
		categorie1.setLibelle("baobab");

		Categorie categorie2 = new Categorie();
		categorie2.setLibelle("plante verte");

		categories.add(categorie1);
		categories.add(categorie2);

		for (Categorie x : categories) {
			System.out.println(x);
		}

	}

}
