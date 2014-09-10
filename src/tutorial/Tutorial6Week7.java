package tutorial;

import java.util.ArrayList;

public class Tutorial6Week7 {
	
	public static void testLabBankAccount(){
		ArrayList<LabBankAccount> accounts= new ArrayList<LabBankAccount>(10);
		accounts.add(new LabBankAccount(1,100));
		accounts.add(new LabBankAccount(12,200.88));
		accounts.add(new LabBankAccount(703,197.23));
		for (LabBankAccount acc:accounts){
			System.out.println(acc.getBalance()+" - "+acc.getAccountNumber());
		}
		Bank bank=new Bank(10);
		bank.addAccount(new LabBankAccount(1,100,"Barry"));
		bank.addAccount(new LabBankAccount(12,200.88,"Brian"));
		bank.addAccount(new LabBankAccount(703,197.23,"Gary"));
		bank.addAccount(new LabBankAccount(705,300,"Scott"));
		bank.addAccount(new LabBankAccount(708,150,"Laurie"));
		Object[] accounts2=bank.sort();
		for (Object acc:accounts2){
			System.out.println(acc);
		}
		System.out.println();
		LabBankAccount testa=(LabBankAccount) accounts2[0];
		System.out.println("modify a element in this sorted array");
		//Despite the primitive type,using the toArray() to make an array,
		//each element in this array references to the element in the collection
		testa.deposit(1);
		System.out.println("display the content of original collection");
		ArrayList<LabBankAccount> accounts3=bank.getAccounts();
		for (LabBankAccount acco:accounts3){
			System.out.println(acco);
		}
		System.out.println("retrive Scott account");
		System.out.println(bank.getAccount("Scott"));
	}

	public static void testText(){
		System.out.println("input some words");
		java.util.Scanner console=new java.util.Scanner(System.in);
		String input=console.nextLine();
		java.util.Scanner textSc=new java.util.Scanner(input);
		Text text=new Text(100);
		while(textSc.hasNext()){
			text.addWord(textSc.next());
		}
		textSc.close();
		System.out.println("search a word");
		input=console.next();
		console.close();
		text.search(input);
		int[] index={1,2,12};																	
		text.searchByIndex(index);
	}

	public static void main(String args[]){
		testLabBankAccount();
//		testText();
	}
}
