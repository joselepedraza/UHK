package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Account;
import model.AccountList;
import model.PersonalAccountList;

public class TransferWindow extends JDialog implements ActionListener {
	public static final int CO_CONFIRM = 1;
	public static final int CO_CANCEL = 2;
	
	private int closeOption;
	
	private JLabel lblDestAccount = new JLabel("Desc account");
	private JLabel lblAmount = new JLabel("Amount");
	private JComboBox<Account> cbDestAccount = new JComboBox<Account>();
	private AccountsListModel listModel;
	
	private JTextField tfAmount = new JTextField(30);
	private JButton btnOK = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	
	
	
	public TransferWindow(AccountList accounts){
		super ((JFrame)null, "Transfer", true);
		listModel = new AccountsListModel(accounts);
		cbDestAccount.setModel(listModel);
		btnCancel.addActionListener(this);
		btnOK.addActionListener(this);
		
		JPanel pnlContent = new JPanel(new BorderLayout());
		JPanel pnlTransferInfo = new JPanel(new GridLayout(3,2));
		pnlTransferInfo.add(lblDestAccount);pnlTransferInfo.add(cbDestAccount);
		pnlTransferInfo.add(lblAmount);pnlTransferInfo.add(tfAmount);
		JPanel pnlButtons = new JPanel();
		pnlButtons.add(btnOK);pnlButtons.add(btnCancel);
		
		pnlContent.add(pnlTransferInfo, BorderLayout.CENTER);
		pnlContent.add(pnlButtons, BorderLayout.SOUTH);
		
		setContentPane(pnlContent);
		pack();
		
		setLocationRelativeTo(null);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOK){
			closeOption = CO_CONFIRM;
		} else {
			closeOption = CO_CANCEL;
		}
		setVisible(false);
	}



	public int getCloseOption() {
		return closeOption;
	}
	
	public static TransferWindow showWindow(AccountList accounts){
		TransferWindow w = new TransferWindow(accounts);
		w.setVisible(true);
		return w;
	}



	public int getAmount() {
		int res = 0;
		try {
		   res = Integer.parseInt(tfAmount.getText());
		} catch (NumberFormatException ex){
				// not a proper number in the edit box but never mind
		}
		return res;

	}



	public Account getDestinationAccount() {
		return listModel.getElementAt(cbDestAccount.getSelectedIndex());
	}

}
