package ctrl;

import gui.AccountWindow;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Account;
import model.Person;

public class ActionsPool {
	private Controller controller;

	public ActionsPool(Controller controller) {
		this.controller = controller;
	}
	
	public AbstractAction getSaveAccountAction(final AccountWindow accountWindow){
		return new BankAccountAction("Save", "img/save.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().saveAccount(accountWindow);
			}
		};
	}
	public AbstractAction getTransferMoneyAction(final Account account){
		return new BankAccountAction("Transfer", "img/transfer.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().transferMoney(account);
			}
		};
	}
	public AbstractAction getDepositMoneyAction(final Account account){
		return new BankAccountAction("Deposit", "img/transfer.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().depositMoney(account);
			}
		};
	}
	public AbstractAction getWithdrawMoneyAction(final Account account){
		return new BankAccountAction("Deposit", "img/transfer.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().depositMoney(account);
			}
		};
	}
	
	public ListSelectionListener getPersonSelectionHandler(){
		return new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				getController().currPersonChanged();
				
			}
		};
	}
	
	public MouseListener getAccountSelectionHandler(){
		return new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1){
					getController().showAccount();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
		};
	}
	
	public AbstractAction getNewAccountAction(){
		return new BankAccountAction("New", "img/new_account.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().newAccount();
				
			}
		};
	}
	public AbstractAction getNewPersonAction(){
		return new BankAccountAction("New", "img/new_person.jpg") {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().newPerson();
				
			}
		};
	}

	
	public AbstractAction getRemovePersonAction(){
		return new BankAccountAction("New", "img/remove_person.jpg") {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().removePerson();
			}
		};
	}
	

	public Controller getController() {
		return controller;
	}

	public AbstractAction getRemoveAccountAction() {
		
		return new BankAccountAction("Remove", "img/remove_account.png") {
			@Override
			public void actionPerformed(ActionEvent e) {
				getController().removeAccount();
			}
		};
	}

}
