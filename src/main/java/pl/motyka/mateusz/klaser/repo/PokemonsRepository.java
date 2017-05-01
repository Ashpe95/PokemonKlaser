package pl.motyka.mateusz.klaser.repo;

import java.util.List;

import pl.motyka.mateusz.klaser.NoSuchPokemonException;
import pl.motyka.mateusz.klaser.Pokemon;
import pl.motyka.mateusz.klaser.PokemonAlreadyExistsException;


public interface PokemonsRepository {
    Pokemon create(Pokemon pokemon) throws PokemonAlreadyExistsException;
    Pokemon readById(Long id) throws NoSuchPokemonException;
    Pokemon update(Pokemon pokemon) throws NoSuchPokemonException;
    void deleteById(Long id) throws NoSuchPokemonException;
    List<Pokemon> findAll();
    List<Pokemon> findAllToSell();
    List<Pokemon> findAllduplicate();
}