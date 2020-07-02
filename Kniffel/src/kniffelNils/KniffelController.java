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
	JRadioButton einer,zweier,dreier,vierer,fuenfer,sechser,dreierpasch,viererpasch,fullHouse,kStrasse,gStrasse,chance;
	Kniffel kniffel;
	DefaultTableModel model;
	JTable table;
	int anzWuerfe;
	static int punkte;
	int[]wuerfel = new int[5];
	KniffelRules regeln = new KniffelRules(kniffel);
	
	KniffelController(Kniffel kniffel)
	{
		this.kniffel = kniffel;
		
		wuerfeln = kniffel.getWuerfeln();
		wuerfeln.addActionListener(this);
		
		beenden = kniffel.getBeenden();
		beenden.addActionListener(this);
		
		eintragen = kniffel.getEintragen();
		eintragen.addActionListener(this);
		
		table = kniffel.getTable();
		model = kniffel.getModel();
		this.wuerfel = kniffel.getWuerfel();
		
		l1 = kniffel.getL1();
		l2 = kniffel.getL2();
		l3 = kniffel.getL3();
		l4 = kniffel.getL4();
		l5 = kniffel.getL5();
		
		einer = kniffel.getEiner();
		
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
			kniffel.setWuerfel(wuerfel);
			l1.setText(String.valueOf(wuerfel[0]));
			l2.setText(String.valueOf(wuerfel[1]));
			l3.setText(String.valueOf(wuerfel[2]));
			l4.setText(String.valueOf(wuerfel[3]));
			l5.setText(String.valueOf(wuerfel[4]));
		}
		else if(einer.isSelected() && e.getSource() == eintragen) 
		{
			
				punkte = regeln.einerRegel();
				model.setValueAt(String.valueOf(punkte), 1, 1);
				einer.setEnabled(false);
		}
		else if(e.getSource() == beenden) 
		{
			System.exit(0);
		}
		
	}

	
	
}
