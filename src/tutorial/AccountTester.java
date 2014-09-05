package tutorial;

// Tutorial5 Week6

public class AccountTester {

	public static void main(String[] args) {
		BankAccount tester1= new BankAccount("tester1",5000,0.4);
		BankAccount tester2= new BankAccount("tester2",6000,0.3);
		System.out.println("tester1 initial balance: $"+tester1.getBalance());
		System.out.println("tester2 initial balance: $"+tester2.getBalance());
		double money1=200;
		double money2=300;
		System.out.println("tester1 withdraw "+money1);
		tester1.withdraw(money1);
		System.out.println("tester2 withdraw "+money2);
		tester2.withdraw(money2);
		money1=400;
		money2=500;
		System.out.println("tester1 deposit "+money1);
		tester1.withdraw(money1);
		System.out.println("tester2 deposit "+money2);
		tester2.withdraw(money2);
		System.out.println("balance of tester1 at the end of month: $"+tester1.calBalance());
		System.out.println("balance of tester2 at the end of month: $"+tester2.calBalance());
	

		// test of Staff class for biweekly salary
		Staff staff1=new Staff("Staff1",0,5);
		System.out.println(staff1.getName()+" with paid rate "+staff1.getHourlyRate()+" starts to work");
		staff1.setHours(30);
		System.out.println(staff1.getName()+" worked "+staff1.getHours()+" this week");
		double salary1=staff1.getSalary();
		staff1.setHours(45);
		System.out.println(staff1.getName()+" worked "+staff1.getHours()+" this week");
		System.out.println(staff1.getName()+" these 2 weeks salary: "+(salary1+staff1.getSalary()));
	}

}
