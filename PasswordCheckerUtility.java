import java.util.*;
/*
 * This class provides password validation and checks for invalid passwords.
 * 
 * @author Maryanne Amanze
 */

public class PasswordCheckerUtility {
	public static int minLength = 6;
	
	
	public PasswordCheckerUtility()
	{
		
		
	}
	
	// try catch block
	// isValidPassword has the order of exceptions 
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{

		
		if (!isValidLength(password))
		{
			throw new LengthException("The password must be at least 6 characters long");
		}
		if (!hasUpperAlpha(password))
		{
			throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
		}
	    if (!hasLowerAlpha(password))
	    {
	    	throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	    }
		if (!hasDigit(password))
		{
			throw new NoDigitException ("The password must contain at least one digit");
		}
		if (!hasSpecialChar(password))
		{
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		if (!noSameCharInSequence(password))
		{
			throw new InvalidSequenceException("The password cannot contain more than two of the same character in sequence.");
		}
			
		
		
	
		return true;
	}
	
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException
	{
		try 
		{
			if (isValidPassword(password))
			{
				
				if(hasBetweenSixAndNineChars​(password))
				{
					throw new WeakPasswordException("The password is OK but weak - it contains fewer than 10 characters");
				}
			} 
		}
		catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException |InvalidSequenceException e)
		{
				System.out.println(e.getMessage());
		}
			
			
		
		return false;
	}
	
	
	
	/*
	 * This method validates a list of passwords and returns a list of invalid passwords with error messages.
	 * 
	 * @param passwords An ArrayList of passwords to be validated. 
	 * @return An ArrayList of invalid passwords with corresponding error messages.
	 */
	
	/*create loop
	   read a string from the file a method to check one password
	 * this method reads from the file.
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (int i = 0; i <passwords.size(); i++)
		{
		
			try 
			{
				isValidPassword(passwords.get(i));
				
				
			} 
			catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException |InvalidSequenceException e)
			{
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage());
			}
		}
		
		return invalidPasswords;
	}
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		// CHANGE THIS AND THROW THE EXCEPTION IN THE GUI INSTEAD
		if (!password.equals(passwordConfirm))
		{
			throw new UnmatchedException("Passwords do not match");
		}
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) 
	{
		if (password.equals(passwordConfirm))
		{
			return true;
		}
		return false;
		
	}
	 
	public static boolean isValidLength(String password) throws LengthException
	{
		if (password.length() < minLength ) 
		{
			throw new LengthException("The password must be at least 6 characters long");
		}
		return true;
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		for (char c: password.toCharArray())
		{
			if (Character.isUpperCase(c))
			{
				return true;
			}
		}
		
		throw new NoUpperAlphaException("The password must contain at least one uppercase alphabetic character");
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		for (char c: password.toCharArray())
		{
			if (Character.isLowerCase(c))
			{
				return true;
			}
		}
		
		throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
	}
	
	public static boolean hasDigit(String password) throws NoDigitException
	{
		char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		for (char digit : digits)
		{
			if (password.contains(String.valueOf(digit)))
			{
				return true;
			}
		}
		throw new NoDigitException("The password must contain at least one digit");
	}

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
    {
    	 String specialChars = "!@#$%^&*()_+{}[]|\\:;\"'<>,.?/";
         
         // Check if any special character is present in the string
         for (char c : password.toCharArray())
         {
        	 if (specialChars.indexOf(c) >= 0)
        	 {
                 return true;
        	 }
         }
             
    	
    	throw new NoSpecialCharacterException("The password must contain at least one special character");
    }
    
    public static boolean noSameCharInSequence(String password) throws InvalidSequenceException
    {
    	
    	for(int i = 0; i < password.length() - 2; i++)
    	{
    		if(password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2))
    		{
    			throw new InvalidSequenceException ("The password cannot contain more than two of the same character in sequence.");
        		
    		}
    		
    	}
    	return true;
	
    } 
    
    
    public static boolean hasBetweenSixAndNineChars​(String password)
    {
    	//boolean bool = false;
    	
    	if(password.length() >= minLength && password.length() <= 9)
    	{
    		return true;
    	}
    	return false;
    }
    
   
}
