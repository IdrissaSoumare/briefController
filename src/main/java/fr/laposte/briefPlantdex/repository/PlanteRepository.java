package fr.laposte.briefPlantdex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.briefPlantdex.model.Categorie;
import fr.laposte.briefPlantdex.model.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long> {
	List<Plante> findByCategorie (Categorie categorie);

}
