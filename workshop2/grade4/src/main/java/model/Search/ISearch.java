package model.Search;


import model.Member;

import java.util.List;

public interface ISearch {
	
   public List<Member> meetCriteria(List<Member> members);
}


