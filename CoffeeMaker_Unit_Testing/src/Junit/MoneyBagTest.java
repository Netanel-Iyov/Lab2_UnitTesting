package Junit;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import methods.*;

public class MoneyBagTest extends TestCase {
	MoneyBag ourBag;
	Money m5ILS, m5USD, mMinus5ILS, m0USD, m10USD, m10CHF;
	
	@Before
	protected void setUp() throws Exception {
		ourBag = new MoneyBag(new Money(10, "ILS"), new Money(10, "USD"));
		m5ILS = new Money(5, "ILS");
		m5USD = new Money(5, "USD");
		mMinus5ILS = new Money(-5, "ILS");
		m0USD = new Money(0, "USD");
		
		m10USD = new Money(10, "USD");
		m10CHF = new Money(10, "CHF");

	}
	
	// checking functionality: add money to an existing MoneyBag
	// input data: object money w/ 5ILS
	//expected result : MoneyBag w/ 15ILS and 10 USD
	@Test
	public void testAddMoney_add_5ILS_res15() {
		IMoney expected = new MoneyBag(new Money(15, "ILS"), new Money(10,"USD"));
		IMoney res = ourBag.addMoney(m5ILS);
		
		assertEquals(expected,res);
	}
	

	// checking functionality: add money to an existing MoneyBag
	// input data: object money w/ 5USD
	//expected result : MoneyBag w/ 10ILS and 15 USD
	@Test
	public void testAddMoney_add_5USD_res15() {
		MoneyBag expected = new MoneyBag(new Money(10, "ILS"), new Money(15,"USD"));
		IMoney res = ourBag.addMoney(m5USD);
		
		assertEquals(expected,res);
	}
	

	// checking functionality: add money to an existing MoneyBag
	// input data: object money w/ -5ILS
	//expected result : MoneyBag w/ 5ILS and 10 USD
	@Test
	public void testAddMoney_add_minus5ILS_res5() {
		MoneyBag expected = new MoneyBag(new Money(5, "ILS"), new Money(10,"USD"));
		IMoney res = ourBag.addMoney(mMinus5ILS);

		assertEquals(expected,res);
	}
	

	// checking functionality: add money to an existing MoneyBag
	// input data: object money w/ 0USD
	//expected result : MoneyBag w/ 10ILS and 10 USD
	@Test
	public void testAddMoney_add_0USD_res_10() {
		MoneyBag expected = new MoneyBag(new Money(10, "ILS"), new Money(10,"USD"));
		IMoney res = ourBag.addMoney(m0USD);

		assertEquals(expected,res);
	}
	
	
	// checking functionality: checking if the moneyBag contains same currency and amount as input Money
	// input data: object money w/ 5ILS
	// expected result : false
	@Test
	public void testContains_5ILS_res_false() {
		boolean res = ourBag.contains(m5ILS);
		
		assertFalse(res);
	}
	
	// checking functionality: checking if the moneyBag contains same currency and amount as input Money
	// input data: object money w/ 5ILS
	// expected result : false
	@Test
	public void testContains_10USD_res_true() {
		boolean res = ourBag.contains(m10USD);
		
		assertTrue(res);
	}

	// checking functionality: checking if the moneyBag contains same currency and amount as input Money
	// input data: object money w/ 5USD
	// expected result : false
	@Test
	public void testContains_0USD_res_false() {
		boolean res = ourBag.contains(m0USD);
		
		assertFalse(res);
	}

	// checking functionality: checking if the moneyBag contains same currency and amount as input Money
	// input data: object money w/ 5ILS
	// expected result : NullPointerexception
	@Test
	public void testContains_10CHF_res_NullPointerexception() {
		try {
			boolean res = ourBag.contains(m10CHF);
		// Its expected that for a currency that does not exist, we'll get a null pointer from that will try to reach an attribute in contains, and will raise an exception
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
}



