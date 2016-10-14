package askanswer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import askanswer.Card;
import askanswer.CardFactory;

/** Deck class responsible for holding the generated Card objects by the CardFactory
 * 
 * @author Hicks
 * @link https://github.com/kivimango/askanswer
 * @package askanswer
 * @version 1.0
 * @since 1.0
 */

public class Deck {
	
	private static ArrayList<Card> deckArray = new ArrayList<Card>();

	public Deck() throws FileNotFoundException {
		new CardFactory();
		
		deckArray = CardFactory.produce();
	}
	
	/**
	 * Get one card.Client can invoke this method to request one Card object.
	 * Inserted an index-checking to avoid invalid index exceptions
	 * @param index
	 * @return
	 */
	
	public static Card get(int index) {
		
		if((index >= 0) && (index<=deckArray.size()))
		{
			return deckArray.get(index);	
		}
		else
		{
			return deckArray.get(0);
		}
	}
	
	/**
	 * Returning a random Card from the Deck
	 * @return Card
	 */
	
	public static Card getRandomCard() {
		Random rand = new Random();
		
		int randomIndex = rand.nextInt(deckArray.size());
		
		return deckArray.get(randomIndex);
	}
}
