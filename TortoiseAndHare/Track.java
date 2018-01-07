// Handles character array representing a track.
public class Track
{
	// Size of track.
	private int trackSize;

	//Create the array.
	private char raceTrack[] = new char[0];

	// Constructor
	public Track( int number )
	{
		// Sets raceTrack to proper length.
		trackSize = number;
		raceTrack = new char[ trackSize ];

		// Sets all characters to ' '.
		clearTrack();		
	}

	// Method to get trackSize.
	public int getLength()
	{
		return trackSize;
	}

	// Method to set specified character at specified index.
	public void setCharAtIndex( char character, int index )
	{
		raceTrack[index] = character;
	}

	// Method to print entire track.
	public void printTrack()
	{
		for( int i = 0; i < trackSize; i++ )
		{
			System.out.print( raceTrack[i] );
		}
	}

	// Method to set all character to ' '.
	public void clearTrack()
	{
		for( int i = 0; i < trackSize; i++ )
		{
			raceTrack[i] = ' ';
		}
	}
}