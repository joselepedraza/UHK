package model;

import java.util.Vector;

public class PersonalAccountList extends Vector<Account> {
	private Person person;
	
	public PersonalAccountList(Person person){
		this.person = person;
	}
	
	@Override
	public synchronized boolean add(Account account) {
		account.setPerson(person);
		return super.add(account);
	}

}
