package pl.motyka.mateusz.web.controlers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.motyka.mateusz.klaser.Pokemon;
import pl.motyka.mateusz.klaser.Status;
import pl.motyka.mateusz.klaser.services.KlaserService;

@Controller
public class KlaserController {

    @Autowired
    //@Qualifier("spring")
    private KlaserService klaserService;

    @ModelAttribute("statusAll")
    public List<Status> populateStatus() {
        return Arrays.asList(Status.ALL);
    }

    @ModelAttribute("pokemonsAll")
    public List<Pokemon> populatePokemons() {
        return this.klaserService.findAll();
    }

    @ModelAttribute("pokemonsToSell")
    public List<Pokemon> populatePokemonsToSell() {
        return this.klaserService.findAllToSell();
    }
    
    @ModelAttribute("pokemonsDuplicate")
    public List<Pokemon> populatePokemonsDuplicate() {
        return this.klaserService.findAllduplicate();
    }

    @ModelAttribute("pokemonsLast3")
    public List<Pokemon> populateLast3Pokemons() {
        return this.klaserService.findLatest3();
    }

    @RequestMapping({ "/", "/index" })
    public String index(ModelMap model) {
        model.put("msg", "Wartosc z modelu");
        return "index";
    }

    @RequestMapping(value = "/pokemons", method = RequestMethod.GET)
    public String showMainPage() {
        return "pokemons";
    }

    @RequestMapping("/tosell")
    public String showToSellPage() {
        return "tosell";
    }
    
    @RequestMapping("/duplicates")
    public String showToDuplicatePage() {
        return "duplicates";
    }
}
