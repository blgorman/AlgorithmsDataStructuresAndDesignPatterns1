
public class CodeGenerationSystem 
{
	public static void main(String[] args)
	{
		AICSharpCodeGenerator cs = new AICSharpCodeGenerator();
		AIJavaCodeGenerator jv = new AIJavaCodeGenerator();
		
		cs.writeCode();
		jv.writeCode();
	}
	
}
