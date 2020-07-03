package kniffelNils;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KniffelController implements ActionListener{

	JButton wuerfeln,beenden,eintragen;
	JToggleButton w1,w2,w3,w4,w5;
	JLabel l1,l2,l3,l4,l5;
	JRadioButton einer,zweier,dreier,vierer,fuenfer,sechser,dreierpasch,viererpasch,fullHouse,kStrasse,gStrasse,kniffel,chance;
	Kniffel kn;
	DefaultTableModel model;
	JTable table;
	int anzWuerfe;
	int punkte = 0;
	int[]wuerfel = {0,0,0,0,0};
	KniffelRules regeln = new KniffelRules(kn);
	
	KniffelController(Kniffel knif)
	{
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
		
		
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == wuerfeln && anzWuerfe < 3) 
		{
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
			
		}
		else if(einer.isSelected() && e.getSource() == eintragen) 
		{	
				table.getModel().setValueAt(String.valueOf(punkte), 1, 1);
				einer.setEnabled(false);
				punkte += regeln.einerRegel();
		}
		else if(e.getSource() == beenden) 
		{
			System.exit(0);
		}
		
	}

	
	
}
