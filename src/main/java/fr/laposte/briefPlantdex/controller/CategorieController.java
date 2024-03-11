package fr.laposte.briefPlantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.briefPlantdex.model.Categorie;
import fr.laposte.briefPlantdex.repository.CategorieRepository;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

	@Autowired
	private List<Categorie> categories;

	@Autowired
	private CategorieRepository categorepo;

	@GetMapping
	public List<Categorie> getAll() {
		categories = categorepo.findAll();
		return categories;
	}

}
