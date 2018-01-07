import java.util.Random;

// Handles tortoise's movement.
public class Tortoise
{
	// Holds current position of tortoise on track.
	private int position;

	// Generates random numbers
	private Random randomGen = new Random();

	// Stores random nummbers
	private int randomNum;

	// Constructor
	public Tortoise( int pos )
	{
		position = pos;
	}

	// Method to get position.
	public int getPosition()
	{
		return position;
	}

	// Method to randomly move tortoise.
	public void move( int trackSize )
	{
		// Random number to compare.
		randomNum = randomGen.nextInt(10) + 1;

		if( randomNum == 1 || randomNum == 2 || randomNum == 3 || randomNum == 4 || randomNum == 5 )
		{
			moveForward( 3, trackSize );
		}

		if( randomNum == 6 || randomNum == 7 || randomNum == 8 )
		{
			moveForward( 1, trackSize );
		}

		if( randomNum == 9 || randomNum == 10 )
		{
			carefulMoveBack( -6, trackSize );
		}
	}

	// Method to move backwards without going past square 1.
	private void carefulMoveBack( int spaceMoved, int trackSize )
	{
		// Checks if desired movment goes too far.
		if( position + spaceMoved < 0 )
		{
			position = 0;
		}

		else
		{
			position = position + spaceMoved;
		}
	}

	// Method to move forward.
	// Main purpose is simplicity and easy reading.
	private void moveForward( int spaceMoved, int trackSize )
	{
		position = position + spaceMoved;
	}
}