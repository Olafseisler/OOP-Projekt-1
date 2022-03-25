
public class Taim {
	// Taime info
	private String nimetus;
	private double saagiRikkus;
	private double saak; // saak kilodes
	
	// Taime esitus sõnena
	private String vars;
	private String leht;
	private String vili;
	private String kujutus = "|";
	
	/**
	 * Taime isendi konstruktor, annab vajaliku info taime esitamiseks ekraanil
	 * @param vars sümbol
	 * @param leht sümbol
	 * @param vili sümbol
	 */
	public Taim(String nimetus, double saagiRikkus, String vars, String leht, String vili) {
		this.nimetus = nimetus;
		this.saagiRikkus = saagiRikkus;
		this.vars = vars;
		this.leht = leht;
		this.vili = vili;
		saak = 0;
	}

		
	public void kasva() {
		// TODO: rekursiivne meetod laiendab taime võra.
		// Suvaliste arvude generaator määrab millal tekib varre otsa 
		// vili ja millal leht. Praegu lisab saagile
		
		saak += Math.random() * saagiRikkus;
	}
	
	/**
	 * Tagastab sõnetüüpi esituse 
	 * @return
	 */
	public String esita() {
		return kujutus + "_";
	}
	
	
	public String getNimetus() {
		return nimetus;
	}
	
	public double getSaak() {
		return saak;
	}

	/**
	 * Tagastab info taime kohta
	 */
	@Override
	public String toString() {
		return "Taim [nimetus=" + nimetus + ", vars=" + vars + ", leht=" + leht + ", vili=" + vili + ", saak=" + saak + "]";
	}
	
	
	
}
