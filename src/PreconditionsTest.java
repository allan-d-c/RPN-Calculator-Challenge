import org.junit.Test;


public class PreconditionsTest 
{
	@Test
	public void isTrueShouldNotThrowForTrue()
	{
		Preconditions.isTrue(true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void isTrueShouldThrowForFalse()
	{
		Preconditions.isTrue(false);
	}
	
	@Test
	public void areTrueShouldNotThrowForTrues()
	{
		Preconditions.areTrue(true, true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void areTrueShouldThrowForAnyFalse()
	{
		Preconditions.areTrue(true, false);
	}
	
	@Test
	public void isNotNullShouldNotThrowForNonNull()
	{
		Preconditions.isNotNull(new Object());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void isNotNullShouldThrowForNull()
	{
		Preconditions.isNotNull(null);
	}
	
	@Test
	public void areNotNullShouldNotThrowForNonNulls()
	{
		Preconditions.areNotNull(new Object(), new Object());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void areNotNullShouldThrowForAnyNull()
	{
		Preconditions.areNotNull(new Object(), null);
	}
}
