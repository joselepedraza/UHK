package model;

import java.util.Vector;

public class TransactionList extends Vector<Transaction> {
	private Account account;
	
	public TransactionList(Account account){
		this.account = account;
	}
	
	@Override
	public synchronized boolean add(Transaction t) {
		boolean res = super.add(t);
		account.notifyListners();
		return res;
	}
	
	public int getBalance(){
		int result = 0;
		for (Transaction t : this) {
			result += t.getAmount();
		}
		
		return result;
	}

	public Account getAccount() {
		return account;
	}

}
