package no.hvl.dat108.webshop.util;

public class InputValidator {

    private final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
    private final String ANY_LETTER_OR_DIGIT = "[a-zA-ZæøåÆØÅ0-9]";
    private final String THREE_OR_MORE_TIMES = "{3,}";

    /**
     * 
     * @param username Brukernavnet som skal valideres
     * @return Om brukenavnet er gyldig eller ikke
     * 
     * Et gyldig brukernavn består av 4 eller flere tegn. Lovlige tegn
     * er bokstaver (små og store) inkl. de norske bokstavene og tall.
     * Brukernavnet kan ikke begynne med et tall.
     */
    public boolean isValidUsername(String username) {
    	return username != null && username.matches("^" + ANY_LETTER
    			+ ANY_LETTER_OR_DIGIT + THREE_OR_MORE_TIMES + "$");
    }
}






