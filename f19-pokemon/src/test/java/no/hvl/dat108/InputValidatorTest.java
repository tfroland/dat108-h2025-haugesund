package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

/*
 * "En gyldig level består av 1-2 siffer og er mellom 1 og 100"
 */
public class InputValidatorTest {
	
	@Test
	void nullIsInvalidLevel() {
		assertFalse(InputValidator.isValidLevel(null));
	}
	
	@Test
	void emptyStringIsInvalidLevel() {
		assertFalse(InputValidator.isValidLevel(""));
	}

	@Test
	void notOnlyDigitsIsInvalidLevel() {
		assertFalse(InputValidator.isValidLevel("1x"));
		assertFalse(InputValidator.isValidLevel("-20"));
		assertFalse(InputValidator.isValidLevel("-1"));
		assertFalse(InputValidator.isValidLevel(" 19"));
		assertFalse(InputValidator.isValidLevel("19 "));
	}

	@Test
	void notWithinRangeIsInvalidLevel() {	
		assertFalse(InputValidator.isValidLevel("123"));
		assertFalse(InputValidator.isValidLevel("0"));
		assertFalse(InputValidator.isValidLevel("189"));
		assertFalse(InputValidator.isValidLevel("9000"));
	}

	@Test
	void twoDigitsIsValidLevel() {	
		assertTrue(InputValidator.isValidLevel("19"));
		assertTrue(InputValidator.isValidLevel("95"));
		assertTrue(InputValidator.isValidLevel("2"));
		assertTrue(InputValidator.isValidLevel("100"));
	}
}
