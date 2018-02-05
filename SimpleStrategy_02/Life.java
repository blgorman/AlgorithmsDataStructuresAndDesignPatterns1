
public abstract class Life implements BreathingBehavior, EatingBehavior {
	private BreathingBehavior breathingAbility;
	private EatingBehavior eatingAbility;
	
	public Life()
	{
		this(null, null);
	}
	
	public Life(EatingBehavior value)
	{
		this(value, null);
	}
	
	public Life(BreathingBehavior value)
	{
		this(null, value);
	}
	
	public Life(EatingBehavior eatingBehavior, BreathingBehavior breathingBehavior)
	{
		this.eatingAbility = eatingBehavior == null ? new NoEatingAbility() : eatingBehavior;
		this.breathingAbility = breathingBehavior == null ? new NoBreathingAbility() : breathingBehavior;
	}
	
	public void setEatingBehavior(EatingBehavior value)
	{
		eatingAbility = value;
	}
	
	public void setBreathingBehavior(BreathingBehavior value)
	{
		breathingAbility = value;
	}
	
	public String Breathe()
	{
		return breathingAbility.Breathe();
	}
	
	public String Eat()
	{
		return eatingAbility.Eat();
	}
}
