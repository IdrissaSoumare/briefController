package fr.laposte.briefPlantdex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.laposte.briefPlantdex.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
