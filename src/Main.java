import java.util.HashMap;
import java.util.Scanner;

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
	private static String[] tegevused = new String[] {"külva", "kasta", "väeta", "rohi", "lõika"};
	
	/**
	 * Kontrollib kasutajalt saadud sisendit ning sooritab antud sõnale sarnaseima tegevuse
	 */
	public static void sisendiKontroll() {
		// Loo scanner
		Scanner sc = new Scanner(System.in);
		boolean protsess = true;
		String sarnaseimTegevus = "";
		
		// Küsi kuni saad sobiva vastuse
		while (protsess) {
			String[] vastus = sc.next().toLowerCase().split(" ");
			
			tagasi: // Label kust loopidest välja saab
			for (String s : tegevused) {
				int sarnasusi = 0;
				for (int j = 0; j < s.length(); j++) {
					// Kui sõna on piisavalt sarnane antud tegevusega, murra vali see ja murra välja
					if (sarnasusi >= 3) {
						sarnaseimTegevus = s;
						protsess = false;
						break tagasi; // Murra kahest loopist välja
					}
					
					// Kui kasutaja antud sõnas on sarnane täht, lisa sarnasuspunkte
					if (vastus[0].contains(s.substring(j, j + 1))) {
						sarnasusi++; 
					}
				}
			}
			
			// Kui sõnal pole piisavalt sarnasusi, küsi uuesti
			if (sarnaseimTegevus.equals("")) {
				System.out.println("Ei mõista soovitud tegevust. Proovi uuesti ");
			} 
		}
		
		System.out.println("Sooritan tegevuse : " + sarnaseimTegevus);
		
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
		
		Peenar p = new Peenar((int) (Math.random() * 100), (int) (Math.random() * 100),0);
		System.out.println(p.toString());
		p.kasta();
		System.out.println(p.toString());
		p.väeta();
		System.out.println(p.toString());
		
		Taim tomat = new Taim("Tomat", 0.5, "|", "<>", "O");
		
		p.istuta(tomat, 0);
		p.kasvata();
		sisendiKontroll();
		System.out.println(p.toString());
		
		// Graafiline osa
		
		//System.out.printf(String.format(kogused, 1, 1, 1));
		//System.out.printf(String.format(peenar, ""));
	}

}
