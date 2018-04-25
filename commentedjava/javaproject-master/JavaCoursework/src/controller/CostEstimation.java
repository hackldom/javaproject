package controller;

/**
 * A class that calculates the cost of an assigned trip
 * @author xandie
 * @version 25/04/18
 */
public class CostEstimation {
/**
 * The height of the grid
 */
	private int gridHeight;
/**
 * The width of the grid
 */
	private int gridWidth;
	
	/**
	 * Cost estimation constructor
	 * @param height of the grid
	 * @param width of the grid
	 */
	public CostEstimation(int height, int width) {
		gridHeight = height;
		gridWidth = width;
	}
	/**
	 * A method to calculate the total cost of a trip
	 * and whether the robot is capable of completing the trip on current battery level
	 * @param x is the robots current x position in the grid
	 * @param y is the robots current y position in the grid
	 * @param charge is the robot battery level
	 * @param packingX is the x position of the packing station
	 * @param packingY is the y position of the packing station
	 * @param destinationX is the x coordinate of the destination location
	 * @param destinationY is the y coordinate of the destination location
	 * @return <code>boolean</code> to determine whether the robot should take the trip or not
	 */
	public boolean trip(int x, int y, double charge, int packingX, int packingY, int destinationX, int destinationY) {
		double firstTripY = destinationY - y;
		firstTripY = Math.pow(firstTripY, firstTripY);
		firstTripY = Math.sqrt(firstTripY);
		
		double firstTripX = destinationX - x;
		firstTripX = Math.pow(firstTripX, firstTripX);
		firstTripX = Math.sqrt(firstTripX);
		
		double packingTripX = packingX - x;
		packingTripX = Math.pow(packingX, packingX);
		packingTripX = Math.sqrt(packingX);
		
		double packingTripY = packingY - x;
		packingTripY = Math.pow(packingY, packingY);
		packingTripY = Math.sqrt(packingY);
		
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