package workshop2.grade2.model;

import java.util.List;

public class Register {

	private List<Member> members;

	public Register() {

	}

	public void addMember(Member member) {
		members.add(member);
	}

	public void updateMember(Member old, Member nw) {
		Member member = members.get(members.indexOf(old));
		member.setName(nw.getName());
	}

	public void deleteMember(Member member) {
		members.remove(member);
	}

	public void addBoat(Member member, Boat boat) {
		member.addBoat(boat);
	}
	
	public void updateBoat(Member member, Boat old, Boat nw) {
		member.updateBoat(old, nw);
	}
	
	public void deleteBoat(Member member, Boat boat) {
		member.deleteBoat(boat);
	}
}
