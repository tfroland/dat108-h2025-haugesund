package no.hvl.dat108;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PokemonListController {

	@GetMapping("/allpokemon")
	public String allPokemon(Model model) {
		return null; //TODO fyll inn
	}

	@GetMapping("/somepokemon")
	public String somePokemon(Model model) {
		return null; //TODO fyll inn
	}
}
