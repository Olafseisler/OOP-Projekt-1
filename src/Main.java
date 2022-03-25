import java.util.HashMap;

public class Main {
	
	//-------------- NÄIDE ----------------
	String näide = """ 
			
			___^_____^_____^______^____^____/^_____
			||___________________________________||									
			||___________________________________||									
			||___________________________________||									
			||___________________________________||							
			
			
			([KÜLVA]) 	[KASTA]		[VÄETA]		[ROHI] 		[LÕIKA]
			
			KOGUSED:
			 
			TOMAT: 0 kg		REDIS: 0 kg 	PORGAND: 0 kg
			
											o	
			   /						 o /  
			  \\/	 ()	   (^)			 |/
			___||_____|_____\\______^____|____/^___
			||___________________________________||									
			||___________________________________||									
			||___________________________________||									
			||___________________________________||	
			
			
			[KÜLVA] 	[KASTA]		([VÄETA])		[ROHI]		[LÕIKA]

			KOGUSED:
			
			TOMAT: 0 kg		REDIS: 0 kg 	PORGAND: 0 kg
			
			
			
			___||_____]_____[______|____|____|_____
			||___________________________________||									
			||___________________________________||									
			||___________________________________||									
			||___________________________________||	
			
			
			[KÜLVA] 	[KASTA]		[VÄETA]		[ROHI]		([LÕIKA])

			KOGUSED:
			
			TOMAT: 5 kg		REDIS: 12 kg 	PORGAND: 7 kg
			
			
			""";
	//------------------------------------------------------------
	
	static String peenar = """
			
			______%s____%s____%s____%s____%s______
			||__________________________________||						
			||__________________________________||							
			||__________________________________||
			||__________________________________||
			
			""";
	static String tegevusedEsita = "[KÜLVA] 	[KASTA]		[VÄETA]		[ROHI]		[LÕIKA]";
	static String kogusedEsita = "TOMAT: %d kg	REDIS: %d kg	PORGAND: %d kg";
	
	private static HashMap<String, Double> kogused = new HashMap<String, Double>(); // Sõnastik taime nimede ja kogustega
	
	public static void sisendiKontroll() {
		// TODO: Kontrollida millise tegevusega sarnaneb 
		// kasutaja sisestatud sõne kõige enam (vähemalt 3 tähte kattuvad)
		// ning teha
	}
	
	/**
	 * Lisa saak sõnastikku. Kui antud taim on juba ees, lisa kogusele
	 * @param nimetus taime nimetus
	 * @param saak kogus kilodes
	 */
	public static void lisaSaak(String nimetus, double saak) {
		if (kogused.get(nimetus) != null)
			kogused.put(nimetus, kogused.get(nimetus) + saak);
		else
			kogused.put(nimetus, saak);
	}
	
	public static void main(String[] args) {
		
		Peenar p = new Peenar((int) (Math.random() * 100), (int) (Math.random() * 100));
		System.out.println(p.toString());
		p.kasta();
		System.out.println(p.toString());
		p.väeta();
		System.out.println(p.toString());
		
		Taim tomat = new Taim("Tomat", 0.5, "|", "<>", "O");
		
		p.istuta(tomat, 0);
		p.kasvata();
		System.out.println(p.toString());
		
		// Graafiline osa
		
		//System.out.printf(String.format(kogused, 1, 1, 1));
		//System.out.printf(String.format(peenar, ""));
	}

}
