
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Maryanne Amanze
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception 
	{
		passwords = new ArrayList<String>();
		
	}

	@After
	public void tearDown() throws Exception
	{
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try 
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Uchechi1"));
			
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthException", false);
		}
		catch(Exception e)
		{
			assertTrue("Threw another exception aside from LengthException", true);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try 
		{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("Uchechi_12"));
		}
		catch (NoUpperAlphaException e)
		{
			//e.printStackTrace();
		}
		try 
		{
			assertFalse(PasswordCheckerUtility.hasUpperAlpha("uchechi_12"));
		}
		catch (NoUpperAlphaException e)
		{
			//e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		 try 
		 {
	         assertFalse(PasswordCheckerUtility.hasLowerAlpha("UCHECHI_12"));
	     } 
		 catch (NoLowerAlphaException e) 
		 {
	            
	      
		 }
		 try 
		 {
	         assertTrue(PasswordCheckerUtility.hasLowerAlpha("Uchechi_12"));
	     } 
		 catch (NoLowerAlphaException e) 
		 {
	            
	      
		 }
	     
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try 
		{
            assertFalse(PasswordCheckerUtility.isWeakPassword("Uchechi_12"));
        } 
		catch (WeakPasswordException e) 
		{
            
        }
		
		try
		{
			assertTrue(PasswordCheckerUtility.isWeakPassword("Uche_1"));
		}
		catch(WeakPasswordException e)
		{
			
		}
		
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.noSameCharInSequence("Uchechi_12"));
		}
		catch (InvalidSequenceException e)
		{
			
		}
		
		try
		{
			assertFalse(PasswordCheckerUtility.noSameCharInSequence("Uchechhhi_12"));
		}
		catch (InvalidSequenceException e)
		{
			
		}
		
		
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		 try 
		 {
	         assertTrue(PasswordCheckerUtility.hasDigit("Uchechi_12"));
	     } 
		 catch (NoDigitException e) 
		 {

	            
	     } 
		 try 
		 {
	         assertFalse(PasswordCheckerUtility.hasDigit("UchechiAma_"));
	     } 
		 catch (NoDigitException e) 
		 {

	            
	     } 
		 
		
		//fail("Not implemented by student yet");
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Uchechi_12"));
		}
		catch (Exception e)
		{
			
		}
		
		try
		{
			assertFalse(PasswordCheckerUtility.isValidPassword("Uchechi12"));
		}
		catch (Exception e)
		{
			
		}
		
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() 
	{
		passwords.add("Uchechi12");
		passwords.add("uchechi_12");
		passwords.add("Uchechi_12");
		
		ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		//assertEquals(invalidPasswords.get(1), "uchechi_12  The password must contain at least one uppercase alphabetic character");
		assertEquals(invalidPasswords.size(), 2);
		assertFalse(invalidPasswords.isEmpty());
		//fail("Not implemented by student yet");
	}
	
}
