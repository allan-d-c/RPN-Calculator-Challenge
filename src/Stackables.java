
// Critique: looks like a place to park common helper routines for Stackable derived types

public class Stackables 
{
	public static void areNumeric(Stackable... these)
	{
		for (Stackable s : these)
		{
			if (!s.isNumeric())
				throw new RuntimeException("Expected a numeric stack item, not "+s);
		}
	}
}
