package view;

import java.text.ParseException;
import java.util.Scanner;

import io.FileHandler;
import model.Boat;
import model.Member;
import model.Register;
import model.Search.ISearch;
import model.Search.MemberAge;
import model.Search.MemberName;

/**
 * @author Mustafa Alsaid
 * @version 0.00.00
 * @name View.java
 */

public class View {

	private Register register;
	private Scanner scan;
	private final String login = "ADMIN";
	private final String pass = "PASSWORD";
	private boolean logged_in = false;

	public View() {
		try {
			register = new FileHandler().readXML();
		} catch (Exception e) {
			register = new Register();
		}
		scan = new Scanner(System.in);
	}

	public void start() throws ParseException {
        if(logged_in==false)
		loggin();
		while (true) {

			System.out.println();
			System.out.println("Press 1 for adding a member");
			System.out.println("Press 2 for compact list");
			System.out.println("press 3 for verbose list");
			System.out.println("press 4 for adding a boat");
			System.out.println("press 5 for updating a boat");
			System.out.println("press 6 for deleting a boat");
			System.out.println("press 7 for updating a member");
			System.out.println("press 8 for deleting a member");
			System.out.println("press 9 to save data");
			System.out.println("press s for simple search");
			System.out.print("Press q for quit\n>");
			String input = scan.next();
			switch (input) {
			case "1":
				if (!isConnected())
					break;
				addMember();
				break;
			case "2":
				displayCompactList();
				break;
			case "3":
				displayVerboseList();
				break;
			case "4":
				if (!isConnected())
					break;
				displayCompactList();
				if (!register.getMemberList().isEmpty())
					addBoat();
				break;
			case "5":
				if (!isConnected())
					break;
				displayVerboseList();
				if (!register.getMemberList().isEmpty()) {
					updateBoat();
				}

				break;
			case "6":
				if (!isConnected())
					break;
				displayVerboseList();
				if (!register.getMemberList().isEmpty())
					deleteBoat();
				break;
			case "7":
				if (!isConnected())
					break;
				displayCompactList();
				if (!register.getMemberList().isEmpty())
					updateMember();
				break;
			case "8":
				if (!isConnected())
					break;
				displayCompactList();
				if (!register.getMemberList().isEmpty())
					deleteMember();
				break;
			case "9":
				try {
					new FileHandler().writeXML(register);
					displayMessage("*** Data saved!! ***");
				} catch (Exception e) {
					e.printStackTrace();
					displayMessage("*** Could not save data!! ***");
				}
				break;
			case "q":
				System.exit(1);
			case "s":
				simpleSearch();
				break;
			default:
				displayMessage("you have inserted an invalid value");
			}
		}
	}

	public void simpleSearch() throws ParseException {
		while (true) {
			System.out.println("Press 1 for search by name");
			System.out.println("Press 2 for search by age");
			System.out.println("Press 3 to go back to main menu");
			String input = scan.next();
			switch (input) {
			case "1":
				searchName();
				break;
			case "2":
				searchAge();
				break;
			case"3":
				start();
				break;
			}
		}
	}

	public void searchName() {
		System.out.print("insert the name you to seach for: ");
		try {
		String input = scan.next();
		ISearch search = new MemberName(input);
		if (search.meetCriteria(register.getMemberList()).isEmpty())
			displayMessage("there is no member his name starts with this");
		else {
			for (int i = 0; i < search.meetCriteria(register.getMemberList()).size(); i++) {
				displayMessage(
						"Member [ ID:" + search.meetCriteria(register.getMemberList()).get(i).getId() + " , Name:"
								+ search.meetCriteria(register.getMemberList()).get(i).getName() + " , PersonalNumber:"
								+ search.meetCriteria(register.getMemberList()).get(i).getPersonalNumber() + "]");

			}
		}
		}catch(Exception e) {
			displayMessage("you have inserted an invalid value");
		}
	}

	public void searchAge() {

		System.out.print("insert the age you to seach for: ");
		try {
			String input = scan.next();
			ISearch search = new MemberAge(Integer.parseInt(input));
			if (search.meetCriteria(register.getMemberList()).isEmpty())
				displayMessage("There is no member with this age");
			else {
				for (int i = 0; i < search.meetCriteria(register.getMemberList()).size(); i++) {
					displayMessage("Member [ ID:" + search.meetCriteria(register.getMemberList()).get(i).getId()
							+ " , Name:" + search.meetCriteria(register.getMemberList()).get(i).getName()
							+ " , PersonalNumber:"
							+ search.meetCriteria(register.getMemberList()).get(i).getPersonalNumber() + "]");

				}
			}
		} catch (Exception e) {
			displayMessage("you have inserted an invalid value");
		}
	}

