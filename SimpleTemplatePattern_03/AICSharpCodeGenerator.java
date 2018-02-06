import java.util.Scanner;

public class AICSharpCodeGenerator extends AICodeGenerator
{
	private static Scanner input;
	
	public AICSharpCodeGenerator() {
		input = new Scanner(System.in);
	}
	
	public void writeUnitTests()
	{
		System.out.println("Write Unit Tests using XUnit");
	}
	
	public void writeTheClassAndMethods()
	{
		System.out.println("Write the class and methods in C#");
	}

	public void writeTheUI()
	{
		System.out.println("Now writing the UI in ASP.Net MVC");
	}
	
	@Override
	public boolean refactorMethods()
	{
		System.out.println();
		System.out.println("Would you like to refactor the methods [y/n]");
		String result = input.nextLine();
		
		return result.toLowerCase().startsWith("y");
	}
}
