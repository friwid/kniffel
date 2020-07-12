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
	public void punktezahlExceptionTest1() throws Exception {
		regel.testPunktezahl(false, 0, 5, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void punktezahlExceptionTest2() throws Exception {
		regel.testPunktezahl(false, 0, 5, 6);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void punktezahlExceptionTest3() throws Exception {
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
	public void einerRegelExceptionTest1() throws Exception {
		regel.einerRegel(new int[] {-1,1,1,1,1});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void einerRegelExceptionTest2() throws Exception {
		regel.einerRegel(new int[] {1,0,6,5,3});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void einerRegelExceptionTest3() throws Exception {
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
	public void zweierRegelExceptionTest1() throws Exception {
		regel.zweierRegel(new int[] {-2,2,2,2,2});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void zweierRegelExceptionTest2() throws Exception {
		regel.zweierRegel(new int[] {2,0,6,5,3});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void zweierRegelExceptionTest3() throws Exception {
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
	public void dreierRegelExceptionTest1() throws Exception {
		regel.dreierRegel(new int[] {-3,3,3,3,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierRegelExceptionTest2() throws Exception {
		regel.dreierRegel(new int[] {2,0,6,5,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierRegelExceptionTest3() throws Exception {
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
	public void viererRegelExceptionTest1() throws Exception {
		regel.viererRegel(new int[] {-4,4,4,4,4});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void viererRegelExceptionTest2() throws Exception {
		regel.viererRegel(new int[] {2,0,6,4,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void viererRegelExceptionTest3() throws Exception {
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
	public void fuenferRegelExceptionTest1() throws Exception {
		regel.fuenferRegel(new int[] {-5,5,5,5,5});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void fuenferRegelExceptionTest2() throws Exception {
		regel.fuenferRegel(new int[] {2,0,6,5,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void fuenferRegelExceptionTest3() throws Exception {
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
	public void sechserRegelExceptionTest1() throws Exception {
		regel.sechserRegel(new int[] {-6,6,6,6,6});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void sechserRegelExceptionTest2() throws Exception {
		regel.sechserRegel(new int[] {2,0,6,5,3});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void sechserRegelExceptionTest3() throws Exception {
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
	public void dreierpaschRegelExceptionTest1() throws Exception {
		regel.dreierpaschRegel(new int[] {-6,6,6,6,6});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierpaschRegelExceptionTest2() throws Exception {
		regel.dreierpaschRegel(new int[] {2,0,1,1,1});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void dreierpaschRegelExceptionTest3() throws Exception {
		regel.dreierpaschRegel(new int[] {6,6,6,4,7});
	}
	
	// Viererpasch-Regel
	@Test
	public void viererpaschRegelTest() throws Exception {
		assertEquals(regel.viererpaschRegel(new int[] {6,6,6,6,6}),30);
		assertEquals(regel.viererpaschRegel(new int[] {3,3,3,3,6}),18);
		assertEquals(regel.viererpaschRegel(new int[] {1,1,1,1,1}),5);
		assertEquals(regel.viererpaschRegel(new int[] {6,6,6,6,6,6}),30);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void viererpaschRegelExceptionTest1() throws Exception {
		regel.viererpaschRegel(new int[] {-6,6,6,6,6});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void viererpaschRegelExceptionTest2() throws Exception {
		regel.viererpaschRegel(new int[] {1,0,1,1,1});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void viererpaschRegelExceptionTest3() throws Exception {
		regel.viererpaschRegel(new int[] {6,6,6,6,7});
	}
	
	// FullHouse-Regel
	@Test
	public void fullhouseRegelTest() throws Exception {
		assertEquals(regel.fullhouseRegel(new int[] {6,6,6,1,1}),25);
		assertEquals(regel.fullhouseRegel(new int[] {1,1,1,1,1}),0);
		assertEquals(regel.fullhouseRegel(new int[] {1,1,6,6,6,6}),25);
		assertEquals(regel.fullhouseRegel(new int[] {6,6,6,6,1,1}),0);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void fullhouseRegelExceptionTest1() throws Exception {
		regel.fullhouseRegel(new int[] {-5,5,6,6,6});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void fullhouseRegelExceptionTest2() throws Exception {
		regel.fullhouseRegel(new int[] {0,0,1,1,1});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void fullhouseRegelExceptionTest3() throws Exception {
		regel.fullhouseRegel(new int[] {6,6,6,7,7});
	}
	
	// KleineStraße-Regel
	@Test
	public void kstrasseRegelTest() throws Exception {
		assertEquals(regel.kstrasseRegel(new int[] {1,2,3,4,5}),30);
		assertEquals(regel.kstrasseRegel(new int[] {2,3,4,5,6}),30);
		assertEquals(regel.kstrasseRegel(new int[] {1,3,5,4,6}),30);
		assertEquals(regel.kstrasseRegel(new int[] {1,3,6,4,6}),0);
		assertEquals(regel.kstrasseRegel(new int[] {2,2,3,4,5,6}),30);
		assertEquals(regel.kstrasseRegel(new int[] {6,6,1,2,3,4}),0);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void kstrasseRegelExceptionTest1() throws Exception {
		regel.kstrasseRegel(new int[] {-1,2,3,4,5});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void kstrasseRegelExceptionTest2() throws Exception {
		regel.kstrasseRegel(new int[] {0,1,2,3,4});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void kstrasseRegelExceptionTest3() throws Exception {
		regel.kstrasseRegel(new int[] {3,4,5,6,7});
	}
	
	// GroßeStraße-Regel
	@Test
	public void gstrasseRegelTest() throws Exception {
		assertEquals(regel.gstrasseRegel(new int[] {1,2,3,4,5}),40);
		assertEquals(regel.gstrasseRegel(new int[] {2,3,4,5,6}),40);
		assertEquals(regel.gstrasseRegel(new int[] {1,2,3,4,6}),0);
		assertEquals(regel.gstrasseRegel(new int[] {1,2,3,4,5,6}),40);
		assertEquals(regel.gstrasseRegel(new int[] {6,1,2,3,4,5}),0);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void gstrasseRegelExceptionTest1() throws Exception {
		regel.gstrasseRegel(new int[] {-1,2,3,4,5});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void gstrasseRegelExceptionTest2() throws Exception {
		regel.gstrasseRegel(new int[] {0,1,2,3,4});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void gstrasseRegelExceptionTest3() throws Exception {
		regel.gstrasseRegel(new int[] {3,4,5,6,7});
	}
	
	// Kniffel-Regel
	@Test
	public void kniffelRegelTest() throws Exception {
		assertEquals(regel.kniffelRegel(new int[] {1,1,1,1,1}),50);
		assertEquals(regel.kniffelRegel(new int[] {6,6,6,6,6}),50);
		assertEquals(regel.kniffelRegel(new int[] {1,6,6,6,6}),0);
		assertEquals(regel.kniffelRegel(new int[] {3,3,3,3,3,3}),50);
		assertEquals(regel.kniffelRegel(new int[] {1,3,3,3,3,3}),0);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void kniffelRegelExceptionTest1() throws Exception {
		regel.kniffelRegel(new int[] {-1,-1,-1,-1,-1});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void kniffelRegelExceptionTest2() throws Exception {
		regel.kniffelRegel(new int[] {0,0,0,0,0});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void kniffelRegelExceptionTest3() throws Exception {
		regel.kniffelRegel(new int[] {7,7,7,7,7});
	}
	
	// Chance-Regel
	@Test
	public void chanceRegelTest() throws Exception {
		assertEquals(regel.chanceRegel(new int[] {1,1,1,1,1}),5);
		assertEquals(regel.chanceRegel(new int[] {6,6,6,6,6}),30);
		assertEquals(regel.chanceRegel(new int[] {1,2,3,5,5}),16);
		assertEquals(regel.chanceRegel(new int[] {1,2,3,4,5,6}),15);
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void chanceRegelExceptionTest1() throws Exception {
		regel.chanceRegel(new int[] {-1,1,2,3,6});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void chanceRegelExceptionTest2() throws Exception {
		regel.chanceRegel(new int[] {2,0,4,4,2});
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void chanceRegelExceptionTest3() throws Exception {
		regel.chanceRegel(new int[] {6,2,1,4,7});
	}


}
