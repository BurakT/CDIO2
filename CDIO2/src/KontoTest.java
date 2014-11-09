import static org.junit.Assert.*;
import org.junit.Test;

public class KontoTest 
{
	@Test
	public void testStartBalance() 
	{
		Konto testKontoen = new Konto();
		assertEquals(0,testKontoen.getBalance());
	}
	@Test
	public void testSetBalance() 
	{
		Konto testKontoen = new Konto();
		String testString= testKontoen.setBalance(1000);
		assertEquals("Balance korrekt ændret",testString);
		assertEquals(1000,testKontoen.getBalance());
	}
	@Test
	public void testSetBalanceFejl() 
	{
		Konto testKontoen = new Konto();
		String testString= testKontoen.setBalance(-1);
		assertEquals("intastet var mindre end nul. Balance sat til nul.",testString);
		assertEquals(0,testKontoen.getBalance());
	}
	@Test
	public void testIncrementBalance() 
	{
		Konto testKontoen = new Konto();
		testKontoen.setBalance(1000);
		String testString= testKontoen.incrementBalance(1000);
		assertEquals("Balance korrekt ændret",testString);
		assertEquals(2000,testKontoen.getBalance());
	}
	@Test
	public void testDecrementBalance() 
	{
		Konto testKontoen = new Konto();
		testKontoen.setBalance(1000);
		String testString= testKontoen.decrementBalance(900);
		assertEquals("Balance korrekt ændret",testString);
		assertEquals(100,testKontoen.getBalance());
	}
	@Test
	public void testDecrementBalanceFejl() 
	{
		Konto testKontoen = new Konto();
		testKontoen.setBalance(1000);
		String testString= testKontoen.decrementBalance(1100);
		assertEquals("Balance blev negativ. Balance er nu sat til nul.",testString);
		assertEquals(0,testKontoen.getBalance());
	}
	@Test
	public void testTransaktionTilBalancePositiv() 
	{
		Konto testKontoen = new Konto();
		testKontoen.setBalance(500);
		String testString= testKontoen.transaktionTilBalance(500);
		assertEquals("Balance korrekt ændret",testString);
		assertEquals( 1000 ,testKontoen.getBalance());
	}
	@Test
	public void testTransaktionTilBalanceNegativ() 
	{
		Konto testKontoen = new Konto();
		testKontoen.setBalance(500);
		String testString= testKontoen.transaktionTilBalance(-500);
		assertEquals("Balance korrekt ændret",testString);
		assertEquals( 0 ,testKontoen.getBalance());
	}
	@Test
	public void testTransaktionTilBalanceFejl() 
	{
		Konto testKontoen = new Konto();
		testKontoen.setBalance(500);
		String testString= testKontoen.transaktionTilBalance(-550);
		//assertEquals("intastet var mindre end nul. Balance sat til nul.",testString);
		assertEquals("Balance blev negativ. Balance er nu sat til nul.",testString);
		assertEquals( 0 ,testKontoen.getBalance());
	}
}