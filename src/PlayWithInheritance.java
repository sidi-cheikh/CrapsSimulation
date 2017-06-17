/**
 * Just some Java code to allow you to explore inheritance, constructor
 * chaining, and polymorphism ("dynamic method lookup")
 * 
 */

public class PlayWithInheritance
{
	public static int RUN_EXAMPLE = 1; // change this to try different behaviors
										// below

	public static void main(String[] args)
	{
		StdOut.println();

		// common to all examples...

		// which constructors are called in the following?

		Die normalDie1 = new Die();
		CrookedDie1 crookedDie1 = new CrookedDie1();
		CrookedDie2 crookedDie2 = new CrookedDie2();

		StdOut.println();

		// change RUN_EXAMPLE above to run any one of the following 6 examples

		if (RUN_EXAMPLE == 1)
		{
			StdOut.println("Note the output: constructor chaining.");
		}
		else if (RUN_EXAMPLE == 2)
		{
			// When a reference is treated like a String
			// => toString() is automatically invoked, and its returned value
			// used instead!

			StdOut.println(normalDie1.toString());

			StdOut.print("toString() automatically called when reference treated as String: ");
			StdOut.println(normalDie1.toString());
			StdOut.println("Concatenating a string to a reference: " + normalDie1.toString());
		}
		else if (RUN_EXAMPLE == 3)
		{
			// concatenate " " + super.toString() to end of toString() code
			// inside each of 3 classes, then watch the result when run again.

			StdOut.println("die1's toString(): '" + normalDie1 + "'");
			StdOut.println("crooked1's toString(): '" + crookedDie1 + "'");
			StdOut.println("crooked2's toString(): '" + crookedDie2 + "'");
		}
		else if (RUN_EXAMPLE == 4)
		{
			// Die alias = die1; // try replacing this line with either below
			Die alias = crookedDie1; // upcasting!
			// Die alias = crooked2; // ditto

			StdOut.println("alias's toString(): '" + alias.toString() + "'");
			StdOut.println();
		}
		else if (RUN_EXAMPLE == 5)
		{
			Die alias;

			double toss = Math.random(); // [0.0..1.0)

			if (toss < 0.333)
				alias = normalDie1;
			else if (toss < 0.666)
				alias = crookedDie1;
			else
				alias = crookedDie2;

			// Can the compiler figure out the actual type
			// of alias in the following call?
			// No => dynamic runtime lookup happens

			describe("Which toString() is called? Answer is: ", alias);
		}
		else if (RUN_EXAMPLE == 6)
		{
			Die another = new Die();

			Dice dice = new Dice(normalDie1, crookedDie1); // we'll try substituting here

			dice.roll();

			int result = dice.getLastRoll();

			StdOut.printf("Roll of '%s' and '%s' is: %d.\n", normalDie1, crookedDie1, result);
		}

		StdOut.println();
	}

	/**
	 * Shows polymorphism via passing either Die ref as toDescribe, or
	 * CrookedDie1 or CrookedDie2 ref instead
	 * 
	 * @param msg
	 * @param toDescribe
	 */

	public static void describe(String msg, Die toDescribe)
	{
		StdOut.printf("%s '%s' \n", msg, toDescribe.toString());
	}

}
