
public class Driver {
	
	public static void main(String[] args)
	{
		String s1 = null;
		int x = 10;
		int y = 0;
		
		try
		{
			System.out.println("Starting try");
			if (s1.equalsIgnoreCase("anything"))
			{
				System.out.println("it's equal");
			}
			System.out.println("Ending try");
		}
		catch(NullPointerException npex)
		{
			try 
			{
				int z = x / y;
			}
			catch(ArithmeticException iaex)
			{
				System.out.println("Bad math in catch!");
			}
			
			System.out.println("Make sure to instantiate your variables!");
		}
		catch(ArithmeticException aex)
		{
			System.out.println("Bad math!");
		}
		catch(Exception ex)
		{
			System.out.println("Caught the general exception");
		}
		
		finally
		{
			System.out.println("In the finally block");
		}
		
		System.out.println("Completed");
		
		
		
	}
	
}
