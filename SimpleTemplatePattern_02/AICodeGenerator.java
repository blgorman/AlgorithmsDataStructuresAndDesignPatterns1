
public abstract class AICodeGenerator 
{
	public final void writeCode()
	{
		writeUnitTests();
		writeTheClassAndMethods();
		refactorTheTests();
		refactorTheMethods();
		writeTheUI();
	}
	
	public abstract void writeUnitTests();
	public abstract void writeTheClassAndMethods();
	
	public void refactorTheTests()
	{
		System.out.println("Now refactoring the tests...");
	}
	
	public void refactorTheMethods()
	{
		System.out.println("Now refactoring the methods...");
	}
	
	public abstract void writeTheUI();
}
