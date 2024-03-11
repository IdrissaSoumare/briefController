package fr.laposte.briefPlantdex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.briefPlantdex.model.Plante;

public interface PlanteRepository extends JpaRepository<Plante, Long> {

}
