package util;

import tutorial.LabBankAccount;

public class LabBankAccountComparator extends AbstractObjectComparator {

	@Override
	public int compare(Object o1, Object o2) {
		LabBankAccount acc1=(LabBankAccount) o1;
		LabBankAccount acc2=(LabBankAccount) o2;
		return Double.compare(acc1.getBalance(), acc2.getBalance());
	}

}
