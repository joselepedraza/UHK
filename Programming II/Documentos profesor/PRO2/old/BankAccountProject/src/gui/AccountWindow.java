package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import ctrl.Controller;

import model.Account;
import model.AccountChangeListener;

public class AccountWindow extends JFrame implements AccountChangeListener{
	public static final int MODE_VIEW = 1;
	public static final int MODE_INSERT = 2;

	private Account account;
	private Controller controller;
	private int mode = -1;
	
	private JToolBar toolbar = new JToolBar();
	private JLabel lblSwift = new JLabel("Swift");
	private JLabel lblBalance = new JLabel("Balance");
	private JLabel lblDate = new JLabel("Date");
	
	private JTextField tfSwift = new JTextField(30);
	private JTextField tfBalance = new JTextField(30);
	private JTextField tfDate = new JTextField(30);
	
	private JTable tblTransactions = new JTable();
	
	public AccountWindow(Account account, int mode, Controller controller){
		this.account = account;
		this.mode = mode;
		this.controller = controller;
		account.addAccountChangeListener(this);
		
		
		setTitle(account.getPerson().getName() + "'s Account " + account.getSwift());
		
		initData();
		initToolbar();
		
		JPanel content = new JPanel(new BorderLayout());
		JPanel pnlAccount = new JPanel(new BorderLayout());
		JPanel pnlAccountInfo = new JPanel(new GridLayout(3,2));
		pnlAccountInfo.add(lblSwift); pnlAccountInfo.add(tfSwift);
		pnlAccountInfo.add(lblBalance); pnlAccountInfo.add(tfBalance);
		pnlAccountInfo.add(lblDate); pnlAccountInfo.add(tfDate);
		
		pnlAccount.add(pnlAccountInfo, BorderLayout.NORTH);
		pnlAccount.add(new JScrollPane(tblTransactions), BorderLayout.CENTER);

		content.add(toolbar, BorderLayout.NORTH);
		content.add(pnlAccount, BorderLayout.CENTER);
		
		setContentPane(content);
		pack();
		
		tfBalance.setEnabled(false);
		tfSwift.setEnabled(mode == AccountWindow.MODE_INSERT);
		tfDate.setEnabled(false);
		
		setLocationRelativeTo(null);
		
	}
	
	private void initToolbar(){
		if (mode == AccountWindow.MODE_INSERT){
			toolbar.add(controller.getActionsPool().getSaveAccountAction(this));
			toolbar.addSeparator();
		} else {
			toolbar.add(controller.getActionsPool().getTransferMoneyAction(account));
			toolbar.add(controller.getActionsPool().getDepositMoneyAction(account));
			toolbar.add(controller.getActionsPool().getWithdrawMoneyAction(account));
		}
	}

	private void initData() {
		tfBalance.setText(account.getBalanceAsString());
		tfSwift.setText(account.getSwift());
		tfDate.setText(account.getDateAsString());
		
		tblTransactions.setModel(new TransactionsTableModel(account.getTransactions()));

	}
	
	public String getSwift(){
		return tfSwift.getText();
	}

	public Account getShownAccount() {
		return account;
	}

	@Override
	public void accountChanged() {
		tfBalance.setText(account.getBalanceAsString());
	}
}


