package no.hvl.dat108.f04;

import static no.hvl.dat108.f04.People.people;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
/*
 * Eksempel2
 * 
*  I dette eksemplet ser vi hvordan vi kan erstatte 
*  lambda-uttrykk med metodereferanser.
*/
public class Eksempel2 {
	
	private static String initialer(Person p) {
		return p.firstName().substring(0,1) + p.lastName().substring(0,1);
	}
	
	private static double snitt(double a, double b) {
		return (a + b) / 2;
	}
	
	// Meningsløs metode som kun er ment for å øve på funksjoner og metodereferanser
	private static void gjorNoeMedPerson(Person person, Consumer<Person> cons) {
		cons.accept(person);
	}
	
	// Meningsløs metode som kun er ment for å øve på funksjoner og metodereferanser
	private static String personTilString(Person person, Function<Person, String> fu) {
		return fu.apply(person);
	}
	
	// Meningsløs metode som kun er ment for å øve på funksjoner og metodereferanser
	private static double brukeBiFunc(Double a, Double b, BinaryOperator<Double> op) {
		return op.apply(a, b);
	}
	
	public static void main(String[] args) {
		
		Person arne = new Person("Arne", "And", 1990);
		
		gjorNoeMedPerson(arne, p -> System.out.println(p));
		
		//String fornavn = personTilString(arne, p -> p.firstName());
		String fornavn = personTilString(arne, Person::firstName);
		System.out.println(fornavn);
		
		//String initialer = personTilString(arne, p -> initialer(p));
		String initialer = personTilString(arne, Eksempel2::initialer);
		System.out.println(initialer);
		
		//double maks = brukeBiFunc(4.0, 5.0, (a,b) -> Math.max(a, b));
		double maks = brukeBiFunc(4.0, 5.0, Double::max);
		System.out.println(maks);
		
//		double snitt = brukeBiFunc(2.0, 5.0, (a,b) -> snitt(a, b));
		double snitt = brukeBiFunc(2.0, 5.0, Eksempel2::snitt);
		System.out.println(snitt);
		
		people.sort((p1,p2) -> p1.compareTo(p2));
		
		people.forEach(p -> System.out.println(p));
		
	}
}

