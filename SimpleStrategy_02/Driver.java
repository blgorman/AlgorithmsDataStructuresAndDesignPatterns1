
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
		
		Human h = (Human)livingThings[0];
		
		System.out.println("Human default breathing: " + h.Breathe());
		System.out.println("Human default eating: " + h.Eat());
		
		h.setBreathingBehavior(new NoBreathingAbility());
		h.setEatingBehavior(new NoEatingAbility());
		
		System.out.println("Human new breathing: " + h.Breathe());
		System.out.println("Human new eating: " + h.Eat());

		h.setBreathingBehavior(new BreathingWithGills());
		System.out.println("Human new breathing: " + h.Breathe());
		
		h.setBreathingBehavior(new BreatheWithLungs());
		h.setEatingBehavior(new EatFruitsVegetablesAndMeat());
		
		System.out.println("Human default breathing: " + h.Breathe());
		System.out.println("Human default eating: " + h.Eat());
	}

}
