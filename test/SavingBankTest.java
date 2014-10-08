import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tutorial.tutorial10Week10.SavingsAccount;
import tutorial.tutorial10Week10.TermDepositAccount;

@RunWith(Parameterized.class)
public class SavingBankTest {

	private static double binitial=1000;
	private static double binitial2=1000;
	private static double binitial3=1000;
	private static double binitial4=1000;
	
	private static SavingsAccount bankAccount=new SavingsAccount(1.0);
	private static TermDepositAccount bankAccount2=new TermDepositAccount(5.0,1);
	private static TermDepositAccount bankAccount3=new TermDepositAccount(2.0,0);
	private static TermDepositAccount bankAccount4=new TermDepositAccount(5.0,2);
	
	@Parameters
    public static Iterable<Object[]> data() {
    	bankAccount.deposit(binitial);
    	bankAccount2.deposit(binitial2);
    	bankAccount3.deposit(binitial3);
    	bankAccount4.deposit(binitial4);
        return Arrays.asList(new Object[][] { { bankAccount,1010.0,990.0 },
        		{ bankAccount2,1050.0,1030.0 },
        		{ bankAccount3,1020.0,1000.0 },
        		{ bankAccount4,1050.0,1025.0 }});
    }

    @Parameter(0)
    public SavingsAccount account;
    @Parameter(1)
    public double ibalace;
    @Parameter(2)
    public double fbalace;
    
    
	@Test
	public void testAddInterest() {
		account.addInterest();
		assertEquals(ibalace, account.getBalance(),0);
	}

	@Test
	public void testWithDraw(){
		account.withdraw(20.0);
		assertEquals(fbalace, account.getBalance(),0);
	}

}
