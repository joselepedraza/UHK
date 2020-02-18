package gui;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.Account;
import model.AccountChangeListener;
import model.PersonalAccountList;
import model.Transaction;
import model.TransactionList;

public class TransactionsTableModel extends AbstractTableModel implements AccountChangeListener{
	private TransactionList transactions = null;
	private String[] columnNames = {"Desc", "Date", "Amount"};

	public TransactionsTableModel(TransactionList transactions) {
		this.transactions = transactions;
		transactions.getAccount().addAccountChangeListener(this);
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
		
		return transactions.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String res = "";
		Transaction t = transactions.get(rowIndex);
		switch (columnIndex) {
		case 0:
			res = t.getDesc();
			break;
		case 1:
			res = t.getDateAsString();
			break;
		case 2:
			res = t.getAmountAsString();
			break;
		}
		return res;
	}

	public void accountChanged() {
		fireTableDataChanged();
	}


}
