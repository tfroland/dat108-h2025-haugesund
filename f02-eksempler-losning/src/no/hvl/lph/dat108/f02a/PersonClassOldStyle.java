package no.hvl.lph.dat108.f02a;

public class PersonClassOldStyle implements Comparable<PersonClassOldStyle> {
	
	private final String fornavn;
	private final String etternavn;
	private final int fodselsaar;

	public PersonClassOldStyle(String fornavn, String etternavn, int fodselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fodselsaar = fodselsaar;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public int getFodselsaar() {
		return fodselsaar;
	}

	/* Ønsker en litt forenklet toString() */
	@Override
	public String toString() {
		return "["+ fornavn + ", " + etternavn + ", " + fodselsaar + "]";
	}
	
	/* Ønsker standard sortering på etternavn */
	@Override
	public int compareTo(PersonClassOldStyle other) {
		return this.etternavn.compareTo((other.etternavn));
	}
}






