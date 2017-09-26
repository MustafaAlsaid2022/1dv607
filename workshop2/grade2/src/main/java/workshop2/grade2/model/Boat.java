package workshop2.grade2.model;

/**
 * @author Mustafa Alsaid
 * @version 0.00.00
 * @name Boat.java
 */

public class Boat {

	private double boatLength;

	public enum BoatType {
		Sailboat, Motorsailer, Canoe, Other
	}

	private BoatType type;

	public Boat(double length, BoatType type) {
		setBoatLength(length);
		this.type = type;
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