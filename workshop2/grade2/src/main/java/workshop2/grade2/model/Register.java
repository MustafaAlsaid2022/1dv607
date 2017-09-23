package workshop2.grade2.model;

import java.util.List;

public class Register {

	private List<Member> members;

	public Register() {

	}

	public void addMember(Member member) {

	}

	public void updateMember(Member old, Member nw) {

	}

	public void deleteMember(Member member) {

	}

	public void addBoat(Member member, Boat boat) {
		member.addBoat(boat);
	}
	
	public void updateBoat(Member member, Boat boat) {
		member.updateBoat(boat);
	}
	
	public void deleteBoat(Member member, Boat boat) {
		member.deleteBoat(boat);
	}
}
