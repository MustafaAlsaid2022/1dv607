package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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


	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
		boat.setId(getMaxId());
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
	
	public int getBoatIndex(Boat b) {
		return boatList.indexOf(b);
	}

	private int getMaxId() {
		Collections.sort(this.boatList, new Comparator<Boat>() {
			public int compare(Boat first, Boat second) {
				return first.getId() - second.getId();
			}
		});
		return this.boatList.isEmpty() ? 1 : this.boatList.get(this.boatList.size() - 1).getId() + 1;
	}
	
}
