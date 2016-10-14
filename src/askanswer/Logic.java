package askanswer;

public class Logic {

	/**
	 * Prints the rules at startup
	 * @author Hicks
	 * @return void
	 * @version 1.0
	 * @since 0.1 
	 */
	
	public static void welcomeMessage() 
	{
		System.out.println("Üdözöllek a Kérdezz!Felelek játékban.");
		System.out.println("A játék kiválaszt egy kártyát, aminek ki kell találnod a nevét.");
		System.out.println("A kártyáknak 12 jellemzõi vannak, ezek segítenek kitalálni a megfejtést.");
		System.out.println("Minden körben 1 jellemzõt nézhetsz meg.");
		System.out.println("Az utolsó kör után (ha addig még nem találtad ki) )meg kell adnod a megfejtést.");
		System.out.println("Ha a megfejtés helytelen, vesztettél.");
	}
}
