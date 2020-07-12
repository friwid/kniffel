package kniffel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KniffelTest {
	
	private Kniffel kniffel;
	private KniffelController kc;
	private Rules regel;
	
	@Before
	public void setup() throws  Exception {
		kniffel = new Kniffel();
		kc = new KniffelController(kniffel);
		regel = new Rules(kniffel);
	}
		
	// Würfeln
	@Test
	public void wuerfelnTest() throws Exception {
		for(int i = 0; i < 100; i++) {
			kc.wuerfeln();
			for (int j = 0; j <5; j++) {	
				assertTrue(kc.wuerfel[j] == 1 || kc.wuerfel[j] == 2 || kc.wuerfel[j] == 3 || kc.wuerfel[j] == 4 || kc.wuerfel[j] == 5 || kc.wuerfel[j] == 6);
			}
		}
	
	}
	
	// Punktezahl
	@Test
	public void punktezahlTest() throws Exception {
		regel.testPunktezahl(false, 0, 5, 0);
		regel.testPunktezahl(false, 0, 5, 3);
		regel.testPunktezahl(false, 0, 5, 5);
		regel.testPunktezahl(true, 0, 5, 0);
		regel.testPunktezahl(true, 0, 5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void punktezahlTestInvalid1() throws Exception {
		regel.testPunktezahl(false, 0, 5, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void punktezahlTestInvalid2() throws Exception {
		regel.testPunktezahl(false, 0, 5, 6);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void punktezahlTestInvalid3() throws Exception {
		regel.testPunktezahl(true, 0, 5, 3);
	}

	
	// Einer-Regel
	@Test
	public void einerRegelTest() throws Exception {
		assertEquals(regel.einerRegel(new int[] {1,1,1,1,1}),5);
		assertEquals(regel.einerRegel(new int[] {1,2,3,4,5}),1);
		assertEquals(regel.einerRegel(new int[] {6,6,6,6,6}),0);
		assertEquals(regel.einerRegel(new int[] {1,1,1,1,1,1}),5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void einerRegelTestInvalid1() throws Exception {
		regel.einerRegel(new int[] {-1,1,1,1,1});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void einerRegelTestInvalid2() throws Exception {
		regel.einerRegel(new int[] {2,0,6,5,3});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void einerRegelTestInvalid3() throws Exception {
		regel.einerRegel(new int[] {5,2,3,4,7});
	}

	
	
/*
@Test
public void testWuerfeln() throws Exception {

}

@Test(expected = IllegalArgumentException.class)
public void testWuerfeln() throws Exception {

}
 */
}
