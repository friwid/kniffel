package kniffelFrieder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

public class KniffelController extends WindowAdapter implements ActionListener, WindowListener {

	JMenuItem menuExit;
	JButton wuerfeln,beenden,eintragen;
	JToggleButton w1,w2,w3,w4,w5;
	JLabel l1,l2,l3,l4,l5;
	JRadioButton einer,zweier,dreier,vierer,fuenfer,sechser,dreierpasch,viererpasch,fullHouse,kStrasse,gStrasse,kniffel,chance;
	Kniffel kn;
	DefaultTableModel model;
	JTable table;
	int anzWuerfe = 0;
	int punkte = 0;
	int[]wuerfel = {0,0,0,0,0};
	KniffelRules regeln = new KniffelRules(kn);
	private boolean spielGestartet = false;
	
	KniffelController(Kniffel knif)
	{
		knif.addWindowListener(this);
		
		menuExit = knif.getMenuExit();
		menuExit.addActionListener(this);
		
		this.kn = knif;
		
		wuerfeln = knif.getWuerfeln();
		wuerfeln.addActionListener(this);
		
		beenden = knif.getBeenden();
		beenden.addActionListener(this);
		
		eintragen = knif.getEintragen();
		eintragen.addActionListener(this);
		
		table = knif.getTable();
		model = knif.getModel();
		
		this.wuerfel = knif.getWuerfel();
		
		l1 = knif.getL1();
		l2 = knif.getL2();
		l3 = knif.getL3();
		l4 = knif.getL4();
		l5 = knif.getL5();
		
		w1 = knif.getW1();
		w2 = knif.getW2();
		w3 = knif.getW3();
		w4 = knif.getW4();
		w5 = knif.getW5();
		
		w1.setEnabled(false);
		w2.setEnabled(false);
		w3.setEnabled(false);
		w4.setEnabled(false);
		w5.setEnabled(false);
		
		einer = knif.getEiner();
		zweier = knif.getZweier();
		dreier = knif.getDreier();
		vierer = knif.getVierer();
		fuenfer = knif.getFuenfer();
		sechser = knif.getSechser();
		dreierpasch = knif.getDreierpasch();
		viererpasch = knif.getViererpasch();
		fullHouse = knif.getFullHouse();
		kStrasse = knif.getkStrasse();
		gStrasse = knif.getgStrasse();
		kniffel = knif.getKniffel();
		chance = knif.getChance();
		
		
	}
	
	// Beenden-Dialog, falls Spiel bereits gestartet wurde
	public void closeDialog() {
		if (!spielGestartet) {
			System.exit(0);
		} else {
			int result = JOptionPane.showOptionDialog(
					kniffel, 
					"Das Spiel ist noch im Gange. Dennoch beenden?", 
					"Programm beenden", 
					JOptionPane.OK_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					new String[] { "Beenden", "Abbrechen" }, 
					JOptionPane.NO_OPTION
			);
			switch (result) {
			case 0:
				System.exit(0);
			}
		}
	}
		
	@Override
	public void windowClosing(WindowEvent e) {
		closeDialog();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == wuerfeln && anzWuerfe < 3) 
		{
			spielGestartet = true;
			
			if (anzWuerfe == 0) {
				w1.setEnabled(true);
				w2.setEnabled(true);
				w3.setEnabled(true);
				w4.setEnabled(true);
				w5.setEnabled(true);;
			}
			for (int i = 0; i < wuerfel.length; i++) 
			{
				wuerfel[i] = (int) (6*Math.random()+1);								
			} 
			kn.setWuerfel(wuerfel);
			l1.setText(String.valueOf(wuerfel[0]));
			l2.setText(String.valueOf(wuerfel[1]));
			l3.setText(String.valueOf(wuerfel[2]));
			l4.setText(String.valueOf(wuerfel[3]));
			l5.setText(String.valueOf(wuerfel[4]));
			
			if (!w1.isSelected()) {
			w1.setText(String.valueOf(wuerfel[0]));
			}
			if (!w2.isSelected()) {
				w2.setText(String.valueOf(wuerfel[1]));
			}
			if (!w3.isSelected()) {
				w3.setText(String.valueOf(wuerfel[2]));
			}
			if (!w4.isSelected()) {
				w4.setText(String.valueOf(wuerfel[3]));
			}
			if (!w5.isSelected()) {
				w5.setText(String.valueOf(wuerfel[4]));
			}
			
			anzWuerfe++;
			
			if (anzWuerfe == 3) {
				w1.setSelected(true);
				w2.setSelected(true);
				w3.setSelected(true);
				w4.setSelected(true);
				w5.setSelected(true);
				w1.setEnabled(false);
				w2.setEnabled(false);
				w3.setEnabled(false);
				w4.setEnabled(false);
				w5.setEnabled(false);;
			}
		}
		else if(einer.isSelected() && e.getSource() == eintragen) 
		{	
				table.getModel().setValueAt(String.valueOf(punkte), 1, 1);
				einer.setEnabled(false);
				punkte += regeln.einerRegel();
				
				anzWuerfe = 0;
		}
		else if(e.getSource() == beenden || e.getSource() == menuExit) 
		{
			closeDialog();
		}
		
	}
	
}
