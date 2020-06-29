package kniffelNils;
import java.awt.*;
import javax.swing.*;

public class Kniffel extends JFrame{

		JButton wuerfeln,beenden,eintragen;
		JButton w1,w2,w3,w4,w5;
		JRadioButton einer,zweier,dreier,vierer,fuenfer,sechser,dreierpasch,viererpasch,fullHouse,kStrasse,gStrasse,kniffel,chance;
		JTable table;
		int[]wuerfel = new int[5];
		int anzWuerfe;
		
		Kniffel(){
			
			//Fenster Titel
			setTitle("Kniffel");
			
			//Layout f�r das Spielfeld festlegen
			setLayout(new BorderLayout());
			
			//Gr��e des Spielfeldes festlegen
			setSize(600,500);
//			setResizable(false);
			
			
			
			//JPanal f�r die "Steuerkn�pfe" anlegen und Layout festlegen
			JPanel south = new JPanel();
			south.setLayout(new FlowLayout());

			//"Steuerkn�pfe" anlegen, benennen und dem JPanal hinzuf�gen
			wuerfeln = new JButton("w�rfeln");
			south.add(wuerfeln);
			
			beenden = new JButton("Spiel Beenden");
			south.add(beenden);
			
			eintragen = new JButton("Eintragen");
			south.add(eintragen);
			
			//JPanal mit "Steuerkn�pfen" dem Spielfeld hinzuf�gen
			add(south,BorderLayout.SOUTH);
			
			
			
			//JPanal mit W�rfeln als Kn�pfe anlegen und Layout festlegen
			JPanel center = new JPanel();
			center.setLayout(new GridBagLayout());
			
			//W�rfel anlegen, Inhalt des Arrayindex als Namen verwenden und dem JPanal hinzuf�gen
			w1 = new JButton(String.valueOf(wuerfel[0]));
			center.add(w1);
			
			w2 = new JButton(String.valueOf(wuerfel[1]));
			center.add(w2);
			
			w3 = new JButton(String.valueOf(wuerfel[2]));
			center.add(w3);
			
			w4 = new JButton(String.valueOf(wuerfel[3]));
			center.add(w4);
			
			w5 = new JButton(String.valueOf(wuerfel[4]));
			center.add(w5);
			
			//JPanal mit W�rfeln dem Spielfeld hinzuf�gen
			add(center,BorderLayout.CENTER);
			
			
			
			//JPanel mit Checkboxen anlegen und Layout festlegen
			JPanel west = new JPanel();
			ButtonGroup bg = new ButtonGroup();
			west.setLayout(new GridLayout(13,1));
			
			//CheckBoxen anlegen und benennen
			einer = new JRadioButton("Einer");
			bg.add(einer);
			west.add(einer);
			
			zweier = new JRadioButton("Zweier");
			bg.add(zweier);
			west.add(zweier);
			
			dreier = new JRadioButton("Dreier");
			bg.add(dreier);
			west.add(dreier);
			
			vierer = new JRadioButton("Vierer");
			bg.add(vierer);
			west.add(vierer);
			
			fuenfer = new JRadioButton("F�nfer");
			bg.add(fuenfer);
			west.add(fuenfer);
			
			sechser = new JRadioButton("Sechser");
			bg.add(sechser);
			west.add(sechser);
			
			dreierpasch = new JRadioButton("Dreierpasch");
			bg.add(dreierpasch);
			west.add(dreierpasch);
			
			viererpasch = new JRadioButton("Viererpasch");
			bg.add(viererpasch);
			west.add(viererpasch);
			
			fullHouse = new JRadioButton("Full House");
			bg.add(fullHouse);
			west.add(fullHouse);
			
			kStrasse = new JRadioButton("kleine Stra�e");
			bg.add(kStrasse);
			west.add(kStrasse);
			
			gStrasse = new JRadioButton("gro�e Stra�e");
			bg.add(gStrasse);
			west.add(gStrasse);
			
			kniffel = new JRadioButton("Kniffel");
			bg.add(kniffel);
			west.add(kniffel);
			
			chance = new JRadioButton("Chance");
			bg.add(chance);
			west.add(chance);
			
			//JPanel mit CheckBoxen Spielfeld hinzuf�gen
			add(west,BorderLayout.WEST);
						
			
			
			//JPanel mit Tabelle anlegen und Layout festlegen
			JPanel east = new JPanel();
			east.setLayout(new FlowLayout());
			
			//Tabelle erstellen, Zeilen/Spalten angeben und JPanel hinzuf�gen
			table = new JTable(20,2);
			east.add(table);
			
			//JPanel mit Tabelle dem Spielfeld hinzuf�gen
			add(east,BorderLayout.EAST);
			
			
			//Bildschirmposition des Fensters
			setLocationRelativeTo(null);
			
			
		}
		
	
	

	public static void main(String[] args) {
		
		Kniffel kniffel = new Kniffel();
		KniffelController kc = new KniffelController(kniffel);
		kniffel.setVisible(true);

	}
	//
	// Ab hier besteht das Programm nurnoch aus Accessor Methoden 
	//
	public JButton getWuerfeln() {
		return wuerfeln;
	}



	public void setWuerfeln(JButton wuerfeln) {
		this.wuerfeln = wuerfeln;
	}



	public JButton getBeenden() {
		return beenden;
	}



	public void setBeenden(JButton beenden) {
		this.beenden = beenden;
	}

	
	
	public JButton getEintragen() {
		return eintragen;
	}



	public void setEintragen(JButton eintragen) {
		this.eintragen = eintragen;
	}

	
	
	public int[] getWuerfel() {
		return wuerfel;
	}




	public void setWuerfel(int[] wuerfel) {
		this.wuerfel = wuerfel;
	}




	public JButton getW1() {
		return w1;
	}



	public void setW1(JButton w1) {
		this.w1 = w1;
	}



	public JButton getW2() {
		return w2;
	}



	public void setW2(JButton w2) {
		this.w2 = w2;
	}



	public JButton getW3() {
		return w3;
	}



	public void setW3(JButton w3) {
		this.w3 = w3;
	}



	public JButton getW4() {
		return w4;
	}



	public void setW4(JButton w4) {
		this.w4 = w4;
	}



	public JButton getW5() {
		return w5;
	}



	public void setW5(JButton w5) {
		this.w5 = w5;
	}

}