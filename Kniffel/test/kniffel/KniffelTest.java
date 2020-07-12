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
		regel.einerRegel(new int[] {1,0,6,5,3});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void einerRegelTestInvalid3() throws Exception {
		regel.einerRegel(new int[] {5,1,3,4,7});
	}
	
	// Zweier-Regel
	@Test
	public void zweierRegelTest() throws Exception {
		assertEquals(regel.zweierRegel(new int[] {2,2,2,2,2}),10);
		assertEquals(regel.zweierRegel(new int[] {2,1,3,4,5}),2);
		assertEquals(regel.zweierRegel(new int[] {6,6,6,6,6}),0);
		assertEquals(regel.zweierRegel(new int[] {2,2,2,2,2,2}),10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void zweierRegelTestInvalid1() throws Exception {
		regel.zweierRegel(new int[] {-2,2,2,2,2});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void zweierRegelTestInvalid2() throws Exception {
		regel.zweierRegel(new int[] {2,0,6,5,3});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void zweierRegelTestInvalid3() throws Exception {
		regel.zweierRegel(new int[] {5,2,3,4,7});
	}
	
	// Dreier-Regel
	@Test
	public void dreierRegelTest() throws Exception {
		assertEquals(regel.dreierRegel(new int[] {3,3,3,3,3}),15);
		assertEquals(regel.dreierRegel(new int[] {2,1,3,4,5}),3);
		assertEquals(regel.dreierRegel(new int[] {6,6,6,6,6}),0);
		assertEquals(regel.dreierRegel(new int[] {3,3,3,3,3,3}),15);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierRegelTestInvalid1() throws Exception {
		regel.dreierRegel(new int[] {-3,3,3,3,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierRegelTestInvalid2() throws Exception {
		regel.dreierRegel(new int[] {2,0,6,5,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierRegelTestInvalid3() throws Exception {
		regel.dreierRegel(new int[] {5,2,3,4,7});
	}
	
	// Vierer-Regel
	@Test
	public void viererRegelTest() throws Exception {
		assertEquals(regel.viererRegel(new int[] {4,4,4,4,4}),20);
		assertEquals(regel.viererRegel(new int[] {2,1,3,4,5}),4);
		assertEquals(regel.viererRegel(new int[] {6,6,6,6,6}),0);
		assertEquals(regel.viererRegel(new int[] {4,4,4,4,4,4}),20);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void viererRegelTestInvalid1() throws Exception {
		regel.viererRegel(new int[] {-4,4,4,4,4});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void viererRegelTestInvalid2() throws Exception {
		regel.viererRegel(new int[] {2,0,6,4,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void viererRegelTestInvalid3() throws Exception {
		regel.viererRegel(new int[] {5,2,3,4,7});
	}
	
	// Fünfer-Regel
	@Test
	public void fuenferRegelTest() throws Exception {
		assertEquals(regel.fuenferRegel(new int[] {5,5,5,5,5}),25);
		assertEquals(regel.fuenferRegel(new int[] {2,1,3,4,5}),5);
		assertEquals(regel.fuenferRegel(new int[] {6,6,6,6,6}),0);
		assertEquals(regel.fuenferRegel(new int[] {5,5,5,5,5,5}),25);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void fuenferRegelTestInvalid1() throws Exception {
		regel.fuenferRegel(new int[] {-5,5,5,5,5});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void fuenferRegelTestInvalid2() throws Exception {
		regel.fuenferRegel(new int[] {2,0,6,5,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void fuenferRegelTestInvalid3() throws Exception {
		regel.fuenferRegel(new int[] {5,2,3,4,7});
	}

	// Sechser-Regel
	@Test
	public void sechserRegelTest() throws Exception {
		assertEquals(regel.sechserRegel(new int[] {6,6,6,6,6}),30);
		assertEquals(regel.sechserRegel(new int[] {2,1,3,4,6}),6);
		assertEquals(regel.sechserRegel(new int[] {1,1,1,1,1}),0);
		assertEquals(regel.sechserRegel(new int[] {6,6,6,6,6,6}),30);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void sechserRegelTestInvalid1() throws Exception {
		regel.sechserRegel(new int[] {-6,6,6,6,6});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void sechserRegelTestInvalid2() throws Exception {
		regel.sechserRegel(new int[] {2,0,6,5,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void sechserRegelTestInvalid3() throws Exception {
		regel.sechserRegel(new int[] {6,2,3,4,7});
	}
	
	// Dreierpasch-Regel
	@Test
	public void dreierpaschRegelTest() throws Exception {
		assertEquals(regel.dreierpaschRegel(new int[] {6,6,6,6,6}),30);
		assertEquals(regel.dreierpaschRegel(new int[] {3,3,3,1,6}),16);
		assertEquals(regel.dreierpaschRegel(new int[] {1,1,1,1,1}),5);
		assertEquals(regel.dreierpaschRegel(new int[] {6,6,6,6,6,6}),30);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierpaschRegelTestInvalid1() throws Exception {
		regel.dreierpaschRegel(new int[] {-6,6,6,6,6});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierpaschRegelTestInvalid2() throws Exception {
		regel.dreierpaschRegel(new int[] {2,0,1,1,1});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierpaschRegelTestInvalid3() throws Exception {
		regel.dreierpaschRegel(new int[] {6,6,6,4,7});
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
