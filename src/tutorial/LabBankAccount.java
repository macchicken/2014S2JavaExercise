package tutorial;

// tutorial 6 week 7

public class LabBankAccount {

	private int accountNumber;
	private double balance;
	private String ownerName;

	/**
	 * Constructs a bank account with a zero balance
	 * 
	 * @param anAccountNumber
	 *            the account number for this account
	 */
	public LabBankAccount(int anAccountNumber) {
		accountNumber = anAccountNumber;
		balance = 0;
		ownerName = "";
	}

	/**
	 * Constructs a bank account with a given balance
	 * 
	 * @param anAccountNumber
	 *            the account number for this account
	 * @param initialBalance
	 *            the initial balance
	 */
	public LabBankAccount(int anAccountNumber, double initialBalance) {
		accountNumber = anAccountNumber;
		balance = initialBalance;
		ownerName = "";
	}

	/**
	 * Constructs a bank account with a given balance and an owner name
	 * 
	 * @param anAccountNumber
	 *            the account number for this account
	 * @param initialBalance
	 *            the initial balance
	 * @param ownerName
	 * 			  an owner name
	 */
	public LabBankAccount(int accountNumber, double balance, String ownerName) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.ownerName = ownerName;
	}

	/**
	 * Gets the account number of this bank account.
	 * 
	 * @return the account number
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount
	 *            the amount to deposit
	 */
	public void deposit(double amount) {
		double newBalance = balance + amount;
		balance = newBalance;
	}

	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount
	 *            the amount to withdraw
	 */
	public void withdraw(double amount) {
		double newBalance = balance - amount;
		balance = newBalance;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}

	public String getOwnerName() {
		return ownerName;
	}
	
	public String toString(){
		return "Owner: "+ownerName+"; accountNumber: "+accountNumber+"; balance: "+balance;
	}
}
