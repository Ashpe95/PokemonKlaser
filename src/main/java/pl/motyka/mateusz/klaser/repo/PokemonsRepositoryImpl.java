package pl.motyka.mateusz.klaser.repo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.motyka.mateusz.klaser.CardType;
import pl.motyka.mateusz.klaser.EnergyType;
import pl.motyka.mateusz.klaser.NoSuchPokemonException;
import pl.motyka.mateusz.klaser.Pokemon;
import pl.motyka.mateusz.klaser.PokemonAlreadyExistsException;
import pl.motyka.mateusz.klaser.Rarity;
import pl.motyka.mateusz.klaser.Status;


@Service
@Qualifier("lista")
public class PokemonsRepositoryImpl implements PokemonsRepository {
	
	private Status status;

    private List<Pokemon> pokemons = new ArrayList<Pokemon>() {
        {
        	add(Pokemon.producePokemon(
        			22L, 
        			EnergyType.FIRE, 
        			CardType.BASIC, 
        			Rarity.COMMON, 
        			60, 
        			"Nothing", 
        			10, 
        			"Discard an Energy attached to this Pokémon.", 
        			30, 
            		"1x Colorless", 
            		"2x Water", 
            		"Nothing", 
            		"Pansear", 
        			Status.NEW,
        			new Date(),
        			new BigDecimal("70.0")));
        	
            add(Pokemon.producePokemon(
            		3L,
            		EnergyType.GRASS, 
            		CardType.BASIC, 
            		Rarity.COMMON, 
            		50,
            		"If your opponent's Active Pokémon is a Grass Pokémon, this attack does 20 more damage.", 
            		10, 
            		"Nothing", 
            		0, 
            		"1x Colorless", 
            		"2x Fire", 
            		"Nothing", 
            		"Weedle",
            		Status.NEW, 
            		new Date(),
        			new BigDecimal("50.0")));
            
            add(Pokemon.producePokemon(
            		3L,
            		EnergyType.GRASS, 
            		CardType.BASIC, 
            		Rarity.COMMON, 
            		50,
            		"If your opponent's Active Pokémon is a Grass Pokémon, this attack does 20 more damage.", 
            		10, 
            		"Nothing", 
            		0, 
            		"1x Colorless", 
            		"2x Fire", 
            		"Nothing", 
            		"Weedle",
            		Status.DUPLICATE, 
            		new Date(),
        			new BigDecimal("50.0")));
            
        	add(Pokemon.producePokemon(
        			47L, 
        			EnergyType.PSYCHIC, 
        			CardType.BASIC, 
        			Rarity.COMMON, 
        			70, 
        			"Bite", 
        			20, 
        			"Nothing", 
        			0, 
            		"2x Colorless", 
            		"2x Psychic", 
            		"Nothing", 
            		"Ekans", 
        			Status.TO_SELL,
        			new Date(),
        			new BigDecimal("90.0")));
        	
        	add(Pokemon.producePokemon(
        			61L, 
        			EnergyType.FIGHTING, 
        			CardType.STAGE_1, 
        			Rarity.RARE, 
        			100, 
        			"Horn drill", 
        			50, 
        			"Flip 2 coins. If both are heads, discard the top card of your opponent's deck for each damage counter on this Pokémon.", 
        			0, 
            		"3x Colorless", 
            		"2x Grass", 
            		"Nothing", 
            		"Rhydon", 
        			Status.TO_SELL,
        			new Date(),
        			new BigDecimal("135.0")));
        }
    };

    @Override
    public List<Pokemon> findAll() {
        return this.pokemons;
    }
    
    @Override
    public List<Pokemon> findAllToSell() {
    	return this.pokemons;
    }

    @Override
    public Pokemon readById(Long id) throws NoSuchPokemonException {
        return this.pokemons.stream().filter(p -> Objects.equals(p.getCatalogNumber(), id)).findFirst()
                .orElseThrow(NoSuchPokemonException::new);
    }

    @Override
    public Pokemon create(Pokemon pokemon) throws PokemonAlreadyExistsException {
        if (!pokemons.isEmpty()) {
            pokemon.setCatalogNumber(
                    this.pokemons.stream().mapToLong(p -> p.getCatalogNumber()).max().getAsLong() + 1);
        } else {
            pokemon.setCatalogNumber(1L);
        }
        this.pokemons.add(pokemon);
        return pokemon;
    }

    @Override
    public Pokemon update(Pokemon pokemon) throws NoSuchPokemonException {
        for (int i = 0; i < this.pokemons.size(); i++) {
            if (Objects.equals(this.pokemons.get(i).getCatalogNumber(), pokemon.getCatalogNumber())) {
                this.pokemons.set(i, pokemon);
                return pokemon;
            }
        }
        throw new NoSuchPokemonException("Nie ma takiego Pokemona: " + pokemon.getCatalogNumber());
    }

    @Override
    public void deleteById(Long id) throws NoSuchPokemonException {
        for (int i = 0; i < this.pokemons.size(); i++) {
            if (Objects.equals(this.pokemons.get(i).getCatalogNumber(), id)) {
                this.pokemons.remove(i);
            }
        }
        throw new NoSuchPokemonException("Nie ma takiego Pokemona: " + id);
    }

	@Override
	public List<Pokemon> findAllduplicate() {
		return this.pokemons;
	}

}
