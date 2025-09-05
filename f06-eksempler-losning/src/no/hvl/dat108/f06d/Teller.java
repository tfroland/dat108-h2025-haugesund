package no.hvl.dat108.f06d;

public class Teller {

	private int verdi = 0;

	public synchronized void tellOpp() {
		// Kritisk seksjon
		verdi++;
	}

	public synchronized void tellNed() {
		// Kritisk seksjon
		verdi--;
	}

	public int getVerdi() {
		return verdi;
	}
}
