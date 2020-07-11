package kniffelFriederNeu;

public class Rules {

	Kniffel kniffel;
	
	Rules(Kniffel window){
		this.kniffel = window;
	}
	
	public int einerRegel() {
		int punkte = 0;
		int[] wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < wuerfel.length; i++) {
			if(wuerfel[i] == 1) {
				punkte += 1;
			}
		}
		if (punkte < 0 || punkte > 5) {
			throw new IllegalArgumentException("Einer-Punktzahl <0 oder >5: " + punkte);
		}
		return punkte;
	}
	
	public int zweierRegel() {
		int punkte = 0;
		int[] wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < wuerfel.length; i++) {
			if(wuerfel[i] == 2) {
				punkte += 2;
			}
		}
		if (punkte < 0 || punkte > 10) {
			throw new IllegalArgumentException("Zweier-Punktzahl <0 oder >10: " + punkte);
		}
		return punkte;
	}
	
	public int dreierRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < wuerfel.length; i++) {
			if(wuerfel[i] == 3) {
				punkte += 3;
			}
		}
		if (punkte < 0 || punkte > 15) {
			throw new IllegalArgumentException("Dreier-Punktzahl <0 oder >15: " + punkte);
		}
		return punkte;
	}
	
	public int viererRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < wuerfel.length; i++) {
			if(wuerfel[i] == 4) {
				punkte += 4;
			}
		}
		if (punkte < 0 || punkte > 20) {
			throw new IllegalArgumentException("Vierer-Punktzahl <0 oder >20: " + punkte);
		}
		return punkte;
	}
	
	public int fuenferRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < wuerfel.length; i++) {
			if(wuerfel[i] == 5) {
				punkte += 5;
			}
		}
		if (punkte < 0 || punkte > 5) {
			throw new IllegalArgumentException("Fünfer-Punktzahl <0 oder >25: " + punkte);
		}
		return punkte;
	}
	
	public int sechserRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < wuerfel.length; i++) {
			if(wuerfel[i] == 6) {
				punkte += 6;
			}
		}
		if (punkte < 0 || punkte > 30) {
			throw new IllegalArgumentException("Einer-Punktzahl <0 oder >30: " + punkte);
		}
		return punkte;
	}
	
	public int dreierpaschRegel() {
		int punkte = 0;
		int[]gleicheWuerfel = gleicheWuerfel();
		punkte = selection(gleicheWuerfel, 3);
		if (punkte < 5 || punkte > 30) {
			throw new IllegalArgumentException("Dreierpasch-Punktzahl <5 oder >30: " + punkte);
		}
		return punkte;
	}
	
	public int viererpaschRegel() {
		int punkte = 0;
		int[]gleicheWuerfel = gleicheWuerfel();
		punkte = selection(gleicheWuerfel,4);
		if (punkte < 5 || punkte > 30) {
			throw new IllegalArgumentException("Viererpasch-Punktzahl <5 oder >30: " + punkte);
		}
		return punkte;
	}
	
	public int fullhouseRegel() {
		int punkte = 0;
		boolean dreigleiche = false;
		boolean zweigleiche = false;
		int[]gleicheWuerfel = gleicheWuerfel();
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
		if (punkte != 25 && punkte != 0) {
			throw new IllegalArgumentException("FullHouse Punktzahl nicht 0 oder 25: " + punkte);
		}
		return punkte;
	}
	
	public int kstrasseRegel() {
		int punkte = 0;
		int strassenlaenge = 0;
		int[]gleicheWuerfel = gleicheWuerfel();
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
		if (punkte != 30 && punkte != 0) {
			throw new IllegalArgumentException("Kleine Straße Punktzahl nicht 0 oder 30: " + punkte);
		}
		return punkte;
	}
	
	public int gstrasseRegel() {
		int punkte = 0;
		int strassenlaenge = 0;
		int[]gleicheWuerfel = gleicheWuerfel();
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
		if (punkte != 40 && punkte != 0) {
			throw new IllegalArgumentException("Große Straße Punktzahl nicht 0 oder 40: " + punkte);
		}
		return punkte;
	}
	
	public int kniffelRegel() {
		int punkte = 0;
		int zaehler = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 1; i < wuerfel.length; i++) {
			if(wuerfel[i-1] == wuerfel[i]) {
				zaehler++;
			}
		}
		if (zaehler == 5) {
			punkte = 50;
		}
		if (punkte != 50 && punkte != 0) {
			throw new IllegalArgumentException("Kniffel-Punktzahl nicht 0 oder 50: " + punkte);
		}
		return punkte;
	}
	
	public int chanceRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < wuerfel.length; i++) {
			punkte += wuerfel[i];
		}
		if (punkte < 5 || punkte > 30) {
			throw new IllegalArgumentException("Chance-Punktzahl <5 oder >30: " + punkte);
		}
		return punkte;
	}
	
	// Ermittlung gleicher Zahlen im aktuellen Wurf
	public int[] gleicheWuerfel() {
		int[] gleicheWuerfel = new int[6];
		int[] wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < 5; i++) {
			gleicheWuerfel[wuerfel[i]-1]++;
			if (gleicheWuerfel[wuerfel[i]-1] < 1 || gleicheWuerfel[wuerfel[i]-1] > 5) {
				throw new IllegalArgumentException("Anzahl der Zahl " + wuerfel[i] + " <1 oder >5: " + gleicheWuerfel[wuerfel[i]-1]);
			}
		}
		return gleicheWuerfel;
	}
	
	// Ermittlung von Dreier- und Viererpaschs im aktuellen Wurf
	public int selection(int[]gleicheWuerfel,int index) {
		if (index < 3 || index > 4) {
			throw new IllegalArgumentException("Paschabfrage weder 3 noch 4: " + index);
		}
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < gleicheWuerfel.length; i++) {
			if(gleicheWuerfel[i] >= index) {
				for (int j = 0; j < 5; j++) {
					punkte+=wuerfel[j];
				}
			}
		}
		if (punkte < 5 || punkte > 30) {
			throw new IllegalArgumentException("Pasch-Punktzahl <5 oder >30: " + punkte);
		}
		return punkte;
	}
	
}
