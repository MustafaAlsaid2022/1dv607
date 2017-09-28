package workshop2.grade2.model;

import java.text.DateFormat;
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

	public void setPersonalNumber(String personalNumber) throws Exception {
		String firstPart = personalNumber.substring(0, 6);
		DateFormat df = new SimpleDateFormat("yyMMdd");
		df.setLenient(false);
		df.parse(firstPart);

		String secondPart = personalNumber.substring(6, personalNumber.length());
		isCorrect(personalNumber, secondPart);
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

	private void isCorrect(String personalNumber, String second) throws Exception {
		int[] arrayId = new int[personalNumber.length()];
		for (int i = 0; i < personalNumber.length(); i++) {
			int convert = Integer.parseInt(personalNumber);
			arrayId[i] = convert;
		}

		String msg = "You have inserted an invaled personal number";
		if (second.length() != 4)
			throw new ArithmeticException(msg);
		for (int i = 0; i < second.length(); i++) {
			char ch = second.charAt(i);
			if (!Character.isDigit(ch))
				throw new ArithmeticException(msg);
		}
		int sum = 0;
		for (int i = 0; i <= arrayId.length - 2; i += 2) { // sum equation for odd digits//
			int temp = ((arrayId[i] * 2) % 10) + ((arrayId[i] * 2) / 10);
			sum = sum + temp;
		}
		for (int i = 1; i <= arrayId.length - 2; i += 2) { // sum equation for even digits excluding the last digit//
			sum = sum + arrayId[i]; // add the two sums together//
		}
		int checkSum = 10 - (sum % 10); // checksum procedure//
		if (checkSum == 10) {
			checkSum = checkSum % 10;
		}
		if (arrayId[arrayId.length - 1] != checkSum) // if last digit equal checksum the the id is correct
			throw new ArithmeticException(msg);

	}
}
