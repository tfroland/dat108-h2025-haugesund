package no.hvl.dat108.f04;
import static no.hvl.dat108.f04.People.people;

import java.util.function.Consumer;

/*
 * Eksempel4
 * 
 * Vårt første stream()-eksempel.
 * Skrive ut alle med fornavn som begynner på "C".
 */
public class Eksempel4 {

	public static void main(String[] args) {
		
		//1 - Skrive ut alle med fornavn som begynner på "C"

		//Gamlemåten:		
		for (Person p : people) {
			if (p.firstName().startsWith("C")) {
				System.out.println(p);
			}
		}
		
		Consumer<Person> cons = p -> System.out.println(p);
		
		//Med streams:
		people.stream()
					.filter(p -> p.firstName().startsWith("C"))
					//.forEach(cons);
					//.forEach(p -> System.out.println(p));
					.forEach(System.out::println);
	}
}














