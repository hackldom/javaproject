package controller;


/**
 * A class that is used to Estimate the cost of taking a trip
 * This can be used to choose the robot for the lowest cost route
 * @author xandie
 *
 */
public class CostEstimation {

	/**
	 * This method works out the total time and distance for the robot to travel to complete the order
	 * It then returns whether the trip is accepted or not
	 * @param x is the current Robot x location
	 * @param y is the current Robot y location
	 * @param charge is the Robot level of charge
	 * @param packingX is the X coordinate of the PackingStation
	 * @param packingY is the Y coordinate of the PackingStation
	 * @param destinationX is the destination X coordinate
	 * @param destinationY is the destination Y coordinate
	 * @return <code>boolean</code> whether the trip is accepted or not based on charge
	 */
	public boolean trip(int x, int y, double charge, int packingX, int packingY, int destinationX, int destinationY) {
		
		double firstTripY = destinationY - y;
		firstTripY = Math.pow(firstTripY, firstTripY);
		firstTripY = Math.sqrt(firstTripY);
		
		double firstTripX = destinationX - x;
		firstTripX = Math.pow(firstTripX, firstTripX);
		firstTripX = Math.sqrt(firstTripX);

		double packingTripX = packingX - destinationX;
		packingTripX = Math.pow(packingTripX, packingTripX);
		packingTripX = Math.sqrt(packingTripX);

		double packingTripY = packingY - destinationY;
		packingTripY = Math.pow(packingTripX, packingTripX);
		packingTripY = Math.sqrt(packingTripX);

		charge = charge - (firstTripX + firstTripY);
		charge = charge - 2*(packingTripX + packingTripY);

		if (charge <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
}