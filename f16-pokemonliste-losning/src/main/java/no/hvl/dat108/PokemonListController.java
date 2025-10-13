package no.hvl.dat108;

import static no.hvl.dat108.Pokemons.allPokemons;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonListController {

	@GetMapping("/allpokemon")
	public String allPokemon(Model model) {
		model.addAttribute("pokemonList", allPokemons);
		return "pokemonListView";
	}

	@GetMapping("/somepokemon")
	public String somePokemon(Model model,
			@RequestParam(required = false) String type) {
		if(type == null || type.trim().isEmpty()) {
			model.addAttribute("pokemonList", allPokemons);
		}
		else {
			List<Pokemon> somePokemon = allPokemons.stream()
					.filter(p -> p.type().contains(type)).toList();
			model.addAttribute("pokemonList", somePokemon);
		}
		
		return "pokemonListView";
	}
}
