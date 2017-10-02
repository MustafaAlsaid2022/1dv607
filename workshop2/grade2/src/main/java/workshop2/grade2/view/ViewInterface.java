package workshop2.grade2.view;

import java.text.ParseException;

/**
 * @author Mustafa Alsaid
 * @version 0.00.00
 * @name ViewInterface.java
 */

public interface ViewInterface {
	
	public void start()throws ParseException;
	public void addMember();
	public void updateMember()throws ParseException;
	public void deleteMember();
	public void addBoat();
	public void updateBoat();
	public void deleteBoat();
	public void displayCompactList();
	public void displayVerboseList();

}
