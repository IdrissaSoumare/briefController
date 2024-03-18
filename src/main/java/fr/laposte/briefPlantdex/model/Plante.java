package fr.laposte.briefPlantdex.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Plante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NonNull
	private String nom;

	@NonNull
	@Enumerated(EnumType.STRING)
	private Ensoleillement ensoleillement;

	@ManyToOne
	private Categorie categorie;

	@NonNull
	private Integer arrosage;

}
