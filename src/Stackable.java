import java.util.Stack;

// Critique: did not have time to effectively use interfaces

public abstract class Stackable 
{
	Stack<Stackable> myStack = null;
	
	public void pushOnto(Stack<Stackable> stack) 
	{
		myStack = stack;
		myStack.push(this);
	}

	public abstract void execute(); 

	protected void throwUnlessAtLeastN(int required)
	{
		// Critique: this precondition should be in the method above 
		Preconditions.isNotNull(myStack);
		
		if (myStack.size() < required)
			throw new RuntimeException("Need at least " + required + "arguments on stack, not " + myStack.size());
	}
	
	// Critique: this probably would be better on a "smart stack" class
	
	protected Stackable[] popN(int n)
	{
		Preconditions.isPositive(n);
		throwUnlessAtLeastN(n);
		
		Stackable[] results = new Stackable[n];
		
		for (int i = 0; i< n; i++)
		{
			results[i] = myStack.pop();
		}
		
		return results;
	}
	
	// Critique: better name might be isResolvableToNumber()
	
	public abstract boolean isNumeric(); 

	// Critique: decided to use NaN. another consideration might be to throw.
	
	public double asNumber()
	{
		return Double.NaN;
	}
}
