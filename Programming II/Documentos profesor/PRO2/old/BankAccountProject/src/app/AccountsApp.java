package app;

import java.awt.Dimension;

import javax.swing.JFrame;

import ctrl.Controller;

import gui.MainWindow;
import model.Account;
import model.Person;
import model.PersonList;


public class AccountsApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PersonList persons = new PersonList();
		persons.add(new Person("Jane", 28));
		persons.add(new Person("Peter", 31));
		persons.add(new Person("John", 12));
		Account a = new Account("13464", 1000);
		a.deposit(10);
		persons.get(0).getAccounts().add(a);
		
		Controller controller = new Controller(persons);
		
		MainWindow window = new MainWindow(controller);
		window.setPreferredSize(new Dimension(200,400));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
