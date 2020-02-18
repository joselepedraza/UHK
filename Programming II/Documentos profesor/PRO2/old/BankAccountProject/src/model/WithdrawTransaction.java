package model;

public class WithdrawTransaction extends Transaction {

	public WithdrawTransaction(Account acount, int amount) {
		super(acount, amount);
	}

	@Override
	protected int getSign() {
		return -1;
	}

	@Override
	public String getDesc() {
		return "Withdraw";
	}

}
