package model.Search;

import java.util.List;
import model.Member;

public class OrSearch implements ISearch{
	
	 private ISearch search;
	   private ISearch otherSearch;

	   public OrSearch(ISearch search, ISearch otherSearch) {
	      this.search = search;
	      this.otherSearch = otherSearch; 
	   }
	   

	   @Override
	   public List<Member> meetCriteria(List<Member> members) {
	      List<Member> firstCriteria = search.meetCriteria(members);
	      List<Member> otherCriteria = otherSearch.meetCriteria(members);

	      for (Member member : otherCriteria) {
	         if(!firstCriteria.contains(member)){
	            firstCriteria.add(member);
	         }
	      }	
	      return firstCriteria;
	   }
	}


