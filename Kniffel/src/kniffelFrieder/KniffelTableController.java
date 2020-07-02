package kniffelFrieder;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class KniffelTableController extends AbstractTableModel {
	private static final int ROWS = 19;
	private static final int COLS = 3;
	private JTable kniffelTable;
	
	private Object[][] data; 
	
	public KniffelTableController (KniffelWindow kniffelData) {
		data = new Object[ROWS][COLS]; 
		for ( int row = 0; row < data.length; row++ ) {
			for ( int col = 0; col < data[0].length; col++ ) {
				data[row][col] = Integer.parseInt("" + row * col);
				if (col == 9) {
					data[row][col] = true;
				}
			}
		}
		
		
		
		kniffelTable = kniffelData.getKniffelTable();
		kniffelTable.addActionListener(this);
	}

	
	public int getColumnCount () {
		return COLS;
	}
	
	
	public int getRowCount () {
		return ROWS;
	}
	
	
	public String getColumnName ( int col ) {
		return "Spalte " + col;
	}
	
	
	public Object getValueAt (int row, int col) { 
		return data[row][col]; 
	}
	


	
	public void setValueAt(Object value, int row, int col) { 
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}

	public boolean isCellEditable(int row, int col) {
		if (col == 1) {
			return true;
		}
		return false;
	}
		
	
	public Class<?> getColumnClass(int c) {
	    return getValueAt(0, c).getClass();
	}
	
	
	
	


}