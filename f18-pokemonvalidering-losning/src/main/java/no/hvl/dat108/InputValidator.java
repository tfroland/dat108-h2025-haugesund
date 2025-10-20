package no.hvl.dat108;

public class InputValidator {

	/*
	 * "En gyldig level består av 1-2 siffer og er mellom 1 og 100"
	 */
	static boolean isValidLevel(String l) {
		
		//Steg1: Ikke godta null
		if (l == null) {
			return false;
		}
		
		//Steg2: Ikke godta om det ikke kan parses
		int level;
		try {
			level = Integer.parseInt(l);
		} catch (NumberFormatException e) {
			return false;
		}
		
		
	    //Steg3: Sjekke om gyldig level
		return level >= 1 && level <= 100;
	}
}