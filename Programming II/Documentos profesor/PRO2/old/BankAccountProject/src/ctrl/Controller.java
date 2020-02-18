package ctrl;

import javax.swing.JOptionPane;

import model.Account;
import model.Person;
import model.PersonList;
import model.TransferToTransaction;
import gui.AccountWindow;
import gui.MainWindow;
import gui.TransferWindow;


public class Controller {
	private PersonList persons = null;

	private MainWindow mainWindow;
	private ActionsPool actionsPool = new ActionsPool(this);
	
	public Controller(PersonList persons) {
		this.persons = persons;
	}

	public void showAccountWindowToView(Account account){
		AccountWindow accountWindow = new AccountWindow(account, AccountWindow.MODE_VIEW, this);
		accountWindow.setVisible(true);
	}
	
	public void showAccountWindowToInsert(Account account){
		AccountWindow accountWindow = new AccountWindow(account, AccountWindow.MODE_INSERT, this);
		accountWindow.setVisible(true);
	}

	
	public void newAccount(){
		Account a = new Account();
		getMainWindow().getSelectedPerson().getAccounts().add(a);
		showAccountWindowToInsert(a);
	}
	
	public void showAccount() {
		Account a = getMainWindow().getSelectedAccount();
		if (a != null){
			showAccountWindowToView(a);
		}
	}
	
	public void saveAccount(AccountWindow accountWindow){
		accountWindow.getShownAccount().setSwift(accountWindow.getSwift());
		accountWindow.setVisible(false);
		getMainWindow().refreshAccountsTable();
	}
	
	public void currPersonChanged(){
		getMainWindow().changeSelectedPerson(getMainWindow().getSelectedPerson());
	}
	
	public void removePerson() {
		Person p = getMainWindow().getSelectedPerson();
		if (p != null){
			int answer = JOptionPane.showConfirmDialog(null, "Remove " + p.getName(),
				    "Confirm",
				    JOptionPane.YES_NO_OPTION);

			if (answer == JOptionPane.YES_OPTION){
				doRemovePerson();
			}

		}
	}
	public void newPerson() {
		
		persons.add(new Person("<new person>", 0));
		getMainWindow().refreshPersonList();
	}

	
	private void doRemovePerson() {
		
		
	}


	public ActionsPool getActionsPool(){
		return actionsPool;
	}

	public PersonList getPersons() {
		return persons;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void removeAccount() {
		
		
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public void transferMoney(Account account) {
		TransferWindow w = TransferWindow.showWindow(persons.getGlobalAccountList());
		if (w.getCloseOption() == TransferWindow.CO_CONFIRM){
			account.tranfer(w.getAmount(), w.getDestinationAccount());
			getMainWindow().refreshAccountsTable();
		}

	}
	
	public int askForAmount(String message){
		int res = -1;
		String s = (String)JOptionPane.showInputDialog(getMainWindow(),
                "Specify amount:\n", 
                message,
                JOptionPane.QUESTION_MESSAGE,
                null, null, "0");
		

		if (s != null) {
			res = Integer.parseInt(s);
		}
		return res;
	}

	public void depositMoney(Account account) {
		try {

			   account.deposit(askForAmount("Deposit to " + account.getSwift()));
			   getMainWindow().refreshAccountsTable();
		} catch (NumberFormatException ex){
					// not a proper number in the edit box but never mind
		}
			
		
		
	}
	public void withdrawMoney(Account account) {
		try {
		   account.withdraw(askForAmount("Deposit to " + account.getSwift()));
		   getMainWindow().refreshAccountsTable();
		} catch (NumberFormatException ex){
					// not a proper number in the edit box but never mind
		}
			
		
		
	}

	
}
