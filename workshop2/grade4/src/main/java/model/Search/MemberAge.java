package model.Search;

import java.util.ArrayList;

import model.Member;

public class MemberAge implements ISearch {

	private int age;

	public MemberAge(int age) {
		this.age = age;
	}

	@Override
	public java.util.List<Member> meetCriteria(java.util.List<Member> members) {
		java.util.List<Member> ageList = new ArrayList<Member>();
		for (Member member : members) {
			if (member.getAge() == age) {
				ageList.add(member);
			}
		}
		return ageList;
	}
}