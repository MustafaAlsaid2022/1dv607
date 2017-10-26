package model.Search;

import java.util.ArrayList;
import model.Member;

public class MemberName implements ISearch {

	private String str;

	public MemberName(String str) {
		this.str = str;
	}

	@Override
	public java.util.List<Member> meetCriteria(java.util.List<Member> members) {
		java.util.List<Member> nameList = new ArrayList<Member>();
		for (Member member : members) {
			if (member.getName().toLowerCase().startsWith(str)) {
				nameList.add(member);
			}
		}
		return nameList;

	}

}