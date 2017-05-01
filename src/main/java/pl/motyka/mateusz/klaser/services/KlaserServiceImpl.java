package pl.motyka.mateusz.klaser.services;

import pl.motyka.mateusz.klaser.Status;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import pl.motyka.mateusz.klaser.NoSuchPokemonException;
import pl.motyka.mateusz.klaser.Pokemon;
import pl.motyka.mateusz.klaser.PokemonAlreadyExistsException;
import pl.motyka.mateusz.klaser.repo.PokemonsRepository;

@Service
@Primary
public class KlaserServiceImpl implements KlaserService {

	@Autowired
	@Qualifier("lista")
	private PokemonsRepository pokemonsRepository;

	@Override
	public List<Pokemon> findAll() {
		return pokemonsRepository.findAll();
	}
	

	@Override
	public List<Pokemon> findAllduplicate() {
		return pokemonsRepository.findAll().stream().filter(card -> card.getStatus() == Status.DUPLICATE).collect(Collectors.toList());
	}

	@Override
	public List<Pokemon> findAllToSell() {
		return pokemonsRepository.findAll().stream().filter(card -> card.getStatus() == Status.TO_SELL).collect(Collectors.toList());
	}

	@Override
	public Optional<Pokemon> findById(Long id) {
		try {
			return Optional.of(pokemonsRepository.readById(id));
		} catch (NoSuchPokemonException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Pokemon> create(Pokemon pokemon) {
		try {
			return Optional.of(pokemonsRepository.create(pokemon));
		} catch (PokemonAlreadyExistsException e) {
			try {
				return Optional.of(pokemonsRepository.readById(pokemon.getCatalogNumber()));
			} catch (NoSuchPokemonException e1) {
				return Optional.empty();
			}
		}
	}

	@Override
	public Optional<Pokemon> edit(Pokemon pokemon) {
		try {
			return Optional.of(pokemonsRepository.update(pokemon));
		} catch (NoSuchPokemonException e) {
			return Optional.empty();
		}

	}

	@Override
	public Optional<Boolean> deleteById(Long id) {
		try {
			pokemonsRepository.deleteById(id);
			return Optional.of(Boolean.TRUE);
		} catch (NoSuchPokemonException e) {
			return Optional.of(Boolean.FALSE);
		}
	}

	@Override
	public List<Pokemon> findLatest3() {
		return Collections.emptyList();
	}


}
