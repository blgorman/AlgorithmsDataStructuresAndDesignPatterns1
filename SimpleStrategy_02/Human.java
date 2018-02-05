
public class Human extends Life {
	public Human() {
		super.setBreathingBehavior(new BreatheWithLungs());
		super.setEatingBehavior(new EatFruitsVegetablesAndMeat());
	}
}
