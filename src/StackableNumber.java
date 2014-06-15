
// Critique: better named as StackableNumericLiteral

public class StackableNumber extends Stackable 
{
	private double myValue;

	public StackableNumber(double d)
	{
		myValue = d;
	}
	
	@Override
	public void execute() {}

	@Override
	public boolean isNumeric() 
	{
		return true;
	}

	public double asNumber()
	{
		return myValue;		
	}
}
