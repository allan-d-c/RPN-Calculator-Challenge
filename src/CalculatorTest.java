import org.junit.Test;

// Critique: need a lot more test cases for Calculator class
// Critique: need unit test coverage for individual classes
// Critique: need for speed caused skipping TDD 

public class CalculatorTest 
{
	private static final double EPSILON = 0.001; // arbitrary

	private void assertSame(double expected, double found)
	{
		double diff = expected-found;
		if (Math.abs(diff) > EPSILON)
			throw new RuntimeException("Expected: "+expected+" Found: "+found);
	}
	
	@Test
	public void SimpleAdditionWorks() throws Exception
	{
		Calculator calculator = new Calculator();
		double result = calculator.calculate("3 4 +");
		assertSame(7.0, result);
	}
	
	@Test
	public void TwoOperatorExpressionWorks() throws Exception
	{
		Calculator calculator = new Calculator();
		double result = calculator.calculate("3 4 + 2 *");
		assertSame(14.0, result);
	}
	
	@Test
	public void CanAssignToAVariable() throws Exception
	{
		Calculator calculator = new Calculator();
		calculator.calculate("3 abc = 1"); // required need to leave a number on the stack to return
		double value = calculator.lookup("abc");
		assertSame(3, value);
	}
	
	@Test
	public void CanUseVariableInExpression() throws Exception
	{
		Calculator calculator = new Calculator();
		double result = calculator.calculate("3 abc = 5 def = abc def *");
		assertSame(15, result);
	}
}
