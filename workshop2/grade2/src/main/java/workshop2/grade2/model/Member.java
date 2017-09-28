package workshop2.grade2.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.xml.bind.annotation.*;

/**
 * @author Mustafa Alsaid
 * @version 0.00.00
 * @name Member.java
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Member {

	private int id;
	private String name;
	private String personalNumber;
	@XmlElement(name="boat")
	private ArrayList<Boat> boatList;

	public Member() {
		boatList = new ArrayList<Boat>();
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Member [ ID:" + id + " , Name:" + name + " , PersonalNumber:" + personalNumber + "]";
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) throws ParseException  {
		String firstPart = personalNumber.substring(0, 6);
		DateFormat df = new SimpleDateFormat("yyMMdd");
		df.setLenient(false);
		df.parse(firstPart);

		
		this.personalNumber = personalNumber;

	}

	public ArrayList<Boat> getBoatList() {
		return boatList;
	}

	public void setList(ArrayList<Boat> boatList) {
		this.boatList = boatList;
	}

	public int getBoatNumber() {
		return boatList.size();
	}

	public void addBoat(Boat boat) {
		boatList.add(boat);
	}

	public void updateBoat(Boat old, Boat nw) {
		Boat boat = boatList.get(boatList.indexOf(old));
		boat.setType(nw.getType());
		boat.setBoatLength(nw.getBoatLength());
	}

	public void deleteBoat(Boat boat) {
		boatList.remove(boat);
	}

	
}
