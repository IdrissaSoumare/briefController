package fr.laposte.briefPlantdex.service;

import java.util.List;

import fr.laposte.briefPlantdex.service.dto.CategorieDTO;

public interface ServiceCategorie {

	List<CategorieDTO> listerCategorie();

	CategorieDTO rechercherCategorieById(Long id);

	CategorieDTO modifierCategorie(CategorieDTO categorie, Long id);

	CategorieDTO ajouterCategorie(CategorieDTO categorie);

	void supprimerCategorie(Long categorieId);
}
