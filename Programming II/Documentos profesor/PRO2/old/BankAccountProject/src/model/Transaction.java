package model;

import java.util.Date;


public abstract class Transaction {
	private Account account;
	private int amount;
	private Date date;
	
	public Transaction(Account account, int amount){
		this.account = account;
		this.amount = amount;
		date = new Date();
		account.getTransactions().add(this);
	}

	abstract protected int getSign();
	abstract public String getDesc();
	
	public int getAmount(){
		return getSign() * amount;
	}
	
	public String getAmountAsString(){
		return String.valueOf(getAmount());
	}
	
	public Date getDate(){
		return date;
	}
	public String getDateAsString(){
		return date.toString();
	}

	public Account getAccount() {
		return account;
	}

	void setAccount(Account account) {
		this.account = account;
	}
	
	

}
