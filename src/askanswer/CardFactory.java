package askanswer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import askanswer.Card;

/** Producing the Card objects with the Factory pattern based on the parameters.
 * 
* @author Hicks
* @link https://github.com/kivimango/askanswer
* @package askanswer
* @version 1.0
* @since 1.0
*/

public class CardFactory {
	
	// List holding the generated Card Objects
	
	private static ArrayList<Card> Cards = new ArrayList<Card>();
	
	// Path to .xml file wich is storing the data
	
	private final static String path_db = "src\\askanswer\\cards.xml";
	
	/**
	 * Opening and parsing  the .xml file which contains the data.
	 * @throws java.io.FileNotFoundException
	 */
	
	private static NodeList loadFromFile() throws java.io.FileNotFoundException
	{		
		File inputFile = new File(path_db);
		    
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		     
		DocumentBuilder dBuilder = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		     
		// Parsing the xml file
		     
		Document doc = null;
		
		try {
		doc = dBuilder.parse(inputFile);
		} catch (SAXException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		     
		doc.getDocumentElement().normalize();
		     
		NodeList nList = doc.getElementsByTagName("card");
		
		return nList;
	}
	
	/**
	 * Filling card's data from xml file into Card object
	 * @param nList
	 */
    
	private static void fill(NodeList nList)
	{
		
	   for (int temp = 0; temp < nList.getLength(); temp++) 
	   {
		   Node nNode = nList.item(temp);
		   
		   if (nNode.getNodeType() == Node.ELEMENT_NODE) 
		   	{
			Element eElement = (Element) nNode;
			
			  Cards.add(CardFactory.set(eElement));
			}
		}	
	}
	
	/**
	 * Setting the properties of a Card object
	 * Data comes from the xml file
	 * 
	 * @param item
	 * @return Card
	 */
	
	private static Card set(Element item)
	{
		Card puffer = new Card();
		
		// Setting the category of the Card
		 
		 puffer.setCategory(item
		    .getElementsByTagName("category")
		    .item(0)
		    .getTextContent());
		
		 // Setting the name of the Card
		 // User has type in this string to win before he runs out of "infos" 
		 
		 puffer.setName( item
		    .getElementsByTagName("name")
		    .item(0)
		    .getTextContent());
		 
		 // Filling up the "infos" property of the Card
		 // The xmlparser returns the infos array as one String,
		 // so we have to split it by newline characters
		 // Then we can pass the result String[] to the set method
		 
		 String lines = item
				    .getElementsByTagName("infos")
				    .item(0)
				    .getTextContent();
		 
		 puffer.setInfos(lines.split("\\r?\\n"));
		
		 System.out.println(puffer.getCategory());
		 System.out.println(puffer.getName());
		 System.out.println(puffer.getCategory());
		 
		return puffer;
	}
	
	/**
	 * Assembling the Card objects (invoking the producing methods)
	 * 
	 * @return ArrayList<Card>
	 */
	
	public static ArrayList<Card> produce()
	{
		NodeList nList = null;
		
		try 
		{
			nList = CardFactory.loadFromFile();
		} 
		
		catch (FileNotFoundException e) 
		{
			System.out.println("Database file not found."
					+ "You can download it from my github repo: https://github.com/kivimango/askanswer");
		}

		CardFactory.fill(nList);
		
		return Cards;
	}
}