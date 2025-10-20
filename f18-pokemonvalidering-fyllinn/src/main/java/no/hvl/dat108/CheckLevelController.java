package no.hvl.dat108;

import static no.hvl.dat108.Pokemons.allPokemons;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckLevelController {

	@GetMapping("/levelform")
	public String levelForm() {
		return "levelForm";
	}

	@GetMapping("/checkLevel")
	public String checkLevel(Model model,
			String level) {

		//"Guard" - Vi sjekker og håndterer feilsituasjoner først
		boolean valid = InputValidator.isValidLevel(level);
		
		// ...
		
		//Kommer vi hit, er alt i orden
		model.addAttribute("valid", valid);
		return "feedback";
	}
}
