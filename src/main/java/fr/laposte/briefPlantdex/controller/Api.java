package fr.laposte.briefPlantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.briefPlantdex.model.Categorie;

@RestController
@RequestMapping("/categorie")
public class Api {

	@Autowired
	private List<Categorie> categories;

	@GetMapping
	public List<Categorie> getAll(){
		System.out.println("toto");
		return categories;
	}

	

}
