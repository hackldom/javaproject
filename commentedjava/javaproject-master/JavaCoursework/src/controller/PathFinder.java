package controller;
import java.lang.Math;
/**
 * A class that decides how the robot should move for optimal efficiency on battery level
 * @author xandie
 * @version 25/04/18
 */
public class PathFinder {
	
	/**
	 * used to determine most efficient route for the robot
	 * @param currentX is current robot x position
	 * @param currentY is current robot y position
	 * @param destX is the destination x position
	 * @param destY is the destination y position
	 * @return whether the task should be taken or not
	 * 
	 */
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
			return "l";
		}
	}
	
		
		
}
	
	
	

}
