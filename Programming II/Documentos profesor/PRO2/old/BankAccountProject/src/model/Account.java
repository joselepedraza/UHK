package model;

import java.util.Date;
import java.util.Vector;



public class Account {
	private Vector<AccountChangeListener> listeners= new Vector<AccountChangeListener>(); 
	private Person person;
	private TransactionList transactions = new TransactionList(this);
	private String swift;
	private Date date;
	
	public Account() {
		this.date = new Date();
	}

	
	public Account(String swift, int initialAmount) {
		this.swift = swift;
		if (initialAmount>0) deposit(initialAmount);
		this.date = new Date();
	}
	
	public void deposit(int amount){
		new DepositTransaction(this, amount);
	}
	public void tranfer(int amount, Account dest){
		new TransferToTransaction(this, amount, dest);
	}
	
	public void withdraw(int amount){
		new WithdrawTransaction(this, amount);
	}
	
	public void addAccountChangeListener(AccountChangeListener listener){
		listeners.add(listener);
	}
	
	protected void notifyListners(){
		for (AccountChangeListener listener : listeners) {
			if (listener != null) listener.accountChanged();
		}
	}
	
	public String toString(){
		return swift + " " + date + " " + getBalance();
	}

	public String getSwift() {
		return swift;
	}
	public int getBalance() {
		return transactions.getBalance();
	}

	public Date getDate() {
		return date;
	}
	public String getBalanceAsString() {
		return String.valueOf(getBalance());
	}

	public String getDateAsString() {
		return date.toString();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public TransactionList getTransactions() {
		return transactions;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}
	

}
