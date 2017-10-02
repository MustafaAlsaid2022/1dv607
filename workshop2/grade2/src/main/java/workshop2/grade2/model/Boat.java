package workshop2.grade2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author Mustafa Alsaid
 * @version 0.00.00
 * @name Boat.java
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Boat {

	private double boatLength;

	public enum BoatType {
		Sailboat, Motorsailer, Canoe, Other
	}

	private BoatType type;

	@Override
	public String toString() {
		return "Boat [ Length:" +boatLength+ " , Type:" + type + "]";
	}
	
	public double getBoatLength() {
		return boatLength;
	}

	public void setBoatLength(double boatLength) {
		this.boatLength = boatLength;
	}

	public BoatType getType() {
		return type;
	}

	public void setType(BoatType type) {
		this.type = type;
	}
}