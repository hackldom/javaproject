package controller;



public class CostEstimation {



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