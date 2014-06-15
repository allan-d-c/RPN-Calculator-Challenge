
public class MathPlus extends MathOperator2 
{
	@Override
	protected double doTheMath(Stackable[] args) 
	{
		return args[0].asNumber() + args[1].asNumber();
	}
}
