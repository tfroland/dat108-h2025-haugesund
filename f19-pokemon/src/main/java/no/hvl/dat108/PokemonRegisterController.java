package no.hvl.dat108;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonRegisterController {
	
	@PostMapping("/register")
	public String acceptPokemonRegister(Model model, 
			String name, String type, int level) {
		
		Pokemon p = new Pokemon(name, type, level);
		model.addAttribute("pokemon", p);
		
		return "receipt";
	}
}
