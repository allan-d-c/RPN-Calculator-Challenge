import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

// Critique: lack of at least orientation comments

public class Calculator
{
	// Critique: regretted the choice of name for the below field. Maybe better as myEvaluation.
	
	Stack<Stackable> myEvaluator = new Stack<Stackable>();
	Map<String,Variable> myVariables = new HashMap<String,Variable>();
	
	public double calculate(String expression) throws Exception
	{		
		List<String> tokens = tokenize(expression);
		Preconditions.isFalse(tokens.isEmpty());
		
		for(String token : tokens)
		{
			Stackable item = StackableFactory.create(token, myVariables);
			item.pushOnto(myEvaluator);
			item.execute();
		}
		
		// Critique: name should be throwUnlessSingleStackable() below
		
		throwUnlessSingleton(myEvaluator);
		throwUnlessNumeric(myEvaluator);
		
		double result = fetchResult(myEvaluator);
		return result;
	}

	// Critique: used for unit testing only. You don't want production code that is for testing only.
	
	public double lookup(String variable)
	{
		if (myVariables.containsKey(variable))
			return myVariables.get(variable).asNumber();
		return Double.NaN;
	}
	
	// Critique: scanner is not the best tokenizing technique but works for a demo
	
	private List<String> tokenize(String expression) 
	{
		Preconditions.isNotNull(expression);
		
		Scanner tokenizer = new Scanner(expression);
		List<String> tokens = new ArrayList<String>();

		while (tokenizer.hasNext())
		{
			String token = tokenizer.next();
			tokens.add(token);
		}
		
		return tokens;
	}

	// Critique: these "throw" helpers probably could reside on a "better stack" class
	// Critique: could turn RuntimeExceptions into subclass exceptions and avoid all of the i18n issues
	
	private void throwUnlessSingleton(Stack<Stackable> stack)
	{
		throwUnlessSizeN(stack, 1);
	}
	
	private void throwUnlessSizeN(Stack<Stackable> stack, int required)
	{		
		int size = stack.size();
		if (size != required)
			throw new RuntimeException("Stack size expected to be " + required + ", not " + size);
	}

	private void throwUnlessNumeric(Stack<Stackable> stack) 
	{
		throwUnlessSizeN(stack, 1);
		Stackable tos = stack.get(0);
		if (!tos.isNumeric())
			throw new RuntimeException("Stack result expected to be numeric, but was not (found "+ tos + ")");
	}

	// Critique: style issue - assigning to variable before returning it is just an aid for debugging 
	
	private double fetchResult(Stack<Stackable> stack) 
	{
		throwUnlessSizeN(stack, 1);
		Stackable tos = stack.get(0);

		double result = tos.asNumber();		
		return result;
	}
}
