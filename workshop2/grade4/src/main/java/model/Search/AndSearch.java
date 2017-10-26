package model.Search;

	import java.util.List;
    import model.Member;

	public class AndSearch implements ISearch {

	   private ISearch search;
	   private ISearch otherSearch;

	   public AndSearch(ISearch search, ISearch otherSearch) {
	      this.search = search;
	      this.otherSearch = otherSearch; 
	   }

	   @Override
	   public List<Member> meetCriteria(List<Member> members) {
	      List<Member> firstCriteria = search.meetCriteria(members);		
	      return otherSearch.meetCriteria(firstCriteria);
	   }
	}


