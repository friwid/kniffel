package kniffelNilsNeu;
import java.util.Arrays;

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
		return punkte;
	}
	
	public int dreierpaschRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		int[]gleicheWuerfel = gleicheWuerfel();
		punkte = selection(gleicheWuerfel, 3);
		return punkte;
	}
	
	public int viererpaschRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		int[]gleicheWuerfel = gleicheWuerfel();
		punkte = selection(gleicheWuerfel,4);
		return punkte;
	}
	
	public int fullhouseRegel() {
		int punkte = 0;
		boolean dreigleiche = false;
		boolean zweigleiche = false;
		int[]wuerfel = kniffel.getWuerfel();
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
		return punkte;
	}
	
	public int kniffelRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 1; i < wuerfel.length; i++) {
			if(wuerfel[i-1] == wuerfel[i]) {
				punkte = 50;
			}
		}
		return punkte;
	}
	
	public int chanceRegel() {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < wuerfel.length; i++) {
			punkte += wuerfel[i];
		}
		return punkte;
	}
	
	public int[] gleicheWuerfel() {
		int[] gleicheWuerfel = new int[6];
		int[] wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < 5; i++) {
			gleicheWuerfel[wuerfel[i]-1]++;
		}
		return gleicheWuerfel;
	}
	
	public int selection(int[]gleicheWuerfel,int index) {
		int punkte = 0;
		int[]wuerfel = kniffel.getWuerfel();
		for (int i = 0; i < gleicheWuerfel.length; i++) {
			if(gleicheWuerfel[i] >= index) {
				for (int j = 0; j < 5; j++) {
					punkte+=wuerfel[j];
				}
			}
		}
		return punkte;
	}
	
}
