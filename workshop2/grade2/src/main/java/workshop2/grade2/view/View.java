package View;

import java.util.Scanner;
import java.util.Vector;

import Model.Member;
import Model.Register;

public class View implements BoatView, MemberView {

	private Register register;

	public void start() {
		Scanner scan = new Scanner(System.in);

		while (true && !false) {
			System.out.print("> ");
			if (!analyseSentence(scan.nextLine()))
				return;
		}
	}

	private boolean analyseSentence(String line) {
		Vector<String> args = this.extractArgs(line);

		switch (args.elementAt(0)) {
		case "list":
			switch (args.elementAt(1)) {
			case "compact":
				this.memberListCompact();
				return true;

			case "verbose":
				this.memberListVerbose();
				return true;
			}
			break;
		case "add":
			
			break;
			
		case "exit":
			System.out.println("===  END  ===");
			return false;
		}
	return true;
	
	}

	private Vector<String> extractArgs(String line) {
		Vector<String> args = new Vector<String>();
		StringBuffer buffer = new StringBuffer();
		int cursor = 0;

		while (cursor < line.length()) {
			while (cursor < line.length() && line.charAt(cursor) != ' ')
				buffer.append(line.charAt(cursor++));
			cursor++;
			args.add(buffer.toString());
			buffer.delete(0, buffer.length());
		}
		return args;
	}

	@Override
	public void addMember(String name, int id) {

	}

	@Override
	public void memberListVerbose() {
		System.out.println("verbose");

	}

	@Override
	public void memberListCompact() {
		System.out.println("compact");

	}
}
