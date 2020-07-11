package kniffel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;

public class KniffelController extends WindowAdapter implements ActionListener {

	Kniffel window;
	Rules regel;
	JButton close, neuesSpiel, eintragen, wuerfeln;
	JToggleButton[] tBtn;
	JLabel[] labels;
	JRadioButton[] rBtn;
	ButtonGroup btngrp;
	JTable table;
	int[] wuerfel = new int[5];
	int anzWuerfe;
	int obererBlock,bonus,summeOben,summe,untererBlock;
	Boolean spielGestartet = false;

	KniffelController(Kniffel window) {
		this.window = window;
		window.addWindowListener(this);
		regel = new Rules(window);
		neuesSpiel = window.getNeuesSpiel();
		neuesSpiel.addActionListener(this);
		close = window.getClose();
		close.addActionListener(this);
		eintragen = window.getEintragen();
		eintragen.addActionListener(this);
		wuerfeln = window.getWuerfeln();
		wuerfeln.addActionListener(this);
		tBtn = window.gettBtn();
		btngrp = window.getBtnGrp();
		labels = window.getLabels();
		for (int i = 0; i < tBtn.length; i++) {
			tBtn[i].addActionListener(this);
		}
		wuerfel = window.getWuerfel();
		anzWuerfe = 0;
		rBtn = window.getrBtn();
		for (int i = 0; i < rBtn.length; i++) {
			rBtn[i].addActionListener(this);
		}
		table = window.getTable();
	}
	
	// Beenden-Dialog, falls Spiel bereits gestartet wurde
		private void schliessenDialog() {
			if (!spielGestartet) {
				System.exit(0);
			} else {
				int result = JOptionPane.showOptionDialog(
						window, 
						"Das Spiel ist noch im Gange. Dennoch beenden?", 
						"Programm beenden", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						new String[] { "Beenden", "Abbrechen" }, 
						JOptionPane.NO_OPTION
				);
				if (result == 0) {
					System.exit(0);
				}
			}
		}
	
	
	public void wuerfeln() {
		spielGestartet = true;
		anzWuerfe++;
		for (int i = 0; i < 5; i++) {
			if (!tBtn[i].isSelected()) {
				wuerfel[i] = (int) (6 * Math.random() + 1);
				if (wuerfel[i] < 1 || wuerfel[i] > 6) {
					throw new IllegalArgumentException("Würfelzahl <1 oder >6: " + wuerfel[i]);
				}
				labels[i].setText(String.valueOf(wuerfel[i]));
			}
		}
		if(anzWuerfe == 1) {
			for (int k = 0; k < labels.length; k++) {
					tBtn[k].setEnabled(true);
			}	
				eintragen.setEnabled(true);
		}
		else if(anzWuerfe == 3) {
			for (int k = 0; k < labels.length; k++) {
				tBtn[k].setEnabled(false);
			}
			wuerfeln.setEnabled(false);
		}
	}
	
	// Hilfsmethode, die die Würfelanzeige und Würfelbuttons resettet.
	private void resetWuerfel(int rBtnIndex) {
		rBtn[rBtnIndex].setEnabled(false);
		eintragen.setEnabled(false);
		btngrp.clearSelection();
		wuerfeln.setEnabled(true);
		for (int i = 0; i < 5; i++) {
			tBtn[i].setSelected(false);
			tBtn[i].setEnabled(false);
			labels[i].setText("-");
		}
		anzWuerfe = 0;
	}
	
	// Hilfsmethode, die die Summen im oberen Block aktualisiert.
	private void updateSummeObererBlock(int punkte) {
		if (punkte < 0 || punkte > 32) {
			throw new IllegalArgumentException("Punktezahl <0 oder >30: " + punkte);
		}
		obererBlock += punkte;
		if(obererBlock >= 63 && bonus == 0) {
			bonus = 35;
			summeOben = obererBlock + bonus;
			table.setValueAt(bonus, 8, 1);
			table.setValueAt(summeOben, 9, 1);
		}else {
			summeOben = obererBlock;
			table.setValueAt(summeOben, 9, 1);
		}
		summe += summeOben;
		if (summe > 375) {
			throw new IllegalArgumentException("Summe >375: " + summe);
		}
		table.setValueAt(obererBlock, 7, 1);
		table.setValueAt(summeOben, 18, 1);
		table.setValueAt(summe, 19, 1);
	}
	
