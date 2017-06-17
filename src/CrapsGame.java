
public class CrapsGame
{
	private int point;
	private Dice dice;
	public static boolean showOutput = true;

	public static void println(String str)
	{
		if (showOutput)
			StdOut.println(str);
	}

	public CrapsGame()
	{
		dice = new Dice();
	}

	public CrapsGame(Die die1, Die die2)
	{
		dice = new Dice(die1, die2);
	}

	public boolean playOneGame(int[] wins, int[] losses)
	{
		int steps = 1;

		// Roll the dice
		// Get the value of the roll as point
		// Print out this value as 'first roll'

		point = doARoll();

		// If point is 7 or 11, announce an immediate win for player,
		// increment wins[steps], and return true indicating win
		
		if (point == 7 || point == 11)
		{
			return winForPlayer(wins, steps);
		}
		// Else if point is 2, 3, or 12, announce an immediate loss for player,
		// increment losses[steps], and return false indicating loss
		else if (point==2 || point == 3 || point==12)
		{
			println("Loss for player with " + point);
			losses[steps] = losses[steps] + 1; // number of losses with exactly steps # of steps.
			// losses[steps]++; 
			return false;
		}

		// If not an immediate win nor loss, print out point
		// roll the dice over and over, keeping track of steps,
		// and printing each rolled value until either:

		// (a) The point is again rolled => a win for player:
		// update wins[] and return true

		// (b) 7 is rolled => a loss for player:
		// update losses[] and return false
		
		else // point rolled: keep going until point rerolled OR 7 rolled
		{
			println("Point is: " + point);
			
			int value = rollUntilWinOrLoss(point,steps);
		
			if (value==7)
			{
				// loss: record losses and return false
				println("You lose throwing a 7.");
				losses[steps]++;
				return false;
			}
			else if (value==point)
			{
				// win: record wins and return false
				println("You win by throwing your point " + value);
				wins[steps]++;
				return true;

			}
		}

		return false;
	}

	private int rollUntilWinOrLoss(int point, int steps)
	{
		int value;
		do
		{
			dice.roll();
			steps++;
			value = dice.getLastRoll();
			println("Next roll is: " + value);
		}
		while (value != 7 && value != point);
		return value;
	}

	private int doARoll()
	{
		dice.roll();
		return dice.getLastRoll();
	}

	private boolean winForPlayer(int[] wins, int steps)
	{
		println("Win for player with " + point);
		wins[steps] = wins[steps] + 1; // number of wins with exactly steps # of steps.
		// wins[steps]++; 
		return true;
	}

	public static void main(String[] args)
	{
		// play a game!
	}
}
