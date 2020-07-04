package kniffelAtakan;
import java.util.Arrays;

/**
 * @author Nils
 * Alle Regeln des Spiels "Kniffel" in einer eigenen Klasse
 *  
 */


public class KniffelRules {
	
		Kniffel kniffel;
	
		KniffelRules(Kniffel kniffel){
			this.kniffel = kniffel;
		}
				public static void main (String[]args) {
					
				}

		public int einerRegel() {
			int punkte = 0;
			int [] wuerfel = kniffel.getWuerfel();			
			Arrays.sort(wuerfel);
			int anz1er = 0;
			for (int i = 0; i < wuerfel.length; i++) {
				if(wuerfel[i] == 1)
					anz1er++;
			}
			punkte = anz1er;
			return punkte;
		}
		
		public int zweierRegel() {
			int punkte = 0;
			int [] wuerfel = kniffel.getWuerfel();
			Arrays.sort(wuerfel);
			int anz2er = 0;
			for (int i = 0; i < wuerfel.length; i++) {
				if(wuerfel[i] == 2)
					anz2er++;
			}
			punkte = anz2er*2;
			return punkte;
		}
		
		public int dreierRegel() {
			int punkte = 0;
			int [] wuerfel = kniffel.getWuerfel();
			Arrays.sort(wuerfel);
			int anz3er = 0;
			for (int i = 0; i < wuerfel.length; i++) {
				if(wuerfel[i] == 3)
					anz3er++;
			}
			punkte = anz3er*3;
			return punkte;
		}
		
		public int viererRegel() {
			int punkte = 0;
			int [] wuerfel = kniffel.getWuerfel();
			Arrays.sort(wuerfel);
			int anz4er = 0;
			for (int i = 0; i < wuerfel.length; i++) {
				if(wuerfel[i] == 4)
					anz4er++;
			}
			punkte = anz4er*4;
			return punkte;
		}
		
		public int fuenferRegel() {
			int punkte = 0;
			int [] wuerfel = kniffel.getWuerfel();
			Arrays.sort(wuerfel);
			int anz5er = 0;
			for (int i = 0; i < wuerfel.length; i++) {
				if(wuerfel[i] == 5)
					anz5er++;
			}
			punkte = anz5er*5;
			return punkte;
		}
		
		public int sechserRegel() {
			int punkte = 0;
			int [] wuerfel = kniffel.getWuerfel();
			Arrays.sort(wuerfel);
			int anz6er = 0;
			for (int i = 0; i < wuerfel.length; i++) {
				if(wuerfel[i] == 6)
					anz6er++;
			}
			punkte = anz6er*6;
			return punkte;
		}
		
		public int dreierpaschRegel() {
			int punkte = 0;
			int[]wuerfel = kniffel.getWuerfel();
			Arrays.sort(wuerfel);
			int gleicheWuerfel = 0;
			for (int i = 0; i < wuerfel.length; i++)
			{
				for (int j = i+1; j < wuerfel.length; j++)
				{
					for (int k = j+1; k < wuerfel.length; k++)
					{
						if(i!=j && j!=k && wuerfel[i] == wuerfel[j] && wuerfel[j] == wuerfel[k])
						{	
							
						}
					
						
					}
				}
				
			}
			
			
			return punkte;
		}
		
		public int viererpaschRegel()
		{
			int punkte = 0;
						
			return punkte;
		}
		
		
		public int fullhouseRegel()
		{
			int punkte = 0;
			int[]wuerfel = kniffel.getWuerfel();
			Arrays.sort(wuerfel);
			for (int i = 0; i < wuerfel.length; i++) {
				
			}
			
			punkte = 25;
			return punkte;
		}
		
		
		
		public int kniffelRegel()
		{
			int punkte = 0;
			int[]wuerfel = kniffel.getWuerfel();
			int equal = 0;
			for (int i = 1; i < wuerfel.length; i++)
			{
				if(wuerfel[i-1] == wuerfel[i])
				{
					equal++;
				}
			}
			if(equal == 4)
			{
				punkte = 50;
			}
			else
			{
				punkte = 0;
			}
			return punkte;
		}
		
		public int chanceRegel()
		{
			int punkte = 0;
			int[]wuerfel = kniffel.getWuerfel();
			for (int i = 0; i < wuerfel.length; i++)
			{
				punkte += wuerfel[i];
			}						
			return punkte;
		}
	
}