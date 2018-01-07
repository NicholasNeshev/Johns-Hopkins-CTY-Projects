import java.util.Scanner;

// Converts Morse code to English and English to Morse code.
public class MorseCodeProject
{	
	public static void main( String [] args )
	{
		// White space for easy reading.
		System.out.println();

		// Saves user input to initiate desired converter.
		Scanner input = new Scanner( System.in );		
		System.out.print("Input M for Morse code to English or E for English to Morse code: " );
		String userResponse = input.next().toUpperCase();

		// Runs Morse code to English code if response is 'M'.
		if( userResponse.equals("M") )
		{
			// Allows three attempts.
			for( int i = 0; i < 3; i++ )
			{
				// White space for easy reading.
				System.out.println();

				// Saves user Morse code sentence as an array for convenience.
				char morseArray[] = getMorseInput();	
	
				// Checks if input follows proper format.
				if( morseProofChecker( morseArray ) )
				{
					// White space for easy reading.
					System.out.println();

					// Converts text.
					String translation = morseTranslator( morseArray );

				 	// Prints converted text.
					System.out.println("Your sentence in English is: " + translation);

					// Exits loop.
					break;
				}

				// If user input follows incorrect formatting.
				else
				{
					// White space for easy reading.
					System.out.println();

					System.out.println( "Please input a correct sentence, ex: --. .-- | ... -." );
				}
			}
		}

		// Runs English to Morse code if response was 'E'.
		else if( userResponse.equals("E") )
		{
			// White space for easy reading.
			System.out.println();
		
			// Saves user English sentence as an array for convenience.
			char englishArray[] = getEnglishInput();

			// White space for easy reading.
			System.out.println();

			// Converts text.
			String translation = englishTranslator( englishArray );

			// Displays text.
			System.out.println("Your sentence in Morse code is: " + translation );
		}

		// If user didn't input 'E' or 'M'.
		else
		{
			// White space for easy reading.
			System.out.println();

			System.out.println("Please reboot the program and enter M or E");
		}
	}

	// Method to return user input.
	// Morse code version.
	public static char[] getMorseInput()
	{
		// Prompts user to enter Morse code sentence and returns input.
		Scanner input = new Scanner( System.in );
		System.out.print( "Enter you sentence in Morse code: " );
		String userString = input.nextLine();
		return userString.toCharArray();
	}

	// Method to return user input.
	// English version.
	public static char[] getEnglishInput()
	{
		// Prompts user to enter English sentence and returns input.
		Scanner input = new Scanner( System.in );
		System.out.print( "Enter you sentence in English: " );
		String userString = input.nextLine();
		return userString.toCharArray();
	}

	// Method to check if user inputted invalid character in Morse code sentence.
	public static boolean morseProofChecker( char morseArray[] )
	{
		// Scans through response.
		for( int i = 0; i < morseArray.length; i++ )
		{
			// Returns false if single incorrect character is found.
			if( morseArray[i] != '.' &&  morseArray[i] != '-' &&  morseArray[i] != ' ' &&  morseArray[i] != '|')
			{
				return false;
			}
		}
		// Returns true if sentence is valid.
		return true;
	}

	// Method to convert Morse code.
	public static String morseTranslator( char morseArray[] )
	{
		// Saves start and end index of Morse code.
		int beginOfString = 0;
		int endOfString = 0;

		// Variable to store English character returned from converter.
		char englishChar = ' ';

		// Stores total converted English sentence.
		String total = "";			

		// Scans through array.
		for( int i = 0; i < morseArray.length; i++ )
		{
			// Adds " " to total sccentence if '|' is found.
			if( morseArray[i] == '|' )
			{
				total = total + " ";
			}

			// Locates Morse code in array, converts to an English character, and adds it to the sentence. 
			else
			{
				// Sets start index if current character is not a space and previous one is a space, or if the current character is not a space and lies at the beginning of the array.
				if( morseArray[i] != ' ' && ( i == 0 || morseArray[i-1] == ' ' ) )
				{
					beginOfString = i;
				}

				// Sets end index if current character is not a space and next one is a space, or if the current character is not a space and lies at the end of the array.
				if( morseArray[i] != ' ' && ( i == (morseArray.length - 1) || morseArray[i+1] == ' ') )
				{
					endOfString = i;

					// Converts Morse code sequence to an English character.
					englishChar = morseToEnglishConverter( beginOfString, endOfString, morseArray );

					// Adds English character to sentence.
					total = total + englishChar;
				}
			}
		}
		
		// Returns converted sentence.
		return total;
	}

