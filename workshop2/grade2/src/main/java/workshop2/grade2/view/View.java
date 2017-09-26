package workshop2.grade2.view;

import java.util.Scanner;
import workshop2.grade2.model.Member;
import workshop2.grade2.model.Register;

public class View {

	private Register register;
	private Scanner scan;

	public View() {
		register = new Register();
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
				register.save();
				System.exit(1);
			default:
				System.out.println("Invalid");
			}
		}
	}

	public void addMember() {
		register.addMember(new Member(getInput("Name: "), getInput("Personal Number: ")));
		displaySuccess("Member added succesfully");
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
	
	private void displaySuccess(String msg) {
		System.out.println("****** " + msg + " *******");
	}
}
