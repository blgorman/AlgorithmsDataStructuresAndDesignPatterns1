
public class Driver {
	
	public static void main(String[] args)
	{
		String s1 = null;
		
		try
		{
			System.out.println("Starting try");
			if (s1.equalsIgnoreCase("anything"))
			{
				System.out.println("it's equal");
			}
			System.out.println("Ending try");
		}
		catch(Exception ex)
		{
			System.out.println("Caught the null pointer exception");
		}
		finally
		{
			System.out.println("In the finally block");
		}
		
		System.out.println("Completed");
		
		
		
	}
	
}
