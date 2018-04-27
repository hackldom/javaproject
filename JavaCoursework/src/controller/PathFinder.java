package controller;
import java.lang.Math;

public class PathFinder {




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
