import java.util.HashMap;
import java.util.Map;


public class StackableFactory
{
	protected final static Map<String,Class<?>> myOperators = new HashMap<String,Class<?>>();
	
	static
	{
		myOperators.put("=", Assign.class);
		myOperators.put("+", MathPlus.class);
		myOperators.put("*", MathMultiply.class);
	}
	
	public static Stackable create(String token, Map<String, Variable> variables) throws Exception
	{
		if (myOperators.containsKey(token))
		{
			Class<?> clazz = myOperators.get(token);
			return (Stackable)clazz.newInstance();
		}
		else
		{
			try
			{
				double value = Double.valueOf(token);
				return new StackableNumber(value);
			}
			catch(NumberFormatException e)
			{
				if (!variables.containsKey(token))
					variables.put(token, new Variable(token));

				return variables.get(token);
			}
		}
	}
}
