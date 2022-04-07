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
	
	
	static String tegevusRiba = "[KÜLVA] 	[KASTA]		[VÄETA]		[ROHI]		[LÕIKA]";
	static String taimed = "TAIMEDE NUMBRID ISTUTAMISEKS: TOMAT : 1	PAPRIKA : 2	HERNES : 3";
	static String kogusedEsita = "TOMAT: %f kg	PAPRIKA: %f kg	HERNES: %f kg";
	
	private static HashMap<String, Double> kogused = new HashMap<String, Double>(); // Sõnastik taime nimede ja kogustega
	private static String[] tegevused = new String[] {"külva", "kasta", "väeta", "rohi", "lõika"};
	
	/**
	 * Kontrollib kasutajalt saadud sisendit ning sooritab antud sõnale sarnaseima tegevuse
	 */
	public static void sisendiKontroll(Peenar peenar) {
		// Loo scanner
		Scanner sc = new Scanner(System.in);
		boolean protsess = true;
		String sarnaseimTegevus = "";
		int taim = 0;
		
		// Küsi kuni saad sobiva vastuse
		while (protsess) {
			String[] vastus = sc.nextLine().toLowerCase().split(" ");
			if (vastus.length >= 2) {
				try {
					taim = Integer.valueOf(vastus[1]);
				} catch (Exception e){
					taim = 0;
				}
			}
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
		switch(sarnaseimTegevus) {
		case "külva" :
			if (taim == 1)
				peenar.istuta(new Taim("Tomat", 0.5, 7, "^", "O"));
			else if (taim == 2)
				peenar.istuta(new Taim("Paprika", 0.8, 5, "{}", "B"));
			else if (taim == 3)
				peenar.istuta(new Taim("Hernes", 0.7, 10, "P", "["));
			else
				System.out.println("[[[ Palun ütle tühikuga eraldatud taime number mida külvata! ]]]");
			break;
		
		case "kasta" : 
			peenar.kasta();
			break;
		case "väeta" :
			peenar.väeta();
			break;
		case "rohi"  :
			peenar.rohi();
			break;
		case "lõika" : 
			peenar.lõika();
			break;
		}
		
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
		
		Peenar p = new Peenar((int) (Math.random() * 100), (int) (Math.random() * 100), (int) (Math.random() * 100));
		p.esita();
		
		// Küsi mängijalt sisendit ja simuleeri taime kasvu
		while (true) {
			System.out.println(tegevusRiba);
			System.out.println(taimed);
			System.out.printf(kogusedEsita, kogused.get("Tomat"), kogused.get("Paprika"), kogused.get("Hernes"));
			System.out.println();
			System.out.print("Kirjuta soovitud tegevus: ");
			sisendiKontroll(p);
			
			System.out.println();

			p.esita();
			p.kasvata();
			System.out.println(p.toString());
			System.out.println();
			p.kuiva();
			if (p.onTaim()) {
				p.tarbiToitaineid();
				p.kasvataUmbrohtu();
			}
			//System.out.println();
		}
		
	}

}
