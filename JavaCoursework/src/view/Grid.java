package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ChargingPod;
import view.InputReader;
import model.PackingStation;
import model.Robot;
/**
 * A class that is used to 
 * @author 
 *
 */
public class Grid{

	//Height and width could be replaced by size, as it's always going to be a square
	private int height;
	private int width;
	static Scanner sc=new Scanner(System.in);
	static int squares;
	static double numOfSingleKit;
	static double numOfObjects;
	static List<Robot>	robotList = new ArrayList<Robot>();
	static List<PackingStation> packingList = new ArrayList<PackingStation>();
	static InputReader simFile;
    static int charge;
    static int chargeSpeed;
    static int numOfRobots;

	public Grid(int x, int y) {
		height = x;
		width = x;
		squares = x * y;
	}

	public static Robot getRobotList(int pos) {
    	return robotList.get(pos);
    }

	public static PackingStation getPackingStationList(int pos) {
    	return packingList.get(pos);
    }
	public int getGridHeight() {
		return height;
	}

	public int getGridWidth() {
		return width;
	}

	public int getSquares() {
		return squares;
	}


	public void setGridHeight(int height) {
		this.height = height;
	}

	public void setGridWidth(int width) {
		this.width = width;
	}




}
