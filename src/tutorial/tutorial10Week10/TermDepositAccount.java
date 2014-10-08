package tutorial.tutorial10Week10;

public class TermDepositAccount extends SavingsAccount {

	private int maturityMonth=0;
	private static double penatly=5.0;//charge the withdrawal penalty
	
	public TermDepositAccount(double rate, int maturityMonth) {
		super(rate);
		this.maturityMonth = maturityMonth;
	}

	public int getMaturityMonth() {
		return maturityMonth;
	}

	@Override
	public void addInterest() {
		if (maturityMonth>0){maturityMonth--;}
		super.addInterest();
	}

	@Override
	public void withdraw(double amount) {
		if (maturityMonth>0){amount+=penatly;}
		super.withdraw(amount);
	}


}
