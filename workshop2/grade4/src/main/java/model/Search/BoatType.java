package model.Search;

import java.util.ArrayList;
import model.Member;

public class BoatType {

		private BoatType type;
		

		public BoatType(BoatType type) {
			this.type = type;
		}
		@SuppressWarnings("unlikely-arg-type")
		public java.util.List<Member> meetCriteria(java.util.List<Member> members) {
			java.util.List<Member> memberBoatList = new ArrayList<Member>();
			for (int i = 0; i < members.size(); i++) {
				
					for (int j = 0; j < members.get(i).getBoatList().size(); j++) {
						if (members.get(i).getBoatList().get(j).getType().equals(type)) 
							memberBoatList.add(members.get(i));
						}
			}
			return memberBoatList;
		}

}
