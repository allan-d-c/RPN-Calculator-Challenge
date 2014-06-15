
public class Variable extends Stackable
{
	String myName;
	double myValue = Double.NaN;
	
	public Variable (String name)
	{
		Preconditions.isNotNull(name);
		myName = name;
	}
	
	@Override
	public void execute() {}

	@Override
	public boolean isNumeric() 
	{
		return true;
	}
	
	public void setValue(double d)
	{
		myValue = d;
	}
	
	public double asNumber()
	{
		throwIfNaN();
		return myValue;
	}

	private void throwIfNaN() 
	{
		if(Double.isNaN(myValue))
			throw new RuntimeException("Variable " + myName + " has a NaN value.");		
	}
}
