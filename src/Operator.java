
public abstract class Operator extends Stackable
{
	// Critique: better name is popMe()
	protected void throwUnlessImOnTopThenPop()
	{
		throwUnlessAtLeastN(1);
		
		Stackable me = myStack.pop();
		if (this != me)
			throw new RuntimeException("I should be at the TOS - something is wrong. Offender is "+me);				
	}

	@Override
	public boolean isNumeric() 
	{
		return false;
	}
}
