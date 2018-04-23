package controller;
import java.lang.Math;

public class PathFinder {
	
	
	
	
	public String getDirection(int currentX, int currentY, int destX, int destY) {
		
	int xDist = (destY - currentY);
	int yDist = (destX - currentX);
	
	if (yDist == 0 && xDist == 0) {
			return null;
	}
	
	if ((Math.pow(yDist, yDist) > (Math.pow(xDist, xDist)))) {
		if (yDist > 0) {
			return "d";
		}
		else {
			return "u";
		}
	}
	else {
		if (xDist > 0) {
			return "r";
		}
		else {
			return "i";
		}
	}
	
		
		
}
	
	
	

}