	public void addMember() {
		Member member = new Member();
		member.setName(getInput("Name: "));
		try {
			member.setPersonalNumber(getInput("Personal Number: "));
			register.addMember(member);
			displayMessage("Member added succesfully");

		} catch (Exception e) {
			displayMessage("you have inserted an invalid personal number");
		}

	}

	public void updateMember() throws ParseException {
		Member nw = new Member();
		System.out.print("Insert ID of the member: ");
		try {
			int id = scan.nextInt();
			while (checkMemberId(id)) {
				displayMessage("you have inserted out of range value ");
				System.out.print("Insert ID of the member: ");
				id = scan.nextInt();
			}

			nw.setName(getInput("Name: "));

			nw.setPersonalNumber(getInput("Personal Number: "));
			this.register.updateMember(getMemberByID(id), nw);
			displayMessage("Member updated successfully");
		} catch (Exception e) {
			displayMessage("you have inserted an invalid personal number");
		}

	}

	public void deleteMember() {

		try {
			System.out.print("Insert ID of the member: ");
			int id = scan.nextInt();
			while (checkMemberId(id)) {
				displayMessage("you have inserted out of range value ");
				System.out.print("Insert ID of the member: ");
				id = scan.nextInt();
			}

			this.register.deleteMember(getMemberByID(id));
			displayMessage("Member deleted succesfully");
		} catch (Exception e) {
			displayMessage("you have inserted out of range value ");
		}
	}

	@SuppressWarnings("static-access")
	public void addBoat() {

		Boat boat = new Boat();

		try {
			System.out.print("Insert ID of the member: ");
			int id = scan.nextInt();
			while (checkMemberId(id)) {
				displayMessage("you have inserted out of range value ");
				System.out.print("Insert ID of the member: ");
				id = scan.nextInt();
			}
			System.out.print("Length: ");
			boat.setBoatLength(scan.nextDouble());
			System.out.println();
			System.out.println("Boat Types:");
			for (int i = 0; i < Boat.BoatType.values().length; i++) {
				System.out.println(Boat.BoatType.values()[i]);
			}
			System.out.println();
			System.out.print("Type: ");
			boat.setType(boat.getType().valueOf(scan.next()));
			this.register.addBoat(getMemberByID(id), boat);
			displayMessage("Boat added successfully");

		} catch (Exception e) {
			displayMessage("you have inserted an invalid value");
		}
	}

	@SuppressWarnings("static-access")
	public void updateBoat() {

		Boat nwBoat = new Boat();

		try {
			System.out.print("Insert ID of the member: ");
			int id = scan.nextInt();
			while (checkMemberId(id)) {
				System.out.println("you have inserted out of range value ");
				System.out.print("Insert ID of the member: ");
				id = scan.nextInt();
			}
			if (register.getMemberList().get(register.getMemberIndex(getMemberByID(id))).getBoatList().isEmpty()) {
				displayMessage("this member has not a boat");
				return;
			}
			System.out.print("Insert ID of the boat: ");
			int boatId = scan.nextInt();
			while (checkBoatId(id, boatId)) {
				displayMessage("you have inserted out of range value ");
				System.out.print("Insert ID of the boat: ");
				boatId = scan.nextInt();
			}

			System.out.print("Length: ");
			nwBoat.setBoatLength(scan.nextDouble());
			System.out.println();
			System.out.println("Boat Types:");
			for (int i = 0; i < Boat.BoatType.values().length; i++) {
				System.out.println(Boat.BoatType.values()[i]);
			}

			System.out.println();
			System.out.print("type: ");
			nwBoat.setType(nwBoat.getType().valueOf(scan.next()));
			this.register.updateBoat(getMemberByID(id), getBoatByID(id, boatId), nwBoat);
			displayMessage("Boat updated successfully");

		} catch (Exception e) {
			displayMessage("you have inserted an invalid value");
		}
	}

