
/**
 * This is a custom exception class that represents when the Password and Retyped Passwords do not match.
 * It is thrown when when the Password and Retyped Passwords do not match.
 */

public class UnmatchedException extends Exception
{
	/**
     * Constructs a new UnmatchedException with a specified message.
     *
     * @param message The message explaining the reason for the exception.
     */
	public UnmatchedException ()
	{
		super("The passwords do not match");
	}
	public UnmatchedException (String message)
	{
		super(message);
		
	}
}
