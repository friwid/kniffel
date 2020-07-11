package kniffel;

import static org.junit.Assert.*;

import org.junit.Test;

public class KniffelTest {
	
	Kniffel  kniffel;
			
	@Test
	public void testWuerfelnValid() throws Exception {
		KniffelController test = new KniffelController(kniffel);
		for(int i = 0; i <= 100; i++) {
			test.wuerfeln();
			for (int j = 0; j <= 5; j++) {	
				assertTrue(test.wuerfel[j] == 1 || test.wuerfel[j] == 2 || test.wuerfel[j] == 3 || test.wuerfel[j] == 4 || test.wuerfel[j] == 5 || test.wuerfel[j] == 6);
			}
		}
	
	}
	
	
	
/*
@Test
public void testWuerfeln() throws Exception {

}

@Test(expected=IllegalArgumentException.class)
public void testWuerfeln() throws Exception {

}
 */
}
