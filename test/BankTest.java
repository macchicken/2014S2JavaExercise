import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tutorial.tutorial10Week10.BankAccount;
import tutorial.tutorial10Week10.SavingsAccount;
import tutorial.tutorial10Week10.TermDepositAccount;

@RunWith(Parameterized.class)
public class BankTest {

	private static double binitial=1000;
	private static double binitial2=1000;
	private static double binitial3=1000;
	
	private static BankAccount bankAccount=new BankAccount(binitial);
	private static SavingsAccount bankAccount2=new SavingsAccount(0.01);
	private static TermDepositAccount bankAccount3=new TermDepositAccount(0.02,3);
	
	@Parameters
    public static Iterable<Object[]> data() {
    	bankAccount2.deposit(binitial2);
    	bankAccount3.deposit(binitial3);
        return Arrays.asList(new Object[][] { { bankAccount,30.0,970.0,1000.0 },
        		{ bankAccount2,100.0,900.0,1000.0 },
        		{ bankAccount3,200.0,795.0,995.0 }});
    }

    @Parameter(0)
    public BankAccount account;
    @Parameter(1)
    public double money;
    @Parameter(2)
    public double wbalace;
    @Parameter(3)
    public double fbalace;
    
	@Test
	public void testWithDraw() {
		account.withdraw(money);
		assertEquals(wbalace, account.getBalance(),0);
	}

	@Test
	public void testDeposit(){
		account.deposit(money);
		assertEquals(fbalace, account.getBalance(),0);
	}

}
