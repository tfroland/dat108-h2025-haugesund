package no.hvl.dat108;

public record Pokemon(String name, String type, int level) {
	
	/* Siden EL-uttrykk som ${pokemon.tittel} ihht. JavaBean-spesifikasjonen 
	 * tolkes som et kall til pokemon.getTittel(), og record i stedet har kalt 
	 * denne metoden for pokemon.tittel(), vil det ikke virke uten videre
	 * med records. En enkel fiks kan være å legge til aktuelle gettere:
	 */
	public String getName() { return name(); }
	public String getType() { return type(); }
	public int getLevel() { return level(); }

	/* Vi har likevel fordeler med record siden vi får gratis:
	 * - instansvariabler
	 * - parametrisk konstruktør
	 * - ikke-muterbare instanser
	 * - equals og hashcode
	 * - toString
	 */
}

