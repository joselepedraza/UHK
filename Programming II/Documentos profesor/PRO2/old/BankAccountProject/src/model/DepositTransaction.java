package model;

public class DepositTransaction extends Transaction {

	public DepositTransaction(Account account, int amount) {
		super(account, amount);
	}

	@Override
	protected int getSign() {
		return 1;
	}

	@Override
	public String getDesc() {
		return "Deposit";
	}

}
