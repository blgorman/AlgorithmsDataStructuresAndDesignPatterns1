
public class AIJavaCodeGenerator 
{
	public void writeCode()
	{
		writeUnitTests();
		writeTheClassAndMethods();
		refactorTheTests();
		refactorTheMethods();
		writeTheUI();
	}
	
	public void writeUnitTests()
	{
		System.out.println("Write Unit Tests using JUnit");
	}
	
	public void writeTheClassAndMethods()
	{
		System.out.println("Write the class and methods in Java");
	}
	public void refactorTheTests()
	{
		System.out.println("Now refactoring the tests...");
	}
	public void refactorTheMethods()
	{
		System.out.println("Now refactoring the methods...");
	}
	public void writeTheUI()
	{
		System.out.println("Now writing the UI in Spring MVC");
	}
}
