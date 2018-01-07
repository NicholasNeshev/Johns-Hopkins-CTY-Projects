// Simulates tortoise and hare race.
public class Race Projectx
{
	public static void main( String [] args )
	{
		// Creates tortoise, hare, and track objects.
		Tortoise tortoise = new Tortoise( 0 );
		Hare hare = new Hare( 0 );
		Track track = new Track( 50 );
		
		// Start of race.
		System.out.println();
		System.out.print("AND THEY'RE OFF!!");
		System.out.println();
		System.out.println();

		// Loops while neither racer have passed the "finish line".
		while( tortoise.getPosition() < track.getLength() - 1 && hare.getPosition() < track.getLength() - 1 )
		{
			// Delay.
			Sleep();

			// Moves tortoise and hare.
			tortoise.move( track.getLength() );
			hare.move( track.getLength() );

			showPositions( tortoise, hare, track );
		}

		// Check different win scenarios.

		// Tie.
		if( hare.getPosition() >= track.getLength() - 1 && tortoise.getPosition() >= track.getLength() - 1 )
		{
			Tie();
		}
		// Tortoise win.
		else if( tortoise.getPosition() >= track.getLength() - 1 )
		{
			TortoiseWin();
		}
		// Hare win.
		else
		{
			HareWin();
		}
	}

	// Delay intervals between track display for easy viewing.
	public static void Sleep()
	{
		try 
		{
			Thread.sleep(150);
		} 
		catch(InterruptedException ex) 
		{
	   		Thread.currentThread().interrupt();
		}
	}

	// Method that displays "OUCH!!".
	// Trims message to fit avaliable space.
	public static void Owie( int position, Track track )
	{
		// Array of message.
		char message[] = {'O','U','C','H','!','!'};

		// Stores length of message
		int messageLen = message.length;

		// Counter to scroll through message.
		int messagePos = 0;

		// Stores how much space is available for the message to be printed
		int availableSpace = track.getLength() - position; 

		// Sets availableSpace to messageLen if greater as.
		if( availableSpace > messageLen )
		{
			availableSpace = messageLen;
		}

		// Advances through message and inserts it into proper position on track for duration specified by available space.
		for( int i = position; i < position + availableSpace; i++ )
		{
			track.setCharAtIndex( message[messagePos] , i );
			messagePos++;
		}
	}

	// Method to display tortoise victory.
	public static void TortoiseWin()
	{
		System.out.println();
		System.out.println("TORTOISE WINS!!");
	}

	// Method to display hare victory.
	public static void HareWin()
	{
		System.out.println();
		System.out.println("HARE WINS!!");
	}

	// Method to display tie.
	public static void Tie()
	{
		System.out.println();
		System.out.println("IT'S A TIE!!");
	}

	// Method to display positions.
	public static void showPositions( Tortoise tortoise, Hare hare, Track track )
	{
		// Checks if racers are in different places.
		if( tortoise.getPosition() != hare.getPosition() )
		{
			// Displays racers at positions.
			if( tortoise.getPosition() < track.getLength() - 1 )
			{
				track.setCharAtIndex( 'T' , tortoise.getPosition() );
			}
			if( hare.getPosition() < track.getLength() - 1 )
			{
				track.setCharAtIndex( 'H' , hare.getPosition() );
			}
		}

		// Racers are on same space.
		else
		{
			// Displays "OUCH!!".
			Owie( tortoise.getPosition(), track );
		}

		track.printTrack();

		// Resets track.
		track.clearTrack();
		System.out.println();
	}
}