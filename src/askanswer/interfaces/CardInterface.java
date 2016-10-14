/**
 * Interface for Card ojects
 * Every Card object must implement the methods described here.
 * 
 * @author Hicks
 * @link https://github.com/kivimango/askanswer
 * @package askanswer
 * @version 1.0
 * @since 0.1
 */

package askanswer.interfaces;

public interface CardInterface {
	
	public String getInfos(int index);

	public void setInfos(String[] infos);
	
	public String getCategory();

	public void setCategory(String category);

	public String getName();

	public void setName(String name);

}
