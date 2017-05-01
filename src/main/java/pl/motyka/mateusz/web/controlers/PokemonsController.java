package pl.motyka.mateusz.web.controlers;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.motyka.mateusz.klaser.CardType;
import pl.motyka.mateusz.klaser.EnergyType;
import pl.motyka.mateusz.klaser.Pokemon;
import pl.motyka.mateusz.klaser.Rarity;
import pl.motyka.mateusz.klaser.Status;
import pl.motyka.mateusz.klaser.services.KlaserService;
import pl.motyka.mateusz.klaser.services.NotificationService;


@Controller
public class PokemonsController {

	@Autowired
	// @Qualifier("spring")
	private KlaserService klaserService;
	@Autowired
	private NotificationService notificationService;

	@ModelAttribute("statusAll")
	public List<Status> populateStatus() {
		return Arrays.asList(Status.ALL);
	}

	@ModelAttribute("cardTypeAll")
	public List<CardType> populateCardType() {
		return Arrays.asList(CardType.ALL);
	}

	@ModelAttribute("rarityAll")
	public List<Rarity> populateRarity() {
		return Arrays.asList(Rarity.ALL);
	}

	@ModelAttribute("energyAll")
	public List<EnergyType> populateEnergyType() {
		return Arrays.asList(EnergyType.ALL);
	}

	@RequestMapping(value = "/pokemons/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Long id, final ModelMap model) {
		Optional<Pokemon> result;
		result = klaserService.findById(id);
		if (result.isPresent()) {
			Pokemon pokemon = result.get();
			model.addAttribute("pokemon", pokemon);
			return "pokemon";
		} else {
			notificationService.addErrorMessage("Cannot find pokemon #" + id);
			model.clear();
			return "redirect:/pokemons";
		}
	}

	@RequestMapping(value = "/pokemons/{id}/json", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Pokemon> viewAsJson(@PathVariable("id") Long id, final ModelMap model) {
		Optional<Pokemon> result;
		result = klaserService.findById(id);
		if (result.isPresent()) {
			Pokemon pokemon = result.get();
			return new ResponseEntity<Pokemon>(pokemon, HttpStatus.OK);
		} else {
			notificationService.addErrorMessage("Cannot find moneta #" + id);
			model.clear();
			return new ResponseEntity<Pokemon>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/pokemons", params = { "save" }, method = RequestMethod.POST)
	public String savePokemon(Pokemon pokemon, BindingResult bindingResult, ModelMap model) {

		if (bindingResult.hasErrors()) {
			notificationService.addErrorMessage("Please fill the form correctly!");
			return "pokemon";
		}
		Optional<Pokemon> result = klaserService.edit(pokemon);
		if (result.isPresent())
			notificationService.addInfoMessage("Zapis udany");
		else
			notificationService.addErrorMessage("Zapis NIE udany");
		model.clear();
		return "redirect:/pokemons";
	}

	@RequestMapping(value = "/pokemons", params = { "create" }, method = RequestMethod.POST)
	public String createPokemon(Pokemon pokemon, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			notificationService.addErrorMessage("Please fill the form correctly!");
			return "pokemon";
		}
		klaserService.create(pokemon);
		model.clear();
		notificationService.addInfoMessage("Zapis nowej udany");
		return "redirect:/pokemons";
	}

	@RequestMapping(value = "/pokemons/create", method = RequestMethod.GET)
	public String showMainPages(final Pokemon pokemon) {
		pokemon.setPurchaseDate(Calendar.getInstance().getTime());
		return "pokemon";
	}

	@RequestMapping(value = "/pokemons", params = { "remove" }, method = RequestMethod.POST)
	public String removeRow(final Pokemon pokemon, final BindingResult bindingResult, final HttpServletRequest req) {
		final Integer rowId = Integer.valueOf(req.getParameter("remove"));
		Optional<Boolean> result = klaserService.deleteById(rowId.longValue());
		return "redirect:/pokemons";
	}

	@RequestMapping(value = "/pokemons", params = { "edit" }, method = RequestMethod.GET)
	public String editRow(Pokemon pokemon, final BindingResult bindingResult, final HttpServletRequest req) {
		final Long rowId = Long.valueOf(req.getParameter("edit"));
		Optional<Pokemon> result = klaserService.edit(pokemon);
		if (result.isPresent()) {
			Pokemon poke = result.get();
			return "redirect:/pokemons/" + poke.getCatalogNumber();
		} else {
			return "pokemons";
		}
	}

}
