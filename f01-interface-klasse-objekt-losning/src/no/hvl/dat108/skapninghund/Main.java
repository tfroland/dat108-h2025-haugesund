package no.hvl.dat108.skapninghund;

/*
 * I dette eksemplet ser vi ulike måter/steder å definere klasser.
 * 
 * 	1. Som public class i egen fil. Eksempel Hund.
 * 	2. Som en ikke-public class sammen med andre klasser i en fil.
 *	3. Inni en annen klasse. Kalles "indre klasse" (static => "nøstet klasse"). 
 * 	4. Inni en metode. Kalles en lokal klasse. Eksempel Fugl.
 *  5. Som en direkte impl. av et interface. Kalles "anonym klasse". Eksempel katt.
 *  
 *  Anonyme klasser er for engangsbruk, altså for å opprette et objekt. Vi skal
 *  senere se hvordan dette kan skrives mye mer elegant. 
 */
public class Main {
	
	public static void main(String[] args) {

		// Hund (definer i Hund.java)
		Skapning hund = new Hund();
		hund.siHei();
		
		// Fugl (lokal klasse definert her i main
		class Fugl implements Skapning {
			@Override
			public void siHei() {
				System.out.println("Tweet!");
			}

			@Override
			public void siHei2() {
				System.out.println("Pip");
				
			}
		}
		
		Skapning fugl = new Fugl();
		fugl.siHei();
		
		// Anonym klasse som implementerer Skapning, 
		// og som vi deretter oppretter et objekt av på direkten.
		Skapning katt = new Skapning() {
			@Override
			public void siHei() {
				System.out.println("Mjau!");
			}
			
			public void siHei2() {
				System.out.println("Mjauuuu!");
			}
		};
		
		Skapning katt2 = new Skapning() {
			@Override
			public void siHei() {
				System.out.println("Mjau2!");
			}
			
			public void siHei2() {
				System.out.println("Mjauuuu!");
			}
		};
		
		katt.siHei();
		katt2.siHei();
		
		//katt.siHei2();
		
	}
}

