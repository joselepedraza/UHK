package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import ctrl.Controller;

import model.Account;
import model.Person;
import model.PersonList;

public class MainWindow extends JFrame {
	private Controller controller;
	
	private PersonListModel listModel = null;
	
	private JLabel lblName = new JLabel("Name");
	private JLabel lblAge = new JLabel("Age");
	private JTextField tfName = new JTextField(30);
	private JTextField tfAge = new JTextField(30);
	private JList lstPersons = null;
	private JTable tblAccounts = new JTable();
	private JMenuBar menubar = new JMenuBar();
	private JToolBar toolbar = new JToolBar();
	
	
	public MainWindow(Controller controller){
		this.controller = controller;
		controller.setMainWindow(this);
		
		setTitle("Person list");
		
		initMenu();
		initToolbar();
		initComponents();
		initListeners();
		
		setLocationRelativeTo(null);
	}
	
	private void initComponents(){
		listModel = new PersonListModel(controller.getPersons());
		lstPersons = new JList(listModel);
			
		JScrollPane scrlPane = new JScrollPane(lstPersons);
		scrlPane.setPreferredSize(new Dimension(200,200));
		
		JPanel attribPane = new JPanel(new GridLayout(2,2));
		attribPane.add(lblName);
		attribPane.add(tfName);
		attribPane.add(lblAge);
		attribPane.add(tfAge);
		
		
		JPanel detailPane = new JPanel(new BorderLayout());
		detailPane.add(attribPane, BorderLayout.NORTH);
		detailPane.add(new JScrollPane(tblAccounts), BorderLayout.CENTER);
		
		JPanel content = new JPanel(new BorderLayout());
		content.add(scrlPane, BorderLayout.WEST);
		content.add(detailPane, BorderLayout.CENTER);
		content.add(toolbar, BorderLayout.NORTH);
		
		setContentPane(content);
		
		pack();
	
	}
	
	private void initListeners(){
		tfName.addKeyListener(new EditListener());
		tfAge.addKeyListener(new EditListener());
		lstPersons.getSelectionModel().addListSelectionListener(controller.getActionsPool().getPersonSelectionHandler());
		tblAccounts.addMouseListener(controller.getActionsPool().getAccountSelectionHandler());

	}
	
	private void initMenu(){
		setJMenuBar(menubar);
		
		JMenu menu = new JMenu("Person");
		menubar.add(menu);
		menu.add(controller.getActionsPool().getNewPersonAction());
		menu.add(controller.getActionsPool().getRemovePersonAction());
		
		menu = new JMenu("Account");
		menubar.add(menu);
		menu.add(controller.getActionsPool().getNewAccountAction());
		menu.add(controller.getActionsPool().getRemoveAccountAction());

		
	}
	
	private void initToolbar(){
		JButton button = toolbar.add(controller.getActionsPool().getNewPersonAction());
		button = toolbar.add(controller.getActionsPool().getRemovePersonAction());
		toolbar.addSeparator();
		button = toolbar.add(controller.getActionsPool().getNewAccountAction());
		button = toolbar.add(controller.getActionsPool().getRemoveAccountAction());
	}
	
	public Account getSelectedAccount(){
		int index = tblAccounts.getSelectedRow();
		return getSelectedPerson().getAccounts().get(index);
	}

	
	public Person getSelectedPerson(){
		Person p = null;
		int index = getPersonListSelectedIndex();
		if (index!=-1){
			p = controller.getPersons().get(index);
		}
		return p;
	}
	
	public int getPersonListSelectedIndex(){
		return lstPersons.getSelectedIndex();
	}
	
	
	class EditListener implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent arg0) {	}

		@Override
		public void keyReleased(KeyEvent arg0) { }

		@Override
		public void keyTyped(KeyEvent e) {
			Person p = getSelectedPerson();
			if ((p != null)){
				
				if (e.getSource()== tfName){
					p.setName(tfName.getText()+ e.getKeyChar());
				} 
				if (e.getSource()== tfAge){
					try {
					   p.setAge(Integer.parseInt(tfAge.getText() + e.getKeyChar()));
					} catch (NumberFormatException ex){
						// not a proper number in the edit box but never mind
					}
				}
				
				listModel.updateContent();
			}
			
		}
		
	}
	
	public String getName(){
		return tfName.getText();
	}
	public int getAge(){
		int res = 0;
		try {
		   res = Integer.parseInt(tfAge.getText());
		} catch (NumberFormatException ex){
				// not a proper number in the edit box but never mind
		}
		return res;
	}
	public void setName(String name){
		tfName.setText(name);
	}
	public void setAge(int age){
		tfAge.setText(String.valueOf(age));
	}

	public void changeSelectedPerson(Person person) {
		setName(person.getName());
		setAge(person.getAge());
		tblAccounts.setModel(new AccountsTableModel(person.getAccounts()));
	}

	public void refreshPersonList() {
		listModel.updateContent();
	}
	
	public void refreshAccountsTable(){
		((AbstractTableModel) tblAccounts.getModel()).fireTableDataChanged();
	}
	

}
