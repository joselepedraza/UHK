package model;
import java.util.Iterator;
import java.util.Vector;



public class PersonList extends Vector<Person> {
	public AccountList getGlobalAccountList(){
		AccountList accounts = new AccountList();
		for (Person p: this) {
			accounts.addAll(p.getAccounts());
		} 
		
		return accounts;
	}


}
