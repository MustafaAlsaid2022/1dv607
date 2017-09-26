package workshop2.grade2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Register {

	private ArrayList<Member> memberList;

	
	public Register() {
		memberList = new ArrayList<Member>();
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	public int getMemberNumber() {
		return memberList.size();
	}

	public void addMember(Member member) {
		member.setId(getMaxId());
		memberList.add(member);
	}

	public void updateMember(Member old, Member nw) {
		Member member = memberList.get(memberList.indexOf(old));
		member.setName(nw.getName());
	}

	public void deleteMember(Member member) {
		memberList.remove(member);
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
	
	public int getMemberIndex(Member m) {
		return memberList.indexOf(m);
	}

	private int getMaxId() {
		Collections.sort(this.memberList, new Comparator<Member>() {
			public int compare(Member first, Member second) {
				return first.getId() - second.getId();
			}
		});
		return this.memberList.isEmpty() ? 1 : this.memberList.get(this.memberList.size() - 1).getId() + 1;
	}

	public void save() {
		// TODO Auto-generated method stub
	}
}
