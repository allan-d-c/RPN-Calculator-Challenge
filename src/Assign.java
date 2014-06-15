
// Critique: embedded English strings could pose an i18n issue later

public class Assign extends Stackable 
{
	@Override
	public void execute() 
	{
		popN(1); // me		
		Stackable[] args = popN(2);
		throwUnlessStackableIsType(args[0], Variable.class);
		throwUnlessNumeric(args[1]);
		
		Variable v = (Variable) args[0];
		v.setValue(args[1].asNumber());
	}

	@Override
	public boolean isNumeric() 
	{
		return false;
	}

	// Critique: these two methods have low cohesion to the class and probably should be moved
	
	private void throwUnlessNumeric(Stackable stackable) 
	{
		if (!stackable.isNumeric())
			throw new RuntimeException("Expected numeric second value in assignment.");
	}

	private void throwUnlessStackableIsType(Stackable stackable, Class<?> clazz) 
	{
		if (!stackable.getClass().equals(clazz))
			throw new RuntimeException("Assignment expected first argument is of kind "+clazz.getName() + " not " + stackable.getClass());
	}
}
