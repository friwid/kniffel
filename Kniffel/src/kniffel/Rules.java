/**
 * Kniffel mit User Interface
 *
 * @author Atakan Ata (1911877), Nils Rekus ‌(1826514), Frieder Widmann (1911820)

 */
package kniffel;

public class Rules {
	
	Rules(Kniffel window){
	
	}
	
	/**
	 * Einer-Regel Punkteberechnung.
	 * Regel: Nur Einer zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int einerRegel(int[] wuerfel) {
		int punkte = 0;
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			if(wuerfel[i] == 1) {
				punkte += 1;
			}
		}
		testPunktezahl(false, 0, 5, punkte);
		return punkte;
	}
	
	/**
	 * Zweier-Regel Punkteberechnung.
	 * Regel: Nur Zweier zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int zweierRegel(int[] wuerfel) {
		int punkte = 0;
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			if(wuerfel[i] == 2) {
				punkte += 2;
			}
		}
		testPunktezahl(false, 0, 10, punkte);
		return punkte;
	}
	
	/**
	 * Dreier-Regel Punkteberechnung.
	 * Regel: Nur Dreier zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int dreierRegel(int[] wuerfel) {
		int punkte = 0;
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			if(wuerfel[i] == 3) {
				punkte += 3;
			}
		}
		testPunktezahl(false, 0, 15, punkte);
		return punkte;
	}
	
	/**
	 * Vierer-Regel Punkteberechnung.
	 * Regel: Nur Vierer zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int viererRegel(int[] wuerfel) {
		int punkte = 0;
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			if(wuerfel[i] == 4) {
				punkte += 4;
			}
		}
		testPunktezahl(false, 0, 20, punkte);
		return punkte;
	}
	
	/**
	 * Fünfer-Regel Punkteberechnung
	 * Regel: Nur Fünfer zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int fuenferRegel(int[] wuerfel) {
		int punkte = 0;
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			if(wuerfel[i] == 5) {
				punkte += 5;
			}
		}
		testPunktezahl(false, 0, 25, punkte);
		return punkte;
	}
	
	/**
	 * Sechser-Regel Punkteberechnung.
	 * Regel: Nur Sechser zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int sechserRegel(int[] wuerfel) {
		int punkte = 0;
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			if(wuerfel[i] == 6) {
				punkte += 6;
			}
		}
		testPunktezahl(false, 0, 30, punkte);
		return punkte;
	}
	
	/**
	 * Dreierpasch-Regel Punkteberechnung.
	 * Regel: Drei gleiche Zahlen – Alle Augen zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int dreierpaschRegel(int[] wuerfel) {
		int punkte = 0;
		int[]gleicheWuerfel = gleicheWuerfel(wuerfel);
		punkte = selection(wuerfel, gleicheWuerfel, 3);
		testPunktezahl(false, 5, 30, punkte);
		return punkte;
	}
	
	/**
	 * Viererpasch-Regel Punkteberechnung.
	 * Regel: Vier gleiche Zahlen – Alle Augen zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int viererpaschRegel(int[] wuerfel) {
		int punkte = 0;
		int[]gleicheWuerfel = gleicheWuerfel(wuerfel);
		punkte = selection(wuerfel, gleicheWuerfel,4);
		testPunktezahl(false, 5, 30, punkte);
		return punkte;
	}
	
	/**
	 * Full House-Regel Punkteberechnung.
	 * Regel: Drei gleiche und zwei gleiche, andere Zahlen – 25 Punkte.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int fullhouseRegel(int[] wuerfel) {
		int punkte = 0;
		boolean dreigleiche = false;
		boolean zweigleiche = false;
		int[]gleicheWuerfel = gleicheWuerfel(wuerfel);
		for (int i = 0; i < gleicheWuerfel.length; i++) {
			if(gleicheWuerfel[i] == 2) {
				zweigleiche = true;
			}else if(gleicheWuerfel[i] == 3) {
				dreigleiche = true;
			}
		}
		if(zweigleiche&&dreigleiche) {
			punkte = 25;
		}
		testPunktezahl(true, 0, 25, punkte);
		return punkte;
	}
	
	/**
	 * Kleine Straße-Regel Punkteberechnung.
	 * Regel: 1-2-3-4, 2-3-4-5, oder 3-4-5-6 – 30 Punkte.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int kstrasseRegel(int[] wuerfel) {
		int punkte = 0;
		int strassenlaenge = 0;
		int[]gleicheWuerfel = gleicheWuerfel(wuerfel);
		for (int i = 0; i < 6; i++) {
			if(gleicheWuerfel[i] != 0) {
				strassenlaenge++;
			}else if (strassenlaenge < 4) {
				strassenlaenge = 0;
			}
		}
		if(strassenlaenge >= 4) {
			punkte = 30;
		}
		testPunktezahl(true, 0, 30, punkte);
		return punkte;
	}
	
	/**
	 * Große Straße-Regel Punkteberechnung.
	 * Regel: 1-2-3-4-5 oder 2-3-4-5-6 – 40 Punkte.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int gstrasseRegel(int[] wuerfel) {
		int punkte = 0;
		int strassenlaenge = 0;
		int[]gleicheWuerfel = gleicheWuerfel(wuerfel);
		for (int i = 0; i < 6; i++) {
			if(gleicheWuerfel[i] != 0) {
				strassenlaenge++;
			}else if(strassenlaenge < 5) {
				strassenlaenge = 0;
			}
		}
		if(strassenlaenge >= 5) {
			punkte = 40;
		}
		testPunktezahl(true, 0, 40, punkte);
		return punkte;
	}
	
	/**
	 * Kniffel-Regel Punkteberechnung.
	 * Regel: Fünf gleiche Zahlen – 50 Punkte.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int kniffelRegel(int[] wuerfel) {
		int punkte = 0;
		int zaehler = 1;
		for (int i = 1; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			if(wuerfel[i-1] == wuerfel[i]) {
				zaehler++;
			}
		}
		if (zaehler == 5) {
			punkte = 50;
		}
		testPunktezahl(true, 0, 50, punkte);
		return punkte;
	}
	
	/**
	 * Chance-Regel Punkteberechnung.
	 * Regel: Alle Augen zählen.
	 * 
	 * @param wuerfel: int[]
	 * @return punkte: int
	 */
	public int chanceRegel(int[] wuerfel) {
		int punkte = 0;
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			punkte += wuerfel[i];
		}
		testPunktezahl(false, 5, 30, punkte);
		return punkte;
	}
	
	/**
	 * Hilfsmethode, die gleiche Zahlen im aktuellen Wurf ermittelt.
	 * Wird aufgerufen in: Dreierpasch, Viererpasch, Full House, Kleine Straße, Große Straße
	 * 
	 * @param         wuerfel: int[]
	 * @return gleicheWuerfel: int[]
	 */
	public int[] gleicheWuerfel(int[] wuerfel) {
		int[] gleicheWuerfel = new int[6];
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			gleicheWuerfel[wuerfel[i]-1]++;
			if (gleicheWuerfel[wuerfel[i]-1] < 1 || gleicheWuerfel[wuerfel[i]-1] > 5) {
				throw new IllegalArgumentException("Anzahl der Zahl " + wuerfel[i] + " <1 oder >5: " + gleicheWuerfel[wuerfel[i]-1]);
			}
		}
		return gleicheWuerfel;
	}
	
	/**
	 * Hilfsmethode, die die Punkte in Dreier- und Viererpaschs ermittelt.
	 * Wird aufgerufen in in: Dreierpasch, Viererpasch
	 * 
	 * @param        wuerfel: int[]
	 * @param gleicheWuerfel: int[]
	 * @param          index: int
	 * @return        punkte: int
	 */
	public int selection(int[] wuerfel, int[] gleicheWuerfel, int index) {
		if (index != 3 && index != 4) {
			throw new IllegalArgumentException("Paschabfrage weder 3 noch 4: " + index);
		}
		int punkte = 0;
		for (int i = 0; i < gleicheWuerfel.length; i++) {
			if(gleicheWuerfel[i] >= index) {
				for (int j = 0; j < 5; j++) {
					punkte+=wuerfel[j];
				}
			}
		}
		return punkte;
	}
	
	/**
	 * Hilfsmethode, die eine Exception triggert, wenn übergebene Würfelzahl nicht gültig ist.
	 * Wird in regel-relevanten Methoden aufgerufen.
	 * 
	 * @param wuerfelzahl: int
	 */
	public void testWuerfelzahl(int wuerfelzahl) {
		if (wuerfelzahl < 1 || wuerfelzahl > 6) {
			throw new IllegalArgumentException("Würfelzahl <1 oder >6: " + wuerfelzahl);
		}
		
	}
	
	/**
	 * Hilfsmethode, die eine Fehlermeldung triggert, wenn Punktezahlen einzelner Regeln außerhalb valider Wertebereiche liegen.
	 * Wird in regel-relevanten Methoden aufgerufen.
	 * 
	 * @param fixePunktzahl: Boolean
	 * @param       minimum: int
	 * @param       maximum: int
	 * @param        punkte: int
	 */
	public void testPunktezahl(Boolean fixePunktzahl, int minimum, int maximum, int punkte) {
		if (fixePunktzahl && punkte != minimum && punkte != maximum) {
			throw new IllegalArgumentException("Punktzahl ist nicht " + minimum + " oder " + maximum + ": " + punkte);
		} else if (!fixePunktzahl && (punkte < minimum || punkte > maximum)){
			throw new IllegalArgumentException("Punktzahl ist <" + minimum + " oder >" + maximum + ": " + punkte);
		}
	
	}
	
}
