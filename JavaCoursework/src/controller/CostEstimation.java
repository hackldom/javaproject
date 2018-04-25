package controller;



public class CostEstimation {

	private int gridHeight;
	private int gridWidth;
	
	public CostEstimation(int height, int width) {
		gridHeight = height;
		gridWidth = width;
	}
	
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