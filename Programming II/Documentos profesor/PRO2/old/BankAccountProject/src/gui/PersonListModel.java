package gui;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import model.Person;
import model.PersonList;

public class PersonListModel extends DefaultListModel<Person> {
	private PersonList persons = null;

	public PersonListModel(PersonList persons) {
		super();
		this.persons = persons;
	}
	

	public void addElement(Person element) {
		persons.add(element);
		super.addElement(element);
	}

	@Override
	public Person getElementAt(int index) {
		return persons.get(index);
	}

	@Override
	public int getSize() {
		return persons.size();
	}
	
	public void updateContent() {
		fireContentsChanged(this, 0, size());
	}
	
	@Override
	public Person remove(int index) {
		Person p = persons.remove(index);
		updateContent();
		return p;
	}
	

}
