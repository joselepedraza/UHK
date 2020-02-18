package gui;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import model.Account;
import model.AccountChangeListener;
import model.PersonalAccountList;


public class AccountsTableModel extends AbstractTableModel implements TableModelListener {
	private PersonalAccountList accounts = null;
	private String[] columnNames = {"Swift", "Set up", "Balance"};

	public AccountsTableModel(PersonalAccountList accounts) {
		this.accounts = accounts;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
    public String getColumnName(int col) {
	    return columnNames[col];
	}


	@Override
	public int getRowCount() {
		
		return accounts.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String res = "";
		Account a = accounts.get(rowIndex);
		switch (columnIndex) {
		case 0:
			res = a.getSwift();
			break;
		case 1:
			res = a.getDateAsString();
			break;
		case 2:
			res = a.getBalanceAsString();
			break;
		}
		return res;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		 int row = e.getFirstRow();
	     int column = e.getColumn();
	     
	     Object data = getValueAt(row, column);
	     Account a = accounts.get(row);
			switch (column) {
			case 0:
				a.setSwift((String)data);
				break;
		
			}
	}

}
