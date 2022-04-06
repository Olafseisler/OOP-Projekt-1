import java.util.Random;

public class Taim {
	// Taime info
	private String nimetus;
	private double saagiRikkus;
	private int maxKõrgus;
	private double saak; // saak kilodes
	
	// Taime esitus sõnena
	private String leht;
	private String vili;
	private String kujutus = " |";
	
	/**
	 * Taime isendi konstruktor, annab vajaliku info taime esitamiseks ekraanil
	 * @param vars sümbol
	 * @param leht sümbol
	 * @param vili sümbol
	 */
	public Taim(String nimetus, double saagiRikkus, int maxKõrgus, String leht, String vili) {
		this.nimetus = nimetus;
		this.saagiRikkus = saagiRikkus;
		this.maxKõrgus = maxKõrgus;
		this.leht = leht;
		this.vili = vili;
		saak = 0;
	}

		
	public void kasva() {
		saak += Math.random() * saagiRikkus;
		
		String[] valikudparem = {"/", leht};
		String[] valikudvasak = {"\\", leht};

		Random random = new Random();
		int i = 0;
		while(i<1 && kujutus.split("\n").length < maxKõrgus) {
			int valikparem = random.nextInt(valikudparem.length);
			int valikvasak = random.nextInt(valikudvasak.length);
			String[] viimanekasv = kujutus.split("\n");
			String kasv;
			if (viimanekasv[0].equals("|/")) {
				kasv = valikudvasak[valikvasak] + "|" + vili;
				if (valikudvasak[valikvasak].equals("")) {
					kasv = " " + "|" + vili;
				}
			}
			else if ((viimanekasv[0].equals("\\|"))) {
				kasv = vili + "|" + valikudparem[valikparem];
			}
			else if ((viimanekasv[0].equals("\\|/"))) {
				kasv = vili + "|" + vili;
			}
			else if ((viimanekasv[0].equals(" |"))) {
				kasv = valikudvasak[valikvasak] + "|" + valikudparem[valikparem];
				if (valikudvasak[valikvasak].equals("")) {
					kasv = " " + "|" + valikudparem[valikparem];
				}
			}
			else{
				kasv = valikudvasak[valikvasak] + "|" + valikudparem[valikparem];
				if (valikudvasak[valikvasak].equals("")) {
					kasv = " " + "|" + valikudparem[valikparem];
				}
			}
			kujutus = kasv + "\n" + kujutus;
			i++;
		}
	}

	
	/**
	 * Tagastab sõnetüüpi esituse 
	 * @return
	 */
	public String esita() {
		return kujutus;
	}
	
	/**
	 * Tagastab nimetuse
	 * @return
	 */
	public String getNimetus() {
		return nimetus;
	}
	
	/**
	 * Tagastab hetkese saagi
	 * @return
	 */
	public double getSaak() {
		return saak;
	}

	/**
	 * Tagastab info taime kohta
	 */
	@Override
	public String toString() {
		return "Taim [nimetus=" + nimetus + ", leht=" + leht + ", vili=" + vili + ", saak=" + saak + "]";
	}
	
	
	
}
