package kniffelNils;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Kniffel extends JFrame{

		JButton wuerfeln,beenden,eintragen;
		JToggleButton w1,w2,w3,w4,w5;
		JLabel l1,l2,l3,l4,l5;
		JRadioButton einer,zweier,dreier,vierer,fuenfer,sechser,dreierpasch,viererpasch,fullHouse,kStrasse,gStrasse,kniffel,chance;
		JTable table;
		DefaultTableModel model;
		int[]wuerfel = new int[5];
		
		
		Kniffel(){
			
			//Fenster Titel
			setTitle("Kniffel");
			
			//Layout für das Spielfeld festlegen
			setLayout(new BorderLayout());
			
			//Größe des Spielfeldes festlegen
			setSize(600,500);
//			setResizable(false);
			
			
			
			//JPanal für die "Steuerknöpfe" anlegen und Layout festlegen
			JPanel south = new JPanel();
			south.setLayout(new FlowLayout());

			//"Steuerknöpfe" anlegen, benennen und dem JPanal hinzufügen
			wuerfeln = new JButton("würfeln");
			south.add(wuerfeln);
			
			beenden = new JButton("Spiel Beenden");
			south.add(beenden);
			
			eintragen = new JButton("Eintragen");
			south.add(eintragen);
			
			//JPanal mit "Steuerknöpfen" dem Spielfeld hinzufügen
			add(south,BorderLayout.SOUTH);
			
			
			
			//JPanal mit Labels und ToggleButton anlegen, Layout festlegen
			JPanel center = new JPanel();
			center.setLayout(new GridLayout(2,5));
			
			//JLabels anlegen und JPanel hinzufügen
			l1 = new JLabel();
			center.add(l1);
			
			l2 = new JLabel();
			center.add(l2);
			
			l3 = new JLabel();
			center.add(l3);
			
			l4 = new JLabel();
			center.add(l4);
			
			l5 = new JLabel();
			center.add(l5);
			
			//Würfel anlegen, Inhalt des Arrayindex als Namen verwenden und dem JPanal hinzufügen
			w1 = new JToggleButton("---");
			center.add(w1);
			
			w2 = new JToggleButton("---");
			center.add(w2);
			
			w3 = new JToggleButton("---");
			center.add(w3);
			
			w4 = new JToggleButton("---");
			center.add(w4);
			
			w5 = new JToggleButton("---");
			center.add(w5);
			
			//JPanal mit Würfeln dem Spielfeld hinzufügen
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
			
			fuenfer = new JRadioButton("Fünfer");
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
			
			kStrasse = new JRadioButton("kleine Straße");
			bg.add(kStrasse);
			west.add(kStrasse);
			
			gStrasse = new JRadioButton("große Straße");
			bg.add(gStrasse);
			west.add(gStrasse);
			
			kniffel = new JRadioButton("Kniffel");
			bg.add(kniffel);
			west.add(kniffel);
			
			chance = new JRadioButton("Chance");
			bg.add(chance);
			west.add(chance);
			
			//JPanel mit CheckBoxen Spielfeld hinzufügen
			add(west,BorderLayout.WEST);
						
			
			
			//JPanel mit Tabelle anlegen und Layout festlegen
			JPanel east = new JPanel();
			east.setLayout(new FlowLayout());
			
			//Tabelle erstellen, Zeilen/Spalten angeben und JPanel hinzufügen
			model = new DefaultTableModel(20,2);
			table = new JTable(model);
			
			east.add(table);
			
			//JPanel mit Tabelle dem Spielfeld hinzufügen
			add(east,BorderLayout.EAST);
			
			wuerfel[0] = 0;
			wuerfel[1] = 0;
			wuerfel[2] = 0;
			wuerfel[3] = 0;
			wuerfel[4] = 0;
			
			
			//Bildschirmposition des Fensters
			setLocationRelativeTo(null);
			
			
		}
		
	
	

	public static void main(String[] args) {
		
		Kniffel kniffel = new Kniffel();
		KniffelController kc = new KniffelController(kniffel);
		KniffelRules rules = new KniffelRules(kniffel);
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




	public JLabel getL1() {
		return l1;
	}




	public void setL1(JLabel l1) {
		this.l1 = l1;
	}




	public JLabel getL2() {
		return l2;
	}




	public void setL2(JLabel l2) {
		this.l2 = l2;
	}




	public JLabel getL3() {
		return l3;
	}




	public void setL3(JLabel l3) {
		this.l3 = l3;
	}




	public JLabel getL4() {
		return l4;
	}




	public void setL4(JLabel l4) {
		this.l4 = l4;
	}




	public JLabel getL5() {
		return l5;
	}




	public void setL5(JLabel l5) {
		this.l5 = l5;
	}
	
	
	
	public JRadioButton getEiner() {
		return einer;
	}




	public JRadioButton getZweier() {
		return zweier;
	}




	public JRadioButton getDreier() {
		return dreier;
	}




	public JRadioButton getVierer() {
		return vierer;
	}




	public JRadioButton getFuenfer() {
		return fuenfer;
	}




	public JRadioButton getSechser() {
		return sechser;
	}




	public JRadioButton getDreierpasch() {
		return dreierpasch;
	}




	public JRadioButton getViererpasch() {
		return viererpasch;
	}




	public JRadioButton getFullHouse() {
		return fullHouse;
	}




	public JRadioButton getkStrasse() {
		return kStrasse;
	}




	public JRadioButton getgStrasse() {
		return gStrasse;
	}




	public JRadioButton getKniffel() {
		return kniffel;
	}




	public JRadioButton getChance() {
		return chance;
	}




	public JTable getTable() {
		return table;
	}




	public DefaultTableModel getModel() {
		return model;
	}
}