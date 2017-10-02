package workshop2.grade2.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.xml.bind.annotation.*;
import workshop2.grade2.model.Boat;


/**
 * @author Mustafa Alsaid
 * @version 0.00.00
 * @name Register.java
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Register {

	@XmlElement(name="member")
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

	public void updateMember(Member old, Member nw) throws ParseException {
		Member member = memberList.get(memberList.indexOf(old));
		member.setName(nw.getName());
		member.setPersonalNumber(nw.getPersonalNumber());
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
}
