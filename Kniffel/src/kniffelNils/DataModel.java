package kniffelNils;

import javax.swing.table.AbstractTableModel;

public class DataModel extends AbstractTableModel{

	private Object[][] data;
	
	DataModel(){
		data = new Object[20][2];		
	}

	@Override
	public int getRowCount() {
		return 20;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row,col);
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	
}
