package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

public class Eks2countmatch {

	public static void main(String[] args) {

		//Alle forbokstavene i fornavnene i en streng "CLTCM" - reduce()
		String forboks = people.stream()
				.map(p -> p.firstName().charAt(0))
				.reduce("", String::concat);
		
		//Antall personer over 50 år - count()
		
		//Om vi har data som matcher - anyMatch(), allMatch(), noneMatch()
		//Er alle over 30 år?
		//Er noen over 60 år?

	}

}




