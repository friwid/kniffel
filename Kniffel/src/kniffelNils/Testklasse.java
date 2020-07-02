package kniffelNils;

public class Testklasse {

	public static void main(String[] args) {
		
		Kniffel knif = new Kniffel();
		KniffelController kc = new KniffelController(knif);
		KniffelRules rules = new KniffelRules(knif);
		knif.setVisible(true);

	}

}
