package workshop2.grade2.model;

import java.util.List;

public class Member {
	
	private List<Boat> boats;

	public void addBoat(Boat boat) {
		boats.add(boat);
	}

	public void updateBoat(Boat old, Boat nw) {
		Boat boat = boats.get(boats.indexOf(old));
		boat.setType(nw.getType());
		boat.setLength(nw.getLength());
	}

	public void deleteBoat(Boat boat) {
		boats.remove(boat);
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(Object name) {
		// TODO Auto-generated method stub
		
	}
}
