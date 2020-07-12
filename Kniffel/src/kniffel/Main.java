/**
 * Kniffel mit User Interface
 *
 * @author Atakan Ata (1911877), Nils Rekus ‌(1826514), Frieder Widmann (1911820)

 */
package kniffel;

public class Main {

	public static void main(String[] args) {
		Kniffel kniffel = new Kniffel();
		KniffelController kc = new KniffelController(kniffel);
		kniffel.setVisible(true);

	}

}
