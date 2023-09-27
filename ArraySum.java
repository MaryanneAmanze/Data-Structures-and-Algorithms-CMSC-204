
public class ArraySum 
{
	public int sumOfArray (Integer[] a, int index)
	{
		if(a.length == 0)
		{
			System.out.println("Array is empty");
		}
		
		if (index < 0)
		{
			return  0;
		}
		
		int x =  a[index] + sumOfArray(a, index - 1);
		return  x;
		
		
		
		
	}
	
	
	/*for (int i = 0; i <= a.length; i++ )
	{
		
	}
	*/
	/*else if (a.length == 1)
	{
		return a[index] + a[index + 1];
	}
	*/
	/*int x = 0;
	x += a[index];
	*/
	//sumOfArray(a, index - 1);
	
	
	//return index + (a.length - 1);
}
