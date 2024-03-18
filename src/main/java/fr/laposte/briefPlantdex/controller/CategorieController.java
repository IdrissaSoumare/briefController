package fr.laposte.briefPlantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.briefPlantdex.model.Categorie;
import fr.laposte.briefPlantdex.repository.CategorieRepository;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/categorie")
@Log4j2
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

	@GetMapping("/{id}")
	public Categorie get(@PathVariable int id) throws Exception {
		return categorepo.findById((long) id).orElseThrow(() -> new Exception("pas de categorie avec id" + id));
	}

	@PostMapping
	public Categorie ajoutCategorie(@RequestBody Categorie categorie) {
		return categorepo.save(categorie);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		categorepo.deleteById((long) id);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody Categorie categorieUpdate) throws Exception {
		Categorie categorie = categorepo.findById((long) id)
				.orElseThrow(() -> new Exception("categorie mise à jour : " + categorieUpdate));
		categorepo.delete(categorie);
		categorie.setLibelle("long tronc");
		categorepo.save(categorie);
	}

}
