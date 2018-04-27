package controller;
import java.lang.Math;

/**
 * This class works out the best path for the Robot to get to its destination
 * @author xandie
 *
 */
public class PathFinder {

/**
 * works out the optimum route for the Robot to get to a destination point
 * Returns "d" for down, "u" for up, "l" for left and "r" for right
 * @param currentX is Robot x location
 * @param currentY is Robot y location
 * @param destX is Destination x location
 * @param destY is destination y location
 * @return <code>String</code> based on the direction it travels in
 */
	public String getDirection(int currentX, int currentY, int destX, int destY) {
		/*System.out.println(Integer.toString(currentX));
		System.out.println(Integer.toString(currentY));
		System.out.println(Integer.toString(destX));
		System.out.println(Integer.toString(destY));*/
		int xDist = (destX - currentX);
		int yDist = (destY - currentY);
		if (yDist == 0 && xDist == 0) {
			return null;
	}

	if ((yDist*yDist) >= (xDist*xDist)) {
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