	// Method to convert Morse code into an English character.
	// Called by Morse code translator.
	public static char morseToEnglishConverter( int start, int end, char arr[] )
	{
		// Storage for Morse code.
		String morseChar = "";

		// Recreates Morse code using it's position in the array.
		for( int i = start; i <= end; i ++ )
		{
			morseChar = morseChar + arr[i];		
		}

		// Returns corresponding English character for respective Morse code.
		switch( morseChar )
		{
			case ".-":
				return 'A';
			case "-...":
				return 'B';
			case "-.-.":
				return 'C';
			case "-..":
				return 'D';
			case ".":
				return 'E';
			case "..-.":
				return 'F';
			case "--.":
				return 'G';
			case "....":
				return 'H';
			case "..":
				return 'I';
			case ".---":
				return 'J';
			case "-.-":
				return 'K';
			case ".-..":
				return 'L';
			case "--":
				return 'M';
			case "-.":
				return 'N';
			case "---":
				return 'O';
			case ".--.":
				return 'P';
			case "--.-":
				return 'Q';
			case ".-.":
				return 'R';
			case "...":
				return 'S';
			case "-":
				return 'T';
			case "..-":
				return 'U';
			case "...-":
				return 'V';
			case ".--":
				return 'W';
			case "-..-":
				return 'X';
			case "-.--":
				return 'Y';
			case "--..":
				return 'Z';
			case ".----":
				return '1';
			case "..---":
				return '2';
			case "...--":
				return '3';
			case "....-":
				return '4';
			case ".....":
				return '5';
			case "-....":
				return '6';
			case "--...":
				return '7';
			case "---..":
				return '8';
			case "----.":
				return '9';
			case "-----":
				return '0';
			default:
				return '?';
		}
	}

	// Method to convert and display English.
	public static String englishTranslator( char englishArray[] )
	{
		// Stores total Morse code sentence.
		String total = "";

		// Scans through array.
		for( int i = 0; i < englishArray.length; i++ )
		{
			// Adds "|" to sentence if ' ' is scanned.
			if( englishArray[i] == ' ' )
			{
				total = total + "|";
			}

			// Sends English character to converter and adds Morse code to sentence.
			else
			{
					// Sets English character to be sent.
					char englishChar = Character.toUpperCase(englishArray[i]);

					// Sends English character to convert it and saves Morse code.
					String morseChar = englishToMorseConverter( englishChar );

					// Adds Morse code to sentence.
					total = total + morseChar;
			}
			// Adds space between each Morse code sequence for proper formatting.
			total = total + " ";
		}

		// Returns converted sentence.
		return total;
	}

	// Method to convert an English character into Morse code.
	// Called by English translator.
	public static String englishToMorseConverter( char english )
	{
		// Returns corresponding Morse code for respective English character.
		switch( english )
		{
			case 'A':
				return ".-";
			case 'B':
				return "-...";
			case 'C':
				return "-.-.";
			case 'D':
				return "-..";
			case 'E':
				return ".";
			case 'F':
				return "..-.";
			case 'G':
				return "--.";
			case 'H':
				return "....";
			case 'I':
				return "..";
			case 'J':
				return ".---";
			case 'K':
				return "-.-";
			case 'L':
				return ".-..";
			case 'M':
				return "--";
			case 'N':
				return "-.";
			case 'O':
				return "---";
			case 'P':
				return ".--.";
			case 'Q':
				return "--.-";
			case 'R':
				return ".-.";
			case 'S':
				return "...";
			case 'T':
				return "-";
			case 'U':
				return "..-";
			case 'V':
				return "...-";
			case 'W':
				return ".--";
			case 'X':
				return "-..-";
			case 'Y':
				return "-.--";
			case 'Z':
				return "--..";
			case '1':
				return ".----";
			case '2':
				return "..---";
			case '3':
				return "...--";
			case '4':
				return "....-";
			case '5':
				return ".....";
			case '6':
				return "-....";
			case '7':
				return "--...";
			case '8':
				return "---..";
			case '9':
				return "----.";
			case '0':
				return "-----";
			default:
				return "?";
		}
	}
}