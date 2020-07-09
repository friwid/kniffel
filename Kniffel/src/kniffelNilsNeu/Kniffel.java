package kniffelNilsNeu;
import java.awt.*;

import javax.swing.*;

public class Kniffel extends JFrame {

	JButton close,newGame,eintragen,roll;
	JPanel south,west,center,east,north;
	JLabel[]labels = new JLabel[5];
	int[]wuerfel = new int[5];
	JToggleButton[] tBtn = new JToggleButton[5];
	JRadioButton[]rBtn = new JRadioButton[13];
	ButtonGroup btnGrp;
	JTable table;
	String[] rBtnNames = {"Einer","Zweier","Dreier","Vierer","F¸nfer","Sechser","Dreierpasch","Viererpasch","FullHouse"
			,"kleine Straﬂe","groﬂe Straﬂe","Kniffel","Chance"};
	String[]fieldNames = {"Einer","Zweier","Dreier","Vierer","F¸nfer","Sechser","Summe Oben","Bonus","Gesamt Oben","Dreierpasch","Viererpasch","FullHouse"
			,"kleine Straﬂe","groﬂe Straﬂe","Kniffel","Chance","Summe unten","Summe oben","Gesamtsumme"};
	Kniffel(){
		
		setLayout(new BorderLayout());
		setSize(500,500);
		setTitle("Kniffel");
		setResizable(false);
		
		south = new JPanel(new FlowLayout());
		
		close = new JButton("Fenster schlieﬂen");
		south.add(close);
		newGame = new JButton("Neues Spiel");
		south.add(newGame);
		eintragen = new JButton("Eintragen");
		eintragen.setEnabled(false);
		south.add(eintragen);
		roll = new JButton("w¸rfeln");
		south.add(roll);
		add(south,BorderLayout.SOUTH);
		
		
		west = new JPanel(new GridLayout(13, 1));
		btnGrp = new ButtonGroup();
		for (int i = 0; i < rBtn.length; i++) {
			rBtn[i] = new JRadioButton(rBtnNames[i]);
			btnGrp.add(rBtn[i]);
			west.add(rBtn[i]);
		}
		add(west,BorderLayout.WEST);
		
		center = new JPanel(new GridLayout(2,5));
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(String.valueOf(wuerfel[i]));
			center.add(labels[i]);
		}
		for (int i = 0; i < tBtn.length; i++) {
			tBtn[i] = new JToggleButton("---");
			tBtn[i].setEnabled(false);
			center.add(tBtn[i]);
		}
		
		add(center,BorderLayout.CENTER);
		
		east = new JPanel(new FlowLayout());
		table = new JTable(20,2);
		table.setValueAt("Spiel", 0, 0);
		table.setValueAt("Punkte", 0, 1);
		for (int i = 0; i < fieldNames.length; i++) {
			table.setValueAt(fieldNames[i],i+1,0);
		}
		east.add(table);
		add(east,BorderLayout.EAST);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public JButton getClose() {
		return close;
	}

	public void setClose(JButton close) {
		this.close = close;
	}

	public JButton getNewGame() {
		return newGame;
	}

	public void setNewGame(JButton newGame) {
		this.newGame = newGame;
	}

	public JButton getEintragen() {
		return eintragen;
	}

	public void setEintragen(JButton eintragen) {
		this.eintragen = eintragen;
	}
	
	public JButton getRoll() {
		return roll;
	}
	
	public void setRoll(JButton roll) {
		this.roll = roll;
	}
	public JPanel getSouth() {
		return south;
	}

	public void setSouth(JPanel south) {
		this.south = south;
	}

	public JPanel getWest() {
		return west;
	}

	public void setWest(JPanel west) {
		this.west = west;
	}

	public JPanel getCenter() {
		return center;
	}

	public void setCenter(JPanel center) {
		this.center = center;
	}

	public JPanel getEast() {
		return east;
	}

	public void setEast(JPanel east) {
		this.east = east;
	}

	public JPanel getNorth() {
		return north;
	}

	public void setNorth(JPanel north) {
		this.north = north;
	}

	public JLabel[] getLabels() {
		return labels;
	}

	public void setLabels(JLabel[] labels) {
		this.labels = labels;
	}

	public int[] getWuerfel() {
		return wuerfel;
	}

	public void setWuerfel(int[] wuerfel) {
		this.wuerfel = wuerfel;
	}

	public JToggleButton[] gettBtn() {
		return tBtn;
	}

	public void settBtn(JToggleButton[] tBtn) {
		this.tBtn = tBtn;
	}

	public JRadioButton[] getrBtn() {
		return rBtn;
	}

	public void setrBtn(JRadioButton[] rBtn) {
		this.rBtn = rBtn;
	}

	public String[] getrBtnNames() {
		return rBtnNames;
	}

	public void setrBtnNames(String[] rBtnNames) {
		this.rBtnNames = rBtnNames;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ButtonGroup getBtnGrp() {
		return btnGrp;
	}

	public void setBtnGrp(ButtonGroup btnGrp) {
		this.btnGrp = btnGrp;
	}
	
}