	// Hilfsmethode, die die Summen im unnteren Block aktualisiert.
	private void updateSummeUntererBlock(int punkte) {
		if (punkte < 0 || punkte > 50) {
			throw new IllegalArgumentException("Punktezahl <0 oder >50: " + punkte);
		}
		untererBlock += punkte;
		summe += punkte;
		if (summe > 375) {
			throw new IllegalArgumentException("Summe >375: " + summe);
		}
		table.setValueAt(untererBlock, 17, 1);
		table.setValueAt(summe, 19, 1);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == wuerfeln) {
			wuerfeln();
		} else if (arg0.getSource() == neuesSpiel) {
			Kniffel newWindow = new Kniffel();
			new KniffelController(newWindow);
			newWindow.setVisible(true);
			this.window.dispose();
			spielGestartet = false;

		} else if (arg0.getSource() == eintragen && rBtn[0].isSelected()) {
			int punkte = regel.einerRegel();
			table.setValueAt(punkte, 1, 1);
			updateSummeObererBlock(punkte);
			resetWuerfel(0);
		} else if (arg0.getSource() == eintragen && rBtn[1].isSelected()) {
			int punkte = regel.zweierRegel();
			table.setValueAt(punkte, 2, 1);
			updateSummeObererBlock(punkte);
			resetWuerfel(1);
		} else if (arg0.getSource() == eintragen && rBtn[2].isSelected()) {
			int punkte = regel.dreierRegel();
			table.setValueAt(punkte, 3, 1);
			updateSummeObererBlock(punkte);
			resetWuerfel(2);
		} else if(arg0.getSource() == eintragen && rBtn[3].isSelected()) {
			int punkte = regel.viererRegel();
			table.setValueAt(punkte, 4, 1);
			updateSummeObererBlock(punkte);
			resetWuerfel(3);
		}else if(arg0.getSource() == eintragen && rBtn[4].isSelected()) {
			int punkte = regel.fuenferRegel();
			table.setValueAt(punkte, 5, 1);
			updateSummeObererBlock(punkte);
			resetWuerfel(4);
		}else if(arg0.getSource() == eintragen && rBtn[5].isSelected()) {
			int punkte = regel.sechserRegel();
			table.setValueAt(punkte, 6, 1);
			updateSummeObererBlock(punkte);
			resetWuerfel(5);
		}else if(arg0.getSource() == eintragen && rBtn[6].isSelected()) {
			int punkte = regel.dreierpaschRegel();
			table.setValueAt(punkte, 10, 1);
			updateSummeUntererBlock(punkte);
			resetWuerfel(6);
		}else if(arg0.getSource() == eintragen && rBtn[7].isSelected()) {
			int punkte = regel.viererpaschRegel();
			table.setValueAt(punkte, 11, 1);
			updateSummeUntererBlock(punkte);
			resetWuerfel(7);
		}else if(arg0.getSource() == eintragen && rBtn[8].isSelected()) {
			int punkte = regel.fullhouseRegel();
			table.setValueAt(punkte, 12, 1);
			updateSummeUntererBlock(punkte);
			resetWuerfel(8);
		}else if(arg0.getSource() == eintragen && rBtn[9].isSelected()) {
			int punkte = regel.kstrasseRegel();
			table.setValueAt(punkte, 13, 1);
			updateSummeUntererBlock(punkte);
			resetWuerfel(9);
		}else if(arg0.getSource() == eintragen && rBtn[10].isSelected()) {
			int punkte = regel.gstrasseRegel();
			table.setValueAt(punkte, 14, 1);
			updateSummeUntererBlock(punkte);
			resetWuerfel(10);
		}else if(arg0.getSource() == eintragen && rBtn[11].isSelected()) {
			int punkte = regel.kniffelRegel();
			table.setValueAt(punkte, 15, 1);
			updateSummeUntererBlock(punkte);
			resetWuerfel(11);
		}else if(arg0.getSource() == eintragen && rBtn[12].isSelected()) {
			int punkte = regel.chanceRegel();
			table.setValueAt(punkte, 16, 1);
			updateSummeUntererBlock(punkte);
			resetWuerfel(12);
		}
		else if (arg0.getSource() == close) {
			schliessenDialog();
		}

	}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		schliessenDialog();
	}

}