	@SuppressWarnings("static-access")
	public void deleteBoat() {

		try {
			displayMessage("Insert ID of the member: ");
			int id = scan.nextInt();
			while (checkMemberId(id)) {
				displayMessage("you have inserted out of range value ");
				displayMessage("Insert ID of the member: ");
				id = scan.nextInt();
			}

			if (register.getMemberList().get(register.getMemberIndex(getMemberByID(id))).getBoatList().isEmpty()) {
				displayMessage("this member has not a boat");
				return;
			}

			System.out.print("Insert ID of the boat: ");
			int boatId = scan.nextInt();
			while (checkBoatId(id, boatId)) {
				displayMessage("you have inserted out of range value ");
				displayMessage("Insert ID of the boat: ");
				boatId = scan.nextInt();
			}

			this.register.deleteBoat(getMemberByID(id), getBoatByID(id, boatId));
			displayMessage("Boat deleted succesfully");
		} catch (Exception e) {
			displayMessage("you have inserted an invalid value");
		}
	}

	public void displayCompactList() {
		if (register.getMemberList().isEmpty())
			displayMessage("the member list is empty");
		else {
			for (int i = 0; i < register.getMemberList().size(); i++) {
				displayMessage("Member [ ID:" + register.getMemberList().get(i).getId() + " , Name:"
						+ register.getMemberList().get(i).getName() + " , PersonalNumber:"
						+ register.getMemberList().get(i).getPersonalNumber() + "]");
				;
			}
		}
	}

	public void displayVerboseList() {

		if (register.getMemberList().isEmpty()) {
			displayMessage("the member list is empty");
		} else {
			for (int i = 0; i < register.getMemberList().size(); i++) {
				displayMessage("Member [ ID:" + register.getMemberList().get(i).getId() + " , Name:"
						+ register.getMemberList().get(i).getName() + " , PersonalNumber:"
						+ register.getMemberList().get(i).getPersonalNumber() + " , BoatNumber:"
						+ register.getMemberList().get(i).getBoatNumber() + "]");
				if (register.getMemberList().get(i).getBoatList().isEmpty()) {
					displayMessage("this member has not boat");
				} else {
					for (int j = 0; j < register.getMemberList().get(i).getBoatList().size(); j++) {
						displayMessage("Boat [ ID:" + register.getMemberList().get(i).getBoatList().get(j).getId()
								+ " , Length:" + register.getMemberList().get(i).getBoatList().get(j).getBoatLength()
								+ " , Type:" + register.getMemberList().get(i).getBoatList().get(j).getType() + "]");
					}
				}
			}

		}
	}

	private boolean isConnected() {
		if (!this.logged_in) {
			System.err.println("You can't access to this command.\nYou need to be logged in.");
			return false;
		}
		return true;
	}

	private void loggin() {
		int attempt = 0;
		String _pass_, _log_;
		String __choice__;
		System.out.print("Do you want to be logged in by using ADMIN/PASSWORD (yes/no)?: ");
		__choice__ = this.scan.next();
		if (!__choice__.equals("yes")) {
			System.out.println("You are not connected");
			return;
		}

		while (attempt < 5) {
			if (attempt > 0)
				System.err.println("Wrong log/pass. Try again [" + attempt + "/5].");
			System.out.print("\nLogin: ");
			_log_ = this.scan.next();
			System.out.print("Pass: ");
			_pass_ = this.scan.next();

			if (_log_.equals(this.login) && _pass_.equals(this.pass)) {
				System.out.println("Your are now connected!");
				this.logged_in = true;
				break;
			}
			attempt++;
		}
	}

	private String getInput(String output) {
		String input = "";
		while (input.trim().isEmpty()) {
			System.out.print(output);
			input = scan.next() + scan.nextLine();
		}
		return input;
	}

	private void displayMessage(String msg) {
		System.out.println("****** " + msg + " *******");
	}

	private boolean checkMemberId(int id) {
		for (int i = 0; i < register.getMemberList().size(); i++) {
			if (register.getMemberList().get(i).getId() == id) {
				return false;
			}
		}
		return true;
	}

	private boolean checkBoatId(int memberId, int id) {

		for (int i = 0; i < register.getMemberList().get(register.getMemberIndex(getMemberByID(memberId))).getBoatList()
				.size(); i++) {
			if (register.getMemberList().get(register.getMemberIndex(getMemberByID(memberId))).getBoatList().get(i)
					.getId() == id) {
				return false;
			}

		}
		return true;
	}

	private Member getMemberByID(int id) throws NullPointerException {
		for (Member m : register.getMemberList())
			if (m.getId() == id)
				return m;
		throw new NullPointerException("you have inserted an invalid id");
	}

	private Boat getBoatByID(int memberId, int boatId) throws NullPointerException {
		for (Boat b : register.getMemberList().get(register.getMemberIndex(getMemberByID(memberId))).getBoatList())
			if (b.getId() == boatId)
				return b;
		throw new NullPointerException("you have inserted an invalid id");
	}
}