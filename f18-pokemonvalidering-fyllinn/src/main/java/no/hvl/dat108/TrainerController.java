package no.hvl.dat108;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TrainerController {

	@GetMapping("/trainerform")
	public String trainerForm() {
		return "trainerForm";
	}
	
	@GetMapping("/checkTrainer")
	public String checkTrainer(Model model,
			@ModelAttribute("trainer") Trainer trainer) {
		
		return "trainerReceipt";
	}

}
