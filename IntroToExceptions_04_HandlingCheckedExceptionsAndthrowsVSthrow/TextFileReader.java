import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class TextFileReader 
{
	private Scanner inFile = null;
	
	public String ReadFile(File sampleDataFile) throws IOException 
	{
		if (sampleDataFile == null)
		{
			throw new IllegalArgumentException("Sample file cannot be null");
		}
		
		inFile = new Scanner(sampleDataFile);
		
		StringBuilder sb = new StringBuilder();
		while (inFile.hasNextLine())
		{
			String inLine = inFile.nextLine();
			sb.append(String.format("%s\n", inLine));
		}
		return sb.toString();
	}
}
