package fr.laposte.briefPlantdex.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.laposte.briefPlantdex.model.Categorie;
import fr.laposte.briefPlantdex.repository.CategorieRepository;
import fr.laposte.briefPlantdex.service.ServiceCategorie;
import fr.laposte.briefPlantdex.service.dto.CategorieDTO;
import jakarta.transaction.Transactional;

@Service
public class ServiceCategorieImpl implements ServiceCategorie {

	@Autowired
	private CategorieRepository categorieRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<CategorieDTO> listerCategorie() {
		List<Categorie> categorie = categorieRepository.findAll();
		List<CategorieDTO> listDTO = categorie.stream().map(p -> modelMapper.map(p, CategorieDTO.class))
				.collect(Collectors.toList());
		return listDTO;
	}

	@Override
	public CategorieDTO rechercherCategorieById(Long id) {
		return modelMapper.map(categorieRepository.findById(id), CategorieDTO.class);
	}

	@Override
	@Transactional
	public CategorieDTO modifierCategorie(CategorieDTO categorie, Long categorieId) {
		Categorie categorieModel = modelMapper.map(categorie, Categorie.class);
		categorieModel.setId(categorieId);
		;
		return modelMapper.map(categorieRepository.save(categorieModel), CategorieDTO.class);

	}

	@Override
	public CategorieDTO ajouterCategorie(CategorieDTO categorie) {
		Categorie categorieModel = modelMapper.map(categorie, Categorie.class);
		return modelMapper.map(categorieRepository.save(categorieModel), CategorieDTO.class);
	}

	@Override
	public void supprimerCategorie(Long categorieId) {
		categorieRepository.deleteById(categorieId);

	}

}
