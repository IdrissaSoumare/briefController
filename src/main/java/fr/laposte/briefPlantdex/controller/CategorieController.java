package fr.laposte.briefPlantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.laposte.briefPlantdex.service.ServiceCategorie;
import fr.laposte.briefPlantdex.service.dto.CategorieDTO;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/categorie")
@Log4j2
public class CategorieController {

	@Autowired
	private ServiceCategorie serviceCategories;

	@GetMapping
	public List<CategorieDTO> getAll() {
		return serviceCategories.listerCategorie();
	}

	@GetMapping("/{id}")
	public CategorieDTO get(@PathVariable Long id) {
		CategorieDTO result = serviceCategories.rechercherCategorieById(id);
		if (result == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return result;
	}

	@PostMapping
	public void add(@RequestBody @Valid CategorieDTO categorie) {
		serviceCategories.ajouterCategorie(categorie);

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (serviceCategories.rechercherCategorieById(id) == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		serviceCategories.supprimerCategorie(id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody @Valid CategorieDTO categorieUpdate) {
		if (serviceCategories.rechercherCategorieById(id) == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		serviceCategories.modifierCategorie(categorieUpdate, id);

	}

}
