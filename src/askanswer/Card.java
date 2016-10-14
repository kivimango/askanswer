package askanswer;

import askanswer.interfaces.CardInterface;

/**
 * Card class responsible for storing properties of an instance of a Card object
 * Just a simple data-storing class, nothing serious
 * 
 * @author Hicks
 * @link https://github.com/kivimango/askanswer
 * @package askanswer
 * @version 1.0
 * @since 1.0
 */

public class Card implements CardInterface {

	// Category of the card

	private String category = new String();
	
	// 12 properties of a card. User can pick them one by one

	private String[] infos = new String[12];
	
	// Name of the card. User must type this to win
	
	private String name = new String();
	
	// Getters and setters
	
	@Override
	public String getCategory() {
		return category;
	}
	
	@Override
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getInfos(int index) {
		
		// Checking if the passed parameter is a valid index
		
		if((index >= 0) && (index <= this.infos.length))
		{
			// To-do: surround it with try-catch ?
			// Index is valid, cleaning the tab chars from the string
			
			return infos[index].replaceAll("\t", "");
		}
		else
		{
			// Invalid index, returning the first item
			
			return infos[0];
		}
		
	}

	@Override
	public void setInfos(String[] infos) {
		this.infos = infos;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
