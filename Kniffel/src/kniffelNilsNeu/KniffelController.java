package kniffelNilsNeu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class KniffelController implements ActionListener {

	Kniffel window;
	Rules rule;
	JButton close, newGame, eintragen, roll;
	JToggleButton[] tBtn;
	JLabel[] labels;
	JRadioButton[] rBtn;
	ButtonGroup btngrp;
	JTable table;
	int[] wuerfel = new int[5];
	int anzWuerfe;
	int upperSection,bonus,totalUpper,total,lowerSection;

	KniffelController(Kniffel window) {
		this.window = window;
		rule = new Rules(window);
		newGame = window.getNewGame();
		newGame.addActionListener(this);
		close = window.getClose();
		close.addActionListener(this);
		eintragen = window.getEintragen();
		eintragen.addActionListener(this);
		roll = window.getRoll();
		roll.addActionListener(this);
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
	
	
	private void roll() {
		anzWuerfe++;
		for (int i = 0; i < 5; i++) {
			if (!tBtn[i].isSelected()) {
				wuerfel[i] = (int) (6 * Math.random() + 1);
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
			roll.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == roll) {
			roll();
//			anzWuerfe++;
//			for (int i = 0; i < tBtn.length; i++) {
//				if (!tBtn[i].isSelected()) {
//					wuerfel[i] = (int) (6 * Math.random() + 1);
//					labels[i].setText(String.valueOf(wuerfel[i]));
//				}
//			}
//			if(anzWuerfe == 0) {
//				for (int j = 0; j < tBtn.length; j++) {
//					tBtn[j].setEnabled(false);
//				}
//				eintragen.setEnabled(false);
//			}
//			if(anzWuerfe == 1) {
//				for (int k = 0; k < labels.length; k++) {
//					
//						tBtn[k].setEnabled(true);
//				}	
//					eintragen.setEnabled(true);
//				
//			}
//			if(anzWuerfe == 3) {
//				roll.setEnabled(false);
//			}
		} else if (arg0.getSource() == newGame) {
			Kniffel newWindow = new Kniffel();
			new KniffelController(newWindow);
			newWindow.setVisible(true);
			this.window.dispose();

		} else if (arg0.getSource() == eintragen && rBtn[0].isSelected()) {
			int punkte = rule.einerRegel();
			table.setValueAt(punkte, 1, 1);
			rBtn[0].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			upperSection += punkte;
			if(upperSection >= 63 && bonus == 0) {
				bonus = 35;
				totalUpper = upperSection + bonus;
				table.setValueAt(bonus, 8, 1);
				table.setValueAt(totalUpper, 9, 1);
			}else {
				totalUpper = upperSection;
				table.setValueAt(totalUpper, 9, 1);
			}
			total += totalUpper;
			table.setValueAt(upperSection, 7, 1);
			table.setValueAt(totalUpper, 18, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		} else if (arg0.getSource() == eintragen && rBtn[1].isSelected()) {
			int punkte = rule.zweierRegel();
			table.setValueAt(punkte, 2, 1);
			rBtn[1].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			upperSection += punkte;
			if(upperSection >= 63 && bonus == 0) {
				bonus = 35;
				totalUpper = upperSection + bonus;
				table.setValueAt(bonus, 8, 1);
				table.setValueAt(totalUpper, 9, 1);
			}else {
				totalUpper = upperSection;
				table.setValueAt(totalUpper, 9, 1);
			}
			total += totalUpper;
			table.setValueAt(upperSection, 7, 1);
			table.setValueAt(totalUpper, 18, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		} else if (arg0.getSource() == eintragen && rBtn[2].isSelected()) {
			int punkte = rule.dreierRegel();
			table.setValueAt(punkte, 3, 1);
			rBtn[2].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			upperSection += punkte;
			if(upperSection >= 63 && bonus == 0) {
				bonus = 35;
				totalUpper = upperSection + bonus;
				table.setValueAt(bonus, 8, 1);
				table.setValueAt(totalUpper, 9, 1);
			}else {
				totalUpper = upperSection;
				table.setValueAt(totalUpper, 9, 1);
			}
			total += totalUpper;
			table.setValueAt(upperSection, 7, 1);
			table.setValueAt(totalUpper, 18, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		} else if(arg0.getSource() == eintragen && rBtn[3].isSelected()) {
			int punkte = rule.viererRegel();
			table.setValueAt(punkte, 4, 1);
			rBtn[3].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			upperSection += punkte;
			if(upperSection >= 63 && bonus == 0) {
				bonus = 35;
				totalUpper = upperSection + bonus;
				table.setValueAt(bonus, 8, 1);
				table.setValueAt(totalUpper, 9, 1);
			}else {
				totalUpper = upperSection;
				table.setValueAt(totalUpper, 9, 1);
			}
			total += totalUpper;
			table.setValueAt(upperSection, 7, 1);
			table.setValueAt(totalUpper, 18, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[4].isSelected()) {
			int punkte = rule.fuenferRegel();
			table.setValueAt(punkte, 5, 1);
			rBtn[4].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			upperSection += punkte;
			if(upperSection >= 63 && bonus == 0) {
				bonus = 35;
				totalUpper = upperSection + bonus;
				table.setValueAt(bonus, 8, 1);
				table.setValueAt(totalUpper, 9, 1);
			}else {
				totalUpper = upperSection;
				table.setValueAt(totalUpper, 9, 1);
			}
			total += totalUpper;
			table.setValueAt(upperSection, 7, 1);
			table.setValueAt(totalUpper, 18, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[5].isSelected()) {
			int punkte = rule.sechserRegel();
			table.setValueAt(punkte, 6, 1);
			rBtn[5].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			upperSection += punkte;
			if(upperSection >= 63 && bonus == 0) {
				bonus = 35;
				totalUpper = upperSection + bonus;
				table.setValueAt(bonus, 8, 1);
				table.setValueAt(totalUpper, 9, 1);
			}else {
				totalUpper = upperSection;
				table.setValueAt(totalUpper, 9, 1);
			}
			total+=totalUpper;
			table.setValueAt(upperSection, 7, 1);
			table.setValueAt(totalUpper, 18, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[6].isSelected()) {
			int punkte = rule.dreierpaschRegel();
			table.setValueAt(punkte, 10, 1);
			rBtn[6].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			lowerSection += punkte;
			total += punkte;
			table.setValueAt(lowerSection, 17, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[7].isSelected()) {
			int punkte = rule.viererpaschRegel();
			table.setValueAt(punkte, 11, 1);
			rBtn[7].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			lowerSection += punkte;
			total += punkte;
			table.setValueAt(lowerSection, 17, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[8].isSelected()) {
			int punkte = rule.fullhouseRegel();
			table.setValueAt(punkte, 12, 1);
			rBtn[8].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			lowerSection += punkte;
			total += punkte;
			table.setValueAt(lowerSection, 17, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[9].isSelected()) {
			int punkte = rule.kstrasseRegel();
			table.setValueAt(punkte, 13, 1);
			rBtn[9].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			lowerSection += punkte;
			total += punkte;
			table.setValueAt(lowerSection, 17, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[10].isSelected()) {
			int punkte = rule.gstrasseRegel();
			table.setValueAt(punkte, 14, 1);
			rBtn[10].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			lowerSection += punkte;
			total += punkte;
			table.setValueAt(lowerSection, 17, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[11].isSelected()) {
			int punkte = rule.kniffelRegel();
			table.setValueAt(punkte, 15, 1);
			rBtn[11].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			lowerSection += punkte;
			total += punkte;
			table.setValueAt(lowerSection, 17, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}else if(arg0.getSource() == eintragen && rBtn[12].isSelected()) {
			int punkte = rule.chanceRegel();
			table.setValueAt(punkte, 16, 1);
			rBtn[12].setEnabled(false);
			eintragen.setEnabled(false);
			btngrp.clearSelection();
			roll.setEnabled(true);
			for (int i = 0; i < 5; i++) {
				if(tBtn[i].isSelected()) {
					tBtn[i].setSelected(false);
				}
			}
			lowerSection += punkte;
			total += punkte;
			table.setValueAt(lowerSection, 17, 1);
			table.setValueAt(total, 19, 1);
			anzWuerfe = 0;
		}
		else if (arg0.getSource() == close) {
			System.exit(0);
		}

	}

}
