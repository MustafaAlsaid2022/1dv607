package workshop2.grade2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import workshop2.grade2.model.Boat.BoatType;


public class Register {

	private ArrayList<Member>memberList;

	public Register() {
		memberList=new ArrayList<Member>();

	}

	public void addMember(Member member) {
		memberList.add(member);
	}

	public void updateMember(Member old, Member nw) {
		Member member = memberList.get(memberList.indexOf(old));
		member.setName(nw.getName());
	}

	public void deleteMember(Member member) {
		memberList.remove(member);
	}

	public void addBoat(Member member, double length, BoatType type) {
		member.addBoat(length,type);
	}
	
	public void updateBoat(Member member, Boat old, Boat nw) {
		member.updateBoat(old, nw);
	}
	
	public void deleteBoat(Member member, Boat boat) {
		member.deleteBoat(boat);
	}
	public int getMaxId() {
		Collections.sort(this.memberList, new Comparator<Member>() {
			
			public int compare(Member first, Member second) {
				if (first == null) {
					System.out.println("first null");
				} else if (second == null) {
					System.out.println("second null");
				}
				return first.getId() - second.getId();
			}
		});
		return this.memberList.isEmpty() ? 1
				: this.memberList.get(this.memberList.size() - 1).getId() + 1;
	}
}
	
