
public class Driver {

	public static void main(String[] args) {
		Life[] livingThings = new Life[3];
		
		livingThings[0] = new Human();
		livingThings[1] = new Fish();
		livingThings[2] = new Android();
		
		for (Life living : livingThings)
		{
			System.out.println(living.Breathe());
			System.out.println(living.Eat());
		}
		

	}

}
