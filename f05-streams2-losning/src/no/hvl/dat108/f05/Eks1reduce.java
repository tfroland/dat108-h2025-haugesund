package no.hvl.dat108.f05;

import static no.hvl.dat108.f05.People.people;

public class Eks1reduce {
	
	public static void main(String[] args) {
		
		/* Summen av aldrene til personene i people-listen */
		int sumAlder = people.stream()
				.map(p -> p.age())
				.reduce(0, (sum, x) -> sum + x);
		
		int sumAlder2 = people.stream()
				.map(p -> p.age())
				.reduce(0, (sum, x) -> Integer.sum(sum, x));
		
		int sumAlder3 = people.stream()
				.map(Person::age)
				.reduce(0, Integer::sum);
		
		int sumAlder4 = people.stream().mapToInt(Person::age).sum();
		
		System.out.println(sumAlder);
		
		/* En streng med alle initialene, "CD LC TC CB MA" */
		String inits = people.stream()
				.map(p -> "" + p.firstName().charAt(0) + p.lastName().charAt(0))
				.reduce("", (akku, s) -> akku + s + " ");
		System.out.println(inits);

	}	
}
