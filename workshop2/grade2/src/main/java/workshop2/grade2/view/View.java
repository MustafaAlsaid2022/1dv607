package workshop2.grade2.view;

import java.text.ParseException;
import java.util.Scanner;

import workshop2.grade2.io.FileHandler;
import workshop2.grade2.model.Boat;
import workshop2.grade2.model.Member;
import workshop2.grade2.model.Register;

public class View {

	private Register register;
	private Scanner scan;

	public View() {
		try {
			register = new FileHandler().readXML();
		} catch (Exception e) {
			register = new Register();
		}
		scan = new Scanner(System.in);
	}

	public void start() throws ParseException {
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
			System.out.print("Press q for quit\n>");
			String input = scan.next();
			switch (input) {
			case "1":
				addMember();
				break;
			case "2":
				displayCompactList();
				break;
			case "3":
				displayVerboseList();
				break;
			case "4":
				displayCompactList();
				addBoat();
				break;
			case "5":
				displayVerboseList();
				updateBoat();
				break;
			case "6":
				displayVerboseList();
				deleteBoat();
				break;
			case "7":
				displayCompactList();
				updateMember();
				break;
			case "8":
				displayCompactList();
				deleteMember();
				break;
			case "9":
				try {
					new FileHandler().writeXML(register);
					displayMessage("*** Data saved!! ***");
				} catch (Exception e) {
					displayMessage("*** Could not save data!! ***");
				}
				break;
			case "q":
				System.exit(1);
			default:
				displayMessage("you have inserted an invalid value");
			}
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
		int id = scan.nextInt();
		while (checkMemberId(id)) {
			System.out.println("you have inserted out of range value ");
			System.out.print("Insert ID of the member: ");
			id = scan.nextInt();
		}

		nw.setName(getInput("Name: "));
		try {
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
				System.out.println("you have inserted out of range value ");
				System.out.print("Insert ID of the member: ");
				id = scan.nextInt();
			}

			this.register.deleteMember(getMemberByID(id));
			displayMessage("Member deleted succesfully");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	public void addBoat() {

		Boat boat = new Boat();

		try {
			System.out.print("Insert ID of the member: ");
			int id = scan.nextInt();
			while (checkMemberId(id)) {
				System.out.println("you have inserted out of range value ");
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

			System.out.print("Insert ID of the boat: ");
			int boatId = scan.nextInt();
			while (checkBoatId(id, boatId)) {
				System.out.println("you have inserted out of range value ");
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
			System.out.print("Insert ID of the member: ");
			int id = scan.nextInt();
			while (checkMemberId(id)) {
				System.out.println("you have inserted out of range value ");
				System.out.print("Insert ID of the member: ");
				id = scan.nextInt();
			}

			System.out.print("Insert ID of the boat: ");
			int boatId = scan.nextInt();
			while (checkBoatId(id, boatId)) {
				System.out.println("you have inserted out of range value ");
				System.out.print("Insert ID of the boat: ");
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
				System.out.println(register.getMemberList().get(i).toString());
			}
		}
	}

	public void displayVerboseList() {

		if (register.getMemberList().isEmpty()) {
			displayMessage("the member list is empty");
		} else {
			for (int i = 0; i < register.getMemberList().size(); i++) {
				System.out.println("Member [ ID:" + register.getMemberList().get(i).getId() + " , Name:"
						+ register.getMemberList().get(i).getName() + " , PersonalNumber:"
						+ register.getMemberList().get(i).getPersonalNumber() + " , BoatNumber:"
						+ register.getMemberList().get(i).getBoatNumber() + "]");
				if (register.getMemberList().get(i).getBoatList().isEmpty()) {
					displayMessage("this member has not boat");
				} else {
					System.out.println(register.getMemberList().get(i).getBoatList());
				}
			}

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
