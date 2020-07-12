package kniffel;

public class Rules {

	Kniffel kniffel;
	
	Rules(Kniffel window){
		this.kniffel = window;
	}
	
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
	
	public int dreierpaschRegel(int[] wuerfel) {
		int punkte = 0;
		int[]gleicheWuerfel = gleicheWuerfel(wuerfel);
		punkte = selection(wuerfel, gleicheWuerfel, 3);
		testPunktezahl(false, 5, 30, punkte);
		return punkte;
	}
	
	public int viererpaschRegel(int[] wuerfel) {
		int punkte = 0;
		int[]gleicheWuerfel = gleicheWuerfel(wuerfel);
		punkte = selection(wuerfel, gleicheWuerfel,4);
		testPunktezahl(false, 5, 30, punkte);
		return punkte;
	}
	
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
	
	public int kniffelRegel(int[] wuerfel) {
		int punkte = 0;
		int zaehler = 1;
		for (int i = 1; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			if(wuerfel[i-1] == wuerfel[i]) {
				zaehler++;
			}
		System.out.println(zaehler);
		}
		if (zaehler == 5) {
			punkte = 50;
		}
		testPunktezahl(true, 0, 50, punkte);
		return punkte;
	}
	
	public int chanceRegel(int[] wuerfel) {
		int punkte = 0;
		for (int i = 0; i < 5; i++) {
			testWuerfelzahl(wuerfel[i]);
			punkte += wuerfel[i];
		}
		testPunktezahl(false, 5, 30, punkte);
		return punkte;
	}
	
	// Ermittlung gleicher Zahlen im aktuellen Wurf
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
	
	// Ermittlung von Dreier- und Viererpaschs im aktuellen Wurf
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
	
	// Hilfsmethode, die eine Fehlemeldung ausgibt, wenn Würfelzahlen nicht gültig sind
	public void testWuerfelzahl(int wuerfelzahl) {
		if (wuerfelzahl < 1 || wuerfelzahl > 6) {
			throw new IllegalArgumentException("Würfelzahl <1 oder >6: " + wuerfelzahl);
		}
		
	}
	
	// Hilfsmethode, die eine Fehlemeldung ausgibt, wenn Punktezahlen einzelner Regeln nicht gültig sind
	public void testPunktezahl(Boolean fixePunktzahl, int minimum, int maximum, int punkte) {
		if (fixePunktzahl && punkte != minimum && punkte != maximum) {
			throw new IllegalArgumentException("Punktzahl ist nicht " + minimum + " oder " + maximum + ": " + punkte);
		} else if (!fixePunktzahl && (punkte < minimum || punkte > maximum)){
			throw new IllegalArgumentException("Punktzahl ist <" + minimum + " oder >" + maximum + ": " + punkte);
		}
	
	}
	
}
