package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import library.Account;

public class AccountTest {

	Account account;
	
	@Before
	public void setUp() {
		account = new Account();
	}
	
	@Test
	public void povecajBrojPosudjenihKnjigaTest() {
		account.povecajBrojPosudjenjihKnjiga();
		int result = account.getBrojPosudjenihKnjiga();
		assertEquals(1, result);
	}
	
	@Test
	public void smanjiBrojPosudjenihKnigaTest() {
		account.povecajBrojPosudjenjihKnjiga();
		account.povecajBrojPosudjenjihKnjiga();
		account.povecajBrojPosudjenjihKnjiga();
		try {
			account.smanjiBrojPosudjenihKnjiga();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(2, account.getBrojPosudjenihKnjiga());
		
	}
	
	@Test(expected = Exception.class)
	public void smanjiBrojPosudjenihKnjigaWhenBrojKnjigaIs0Test() throws Exception{
		account.smanjiBrojPosudjenihKnjiga();
	}
	
	@Test
	public void setNameTest() {
		account.setName("Zgembo");
		assertEquals("Zgembo", account.getName());
	}

}
