package workshop2.grade2.view;

import java.util.Scanner;

import workshop2.grade2.io.FileHandler;
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

	public void start() {
		while (true) {
			System.out.println("Press 1 for adding member");
			System.out.println("Press 2 for compact list");
			System.out.print("Press q for quit \n>");
			String input = scan.next();
			switch (input) {
			case "1":
				addMember();
				break;
			case "2":
				displayCompactList();
				break;
			case "q":
				try {
					new FileHandler().writeXML(register);
					displayMessage("*** Data saved!! ***");
				} catch (Exception e) {
					displayMessage("*** Could not save data!! ***");
				}
				System.exit(1);
			default:
				displayMessage("you have inserted an invalid value");
			}
		}
	}

	public void addMember()  {
		Member m = new Member();
		m.setName(getInput("Name: "));
		try {
			m.setPersonalNumber(getInput("Personal Number: "));
		} catch (Exception e) {
			displayMessage("you have inserted an invalid persona number");
		}
		register.addMember(m);
		displayMessage("Member added succesfully");
		return;
	}

	public void displayCompactList() {
		for (int i = 0; i < register.getMemberList().size(); i++) {
			System.out.println(register.getMemberList().get(i));
		}
		return;
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
}
