package no.hvl.dat108.webshop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.webshop.model.Cart;
import no.hvl.dat108.webshop.model.CartItem;
import no.hvl.dat108.webshop.util.LoginUtil;

@Controller
@RequestMapping("/webshop")
public class WebshopController {
	
	@Autowired
	private LoginUtil loginUtil;
	
	/* 
	 * GET /webshop er forespørselen for å vise webshop-siden.
	 */
	@GetMapping
    public String visWebshoppen(HttpSession session, RedirectAttributes ra) {
		
		if(!loginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", "Du må være innlogget for å kunne se webshopen.");
			return "redirect:login";
		}

		return "webshopView";
    }

	/* 
	 * POST /webshop er forespørselen for å handle en/flere varer.
	 */
	@PostMapping
    public String leggVarerIHandlekurv(
    		@RequestParam(name="vare", required=false) List<String> varerAaHandle,
    		HttpSession session, RedirectAttributes ra) {
		
		if(!loginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("redirectMessage", "Du må være innlogget for å kunne se webshopen.");
			return "redirect:login";
		}
		
		Map<String, CartItem> katalogvarer = Map.of(
				"bukse", new CartItem("bukse", 789),
				"genser", new CartItem("genser", 456)
				);
		
		if (varerAaHandle != null && !varerAaHandle.isEmpty()) {
			Cart handlekurv = (Cart) session.getAttribute("cart");
			
			for (String varenavn : varerAaHandle) {
				
				if(katalogvarer.containsKey(varenavn)) {
					handlekurv.addItem(katalogvarer.get(varenavn));
				}
			}
		}

		return "redirect:webshop";
    }
}
