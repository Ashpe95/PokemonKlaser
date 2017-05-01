package pl.motyka.mateusz.klaser.services;

import java.util.List;
import java.util.Optional;

import pl.motyka.mateusz.klaser.Pokemon;

public interface KlaserService {
	List<Pokemon> findAll();

	List<Pokemon> findAllToSell();
	
	List<Pokemon> findAllduplicate();

	Optional<Pokemon> findById(Long id);

	Optional<Pokemon> create(Pokemon pokemon);

	Optional<Pokemon> edit(Pokemon pokemon);

	Optional<Boolean> deleteById(Long id);

	List<Pokemon> findLatest3();
}