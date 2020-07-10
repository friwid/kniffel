package kniffelFriederNeu;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;

public class Kniffel extends JFrame {

	JButton close,newGame,eintragen,roll;
	JPanel south,west,center,east,north,eastNumbers,eastButtons;
	JLabel[]labels = new JLabel[5];
	int[]wuerfel = new int[5];
	JToggleButton[] tBtn = new JToggleButton[5];
	JRadioButton[]rBtn = new JRadioButton[13];
	ButtonGroup btnGrp;
	JTable table;
	String[] rBtnNames = {"Einer","Zweier","Dreier","Vierer","Fünfer","Sechser","Dreierpasch","Viererpasch","FullHouse"
			,"Kleine Straße","Große Straße","Kniffel","Chance"};
	String[]fieldNames = {" Einer"," Zweier"," Dreier"," Vierer"," Fünfer"," Sechser","   Summe Oben","   Bonus","   Gesamt Oben"," Dreierpasch"," Viererpasch"," FullHouse"
			," Kleine Straße"," Große Straße"," Kniffel"," Chance","   Summe unten","   Summe oben","   Gesamtsumme"};
	String[]fieldDescriptions = {" Nur Einer zählen"," Nur Zweier zählen"," Nur Dreier zählen"," Nur Vierer zählen"," Nur Fünfer zählen"," Nur Sechser zählen",""
			," 35 Punkte, wenn oben mindestens 63 Punkte",""," Drei gleiche Zahlen – Alle Augen zählen"," Vier gleiche Zahlen – Alle Augen zählen"
			," Drei gleiche und zwei gleiche, andere Zahlen – 25 Punkte"," 1-2-3-4, 2-3-4-5, oder 3-4-5-6 – 30 Punkte"," 1-2-3-4-5 oder 2-3-4-5-6 – 40 Punkte"
			," Fünf gleiche Zahlen – 50 Punkte"," Alle Augen zählen","",""," Summe Oben + Bonus + Summe Unten"};
	//Icon iconOpen = "open.png";
	//Icon IconLocked = "locked.png";
	Kniffel(){
		
		setLayout(new BorderLayout());
		//setSize(900,500);
		setTitle("Kniffel");
		setResizable(false);
		
		// FlowLayout SOUTH
		south = new JPanel(new FlowLayout());
		
		close = new JButton("Fenster schließen");
		south.add(close);
		newGame = new JButton("Neues Spiel");
		south.add(newGame);
		eintragen = new JButton("Eintragen");
		eintragen.setEnabled(false);
		south.add(eintragen);
		roll = new JButton("würfeln");
		south.add(roll);
		
		add(south,BorderLayout.SOUTH);
		
		// FlowLayout WEST
		west = new JPanel(new GridLayout(13, 1));
		
		btnGrp = new ButtonGroup();
		for (int i = 0; i < rBtn.length; i++) {
			rBtn[i] = new JRadioButton(rBtnNames[i]);
			btnGrp.add(rBtn[i]);
			west.add(rBtn[i]);
		}
		
		add(west,BorderLayout.WEST);
		
		// FlowLayout CENTER
		center = new JPanel(new FlowLayout());
		
		table = new JTable(20,3);
		table.setValueAt(" Spiel", 0, 0);
		table.setValueAt(" Punkte", 0, 1);
		table.setValueAt(" Anmerkungen", 0, 2);
		for (int i = 0; i < fieldNames.length; i++) {
			table.setValueAt(fieldNames[i],i+1,0);
		}
		for (int i = 0; i < fieldDescriptions.length; i++) {
			table.setValueAt(fieldDescriptions[i],i+1,2);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(330);
		table.setEnabled(false);
		center.add(table);
		
		add(center,BorderLayout.CENTER);
		
		// FlowLayout EAST
		east = new JPanel(new GridLayout(2, 1));
		eastNumbers = new JPanel(new FlowLayout()); 
		eastButtons = new JPanel(new FlowLayout());
		
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(String.valueOf(wuerfel[i]));
			eastNumbers.add(labels[i]);
		}
		for (int i = 0; i < tBtn.length; i++) {
			try {
				tBtn[i] = createButton();
			} catch (IOException exception) {
                exception.printStackTrace();
            }
			tBtn[i].setPreferredSize(new Dimension(40, 40));
			tBtn[i].setEnabled(false);
			eastButtons.add(tBtn[i]);
		}
		east.add(eastNumbers);
		east.add(eastButtons);
		add(east,BorderLayout.EAST);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}

	protected JToggleButton createButton() throws IOException {

        JToggleButton btn = new JToggleButton();
        btn.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("open.png"))));
        btn.setSelectedIcon(new ImageIcon(ImageIO.read(getClass().getResource("locked.png"))));
        return btn;

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
