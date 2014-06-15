
public abstract class MathOperator2 extends Operator 
{
	@Override
	public void execute() 
	{
		throwUnlessImOnTopThenPop();
		
		Stackable[] args = popN(2);
		Stackables.areNumeric(args);
		
		double value = doTheMath(args);
		myStack.push(new StackableNumber(value));
	}

	protected abstract double doTheMath(Stackable[] args);
}
