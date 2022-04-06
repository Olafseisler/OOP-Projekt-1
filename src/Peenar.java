import java.util.Arrays;

public class Peenar {
	private int toitained;
	private int niiskus;
	private int umbrohi;
	private Taim taim;
	
	String peenar = """
|________________________|
 \\                     /
  \\                   /
   \\                 /
    \\               /
     \\             /
      \\___________/
			""";
	
	/**
	 * Peenra konstruktor
	 * @param toitained protsent mullas
	 * @param niiskus protsent mullas
	 */
	public Peenar(int toitained, int niiskus) {
		this.toitained = toitained;
		this.niiskus = niiskus;
	}
	
	/**
	 * Istutab uue taime potti
	 * @param taim mida istutada
	 */
	public void istuta(Taim taim) {
		if (this.taim == null)
			this.taim = taim;
		else {
			System.out.println("Potis on juba taim. Pead enne lõikama, kui uue istutad!");
		}
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
	

	public void rohi() {
		umbrohi -= Math.random() * 10;
	}

	public void lõika() {
		Main.lisaSaak(taim.getNimetus(), taim.getSaak());
		taim = null;
	}
	
	/**
	 * Üks simulaatori 'samm', otsustab iga taime kohta kas ta sellel käigul kasvab.
	 */
	public void kasvata() {
		if (taim != null) {
			// Kasvamise tõenäosus sõltub pinnase niiskusest ja toitainetest.
			// Hiljem oleks vaja ka midagi, mis vähendab tõenäosust kui pinnas on liiga
			// niiske või üleväetatud
			boolean kasKasvab = 2 * Math.random() * (niiskus/100.0) * (toitained/100.0) > 0.3;
			if (kasKasvab)
				taim.kasva();
		}
	}
	
	/**
	 * Muld kuivab kui seda mitte kasta
	 */
	public void kuiva() {
		niiskus = Math.max(0, niiskus - (int)(10 * Math.random()));
	}
	
	/**
	 * Taim tarbib toitaineid
	 */
	public void tarbiToitaineid() {
		toitained = Math.max(0, toitained - (int)(10 * Math.random()));
	}
	
	public boolean onTaim() {
		return taim != null;
	}
	
	public void esita() {
		if (taim != null) {
			String[] osad = taim.esita().split("\n");
			for (int i = 0; i < osad.length; i++) {
				System.out.println(" ".repeat(11) + osad[i]);
				
			}
			System.out.println("_".repeat(12) + "|" + "_".repeat(12));
			System.out.println(peenar);
		} else {
			System.out.println("_".repeat(25));
			System.out.println(peenar);
		}
			
	}
	
	@Override
	public String toString() {
		return "Peenar [toitained=" + toitained + ", niiskus=" + niiskus + ", taim=" + taim + "]";
	}
}
