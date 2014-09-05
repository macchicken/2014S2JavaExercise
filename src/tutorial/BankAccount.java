package tutorial;

// Tutorial5 Week6

/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */
public class BankAccount {

	// instance fields
	private double balance;
	String owner;
	private double rate=0;

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
		owner = null;
	}

	/**
	 * Constructs a bank account for the user with a given balance.
	 */
	public BankAccount(String name, double initialBalance) {
		balance = initialBalance;
		owner = name;
	}
	
	/**
	 * Constructs a bank account for the user with a given balance and an interest rate.
	 */
	public BankAccount(String owner, double balance, double rate) {
		this.balance = balance;
		this.rate = rate;
		this.owner = owner;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount
	 *            the amount to deposit
	 */
	public void deposit(double amount) {
		if (amount > 0)
			balance = balance + amount;
	}

	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount
	 *            the amount to withdraw
	 */
	public void withdraw(double amount) {
		if (balance >= amount)
			balance = balance - amount;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Gets the current balance of the bank account at the end of the month
	 * according to the interest rate.
	 * 
	 * @return the current actual balance
	 */
	public double calBalance(){
		return balance*(1+(rate/100));
	}
}
