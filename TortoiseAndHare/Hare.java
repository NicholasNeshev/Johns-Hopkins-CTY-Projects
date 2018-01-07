import java.util.Random;

// Handles hare's movement.
public class Hare
{
	// Holds current position of tortoise on track.
	private int position;

	// Generates random numbers
	private Random randomGen = new Random();

	// Stores random nummbers
	private int randomNum;

	// Constructor
	public Hare( int pos )
	{
		position = pos;
	}

	// Method to get position.
	public int getPosition()
	{
		return position;
	}

	// Method to randomly move hare.
	public void move( int trackSize )
	{
		// Random number to compare with.
		randomNum = randomGen.nextInt(10) + 1;

		if( randomNum == 1 || randomNum == 2 )
		{
			moveForward( 9, trackSize );
		}

		if( randomNum == 3 || randomNum == 4 || randomNum == 5 )
		{
			moveForward( 1, trackSize );
		}

		if( randomNum == 6 )
		{
			carefulMoveBack( -12, trackSize );
		}

		if( randomNum == 7 || randomNum == 8 )
		{
			carefulMoveBack( -2, trackSize );
		}

		if( randomNum == 9 || randomNum == 10 )
		{
			moveForward( 0, trackSize );
		}
	}

	// Method to move backwards without going past square 1.
	private void carefulMoveBack( int spaceMoved, int trackSize )
	{
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