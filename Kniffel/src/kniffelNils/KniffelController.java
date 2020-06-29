package kniffelNils;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class KniffelController implements ActionListener{

	JButton wuerfeln,beenden,eintragen;
	JButton w1,w2,w3,w4,w5;
	JCheckBox einer,zweier,dreier,vierer,fuenfer,sechser,dreierpasch,viererpasch,fullHouse,kStrasse,gStrasse,kniffel,chance;
	JTable table;
	int[]wuerfel = new int[5];
	
	KniffelController(Kniffel kniffel)
	{
		wuerfeln = kniffel.getWuerfeln();
		wuerfeln.addActionListener(this);
		
		beenden = kniffel.getBeenden();
		beenden.addActionListener(this);
		
		eintragen = kniffel.getEintragen();
		eintragen.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == wuerfeln) 
		{
			for (int i = 0; i < wuerfel.length; i++) 
			{
				wuerfel[i] = (int) Math.random()*6;				
			} 
		}
		else if(e.getSource() == beenden) 
		{
			System.exit(0);
		}
		
	}

	
	
}
