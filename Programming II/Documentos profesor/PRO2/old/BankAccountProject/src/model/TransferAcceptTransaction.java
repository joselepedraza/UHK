package model;

public class TransferAcceptTransaction extends Transaction {
	private Account source;
	private TransferToTransaction sourceTransaction;

	public TransferAcceptTransaction(Account account, int amount, Account source, TransferToTransaction sourceTransaction) {
		super(account, amount);
		this.source = source;
		this.sourceTransaction = sourceTransaction;
	}

	@Override
	protected int getSign() {
		return 1;
	}

	@Override
	public String getDesc() {
		return "Pøevod z úètu " + source.getSwift();
	}

	public Account getSource() {
		return source;
	}

	public TransferToTransaction getSourceTransaction() {
		return sourceTransaction;
	}

}
