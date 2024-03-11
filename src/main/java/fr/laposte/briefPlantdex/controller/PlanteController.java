package fr.laposte.briefPlantdex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.laposte.briefPlantdex.model.Plante;
import fr.laposte.briefPlantdex.repository.PlanteRepository;

@RestController
@RequestMapping("/plante")
public class PlanteController {

	@Autowired
	private List<Plante> plantes;

	@Autowired
	private PlanteRepository planteRepo;

	@GetMapping
	public List<Plante> getAll() {
		System.out.println("toto");
		plantes = planteRepo.findAll();
		return plantes;
	}

}
