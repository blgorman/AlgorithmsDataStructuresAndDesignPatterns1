
public class Fish extends Life {
	public Fish() {
		super.setBreathingBehavior(new BreathingWithGills());
		super.setEatingBehavior(new EatWorms());
	}

}
