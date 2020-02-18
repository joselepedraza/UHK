package model;

public class TransferToTransaction extends Transaction {
	private Account dest;
	private TransferAcceptTransaction acceptTransaction;

	public TransferToTransaction(Account account, int amount, Account dest) {
		super(account, amount);
		this.dest = dest;
		acceptTransaction = new TransferAcceptTransaction(dest, amount, getAccount(), this);
	}

	@Override
	protected int getSign() {
		return -1;
	}

	@Override
	public String getDesc() {
		return "Pøevod na úèet " + dest.getSwift();
	}

	public Account getDestAccount() {
		return dest;
	}

	public TransferAcceptTransaction getAcceptTransaction() {
		return acceptTransaction;
	}

}
