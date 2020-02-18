package gui;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import model.Account;
import model.AccountList;
import model.PersonalAccountList;

public class AccountsListModel extends DefaultComboBoxModel<Account>  {
	private AccountList accounts;
	
	public AccountsListModel(AccountList accounts){
		this.accounts = accounts;
	}

	@Override
	public Account getElementAt(int index) {
		return accounts.get(index);
	}

	@Override
	public int getSize() {
		return accounts.size();
	}

}
