package kniffel;

public class Main {

	public static void main(String[] args) {
		Kniffel kniffel = new Kniffel();
		KniffelController kc = new KniffelController(kniffel);
		kniffel.setVisible(true);

	}

}
