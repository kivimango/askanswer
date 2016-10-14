package askanswer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import askanswer.Logic;

/**
 * Implemention of the Ask!Answer! card game in JAVA.
 * 
 * @author kivimango
 * @package askanswer
 * @link https://www.github.com/kivimango/askanswer
 * @version 1.0
 * @since 1.0
 */

public class Game {

	// Is player won ?
	
	private static boolean win = false;
	
	// Round count
	
	private static int round = 0;
	
	public Game() {
		
	}

	/** Logic of the game.
	 * Player has 12 rounds to guess the Card's Name.
	 * In every round the player can pick one property of a Card,
	 * or type his/her guess.
	 * In the last round the player must type the Name of the Card.
	 * If it matches, the player WON, else the player LOST.
	 * 
	 * @param args
	 * @author Hicks
	 * @version 1.0
	 * @since 1.0
	 */
	
	public static void main(String[] args) {
		
		Logic.welcomeMessage();
		
		try {
			new Deck();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Randomizing a random card from the Deck
		
		Card gameCard = Deck.getRandomCard();
		
		System.out.println("A k�rtya kateg�ri�ja: " + gameCard.getCategory());
		
		System.out.println("V�lassz egyet a k�rtya 12 jellemz�i k�z�l :");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		// Regex pattern for checking the user submitted only numbers
		
		String pattern = "[0-9+]*";
		
		String line = new String();
		
		// Asking the player for 12 round
		// If the player can answer the name of the card, the player won
		
		while((round <= 13) || (win))
		{	
			// This is the last round, player must answer
			
			if(round >= 12)
			{
				System.out.println("Nincs t�bb pr�b�lkoz�si lehet�s�ged.�rd be a megfejt�st: ");
				
				line = getInput(input);
				
				// Payer won
				
				if(line.matches(gameCard.getName()))
				{
					win = true;
					
					System.out.println("HELYES MEGFEJT�S ! NYERT�L !");

					break;
					
				}
				
				// Player lost

				else
				{						
					System.out.println("VESZTETT�L !");
					
					break;
				}
				
			}
			
			else
			{
				System.out.println("�rd be a megfejt�st, vagy a tov�bbi jellemz�k sz�mait: ");
			
				line = getInput(input);
			
				if(line.matches(pattern))
				{
					System.out.println(gameCard.getInfos(Integer.parseInt(line)));
					
					round++;
				}
			
				// Payer won
			
				else if(line.matches(gameCard.getName()))
				{
					win = true;
				
					System.out.println("HELYES MEGFEJT�S ! NYERT�L !");
			
					break;
				}
			
				else
				{
					round++;
				}			
			}
		}
	}

	/**
	 * Readging the user input from console
	 * @param input
	 * @return
	 */
	
	public static String getInput(BufferedReader input) {
		
		String line = new String();
		
		try {
			line = input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
}
