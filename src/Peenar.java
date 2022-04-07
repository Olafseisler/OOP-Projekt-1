import java.util.Arrays;

public class Peenar {
	private int toitained;
	private int niiskus;
	private int umbrohi;
	private Taim[] taimed;
	
	/**
	 * Peenra konstruktor
	 * @param toitained protsent mullas
	 * @param niiskus protsent mullas
	 */
	public Peenar(int toitained, int niiskus, int umbrohi) {
		this.toitained = toitained;
		this.niiskus = niiskus;
		this.umbrohi = umbrohi;
		this.taimed = new Taim[5]; // Praegu 5 istikut/taime max
	}
	
	public void istuta(Taim taim, int istik) {
		taimed[istik] = taim;
	}
	
	/**
	 * Kasta peenart
	 */
	public void kasta() {
		niiskus = Math.min(niiskus + 10, 100);
	}
	
	/**
	 * Väeta peenart
	 */
	public void väeta() {
		toitained = Math.min(toitained + 10, 100);
	}
	


	public void lõika(int istik) {
		taimed[istik] = null;
		Main.lisaSaak(taimed[istik].getNimetus(), taimed[istik].getSaak());
	}
	
	/**
	 * Üks simulaatori 'samm', otsustab iga taime kohta kas ta sellel käigul kasvab.
	 */
	public void kasvata() {
		for (Taim taim : taimed) {
			if (taim != null) {
				// Kasvamise tõenäosus sõltub pinnase niiskusest ja toitainetest.
				// Hiljem oleks vaja ka midagi, mis vähendab tõenäosust kui pinnas on liiga
				// niiske või üleväetatud
				boolean kasKasvab = Math.random() * (niiskus/100) * (toitained/100) > 0.3;
				if (kasKasvab) {
					umbrohi = (int) Math.round(Math.random());
					niiskus = niiskus - 10;
					toitained = toitained - 20;
					taim.kasva(umbrohi, toitained);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return "Peenar [toitained=" + toitained + ", niiskus=" + niiskus + ", taimed=" + Arrays.toString(taimed) + "]";
	}
}
