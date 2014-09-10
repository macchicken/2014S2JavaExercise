package tutorial;

import java.util.ArrayList;

import util.LabBankAccountComparator;
import util.tools;


public class Bank {

	private ArrayList<LabBankAccount> accounts;

	public Bank(int capacity) {
		if (capacity>0){
			this.accounts = new ArrayList<LabBankAccount>(capacity);
		}else{
			this.accounts = new ArrayList<LabBankAccount>();
		}
	}

	public ArrayList<LabBankAccount> getAccounts() {
		return accounts;
	}

	/*
	 * Adding a new bank account
	 */
	public boolean addAccount(LabBankAccount account){
		return accounts.add(account);
	}

	/*
	 * Removal of a bank account according to the given accountNumber
	 */
	public boolean removeAccount(int accountNumber){
		for (LabBankAccount acc:accounts){
			if (acc.getAccountNumber()==accountNumber){
				return accounts.remove(acc);
			}
		}
		return false;
	}
	
	/*
	 * Retrieval of a bank account based on a given owner name
	 */
	public LabBankAccount getAccount(String ownerName){
		for (LabBankAccount acc:accounts){
			if (acc.getOwnerName().equals(ownerName)){
				return acc;
			}
		}
		return null;
	}
	/*
	 * Sorting the accounts according to accounts balances in an ascent order
	 */
	public Object[] sort(){
		Object[] result= accounts.toArray();
		tools.quickSort(result, 0, result.length-1, new LabBankAccountComparator());
		return result;
	}
}
