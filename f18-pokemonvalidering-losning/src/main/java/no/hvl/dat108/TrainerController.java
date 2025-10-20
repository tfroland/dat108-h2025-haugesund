package no.hvl.dat108;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.validation.Valid;

@Controller
public class TrainerController {

	@GetMapping("/trainerform")
	public String trainerForm() {
		return "trainerForm";
	}
	
	@GetMapping("/checktrainer")
	public String checkTrainer(Model model,
			@Valid @ModelAttribute("trainer") Trainer trainer,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			List<String> errorMessages = errors.stream()
					.map(e -> e.getDefaultMessage()).toList();
			model.addAttribute("errorMessages", errorMessages);
			return "trainerForm";
		}
		
		return "trainerReceipt";
	}

}
