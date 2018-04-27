package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ChargingPod;
import view.InputReader;
import model.PackingStation;
import model.Robot;
/**
 * A class that is used to create the warehouse grid
 * @author Group 28 
 *
 */
public class Grid{

	//Height and width could be replaced by size, as it's always going to be a square
	/**
	 * The height of the Grid in number of cells
	 */
	private int height;
	/**
	 * The width of the Grid in number of cells
	 */
	private int width;
	/**
	 * Takes in an input from the user
	 */
	static Scanner sc=new Scanner(System.in);
	/**
	 * Total number of cells in the Grid
	 */
	static int squares;
	/**
	 * Number of a single type like Robot or PackingStation
	 */
	static double numOfSingleKit;
	/**
	 * Number of objects in total
	 */
	static double numOfObjects;
	/**
	 * Stores the Robot objects in it
	 */
	static List<Robot>	robotList = new ArrayList<Robot>();
	/**
	 * Stores the PackingStation objects into it
	 */
	static List<PackingStation> packingList = new ArrayList<PackingStation>();
	
	/**
	 * Creates the <code>Grid</code> and sets the height and width of the grid
	 * @param x is the number of cells in the Grid
	 * @param y is the number of cells in the grid
	 */
	public Grid(int x, int y) {
		height = x;
		width = x;
		squares = x * y;
	}
	/**
	 * Access the position of the Robot in the position
	 * @param pos is the location of the Robot
	 * @return <code>Robot</code> in a certain position
	 */
	public static Robot getRobotList(int pos) {
    	return robotList.get(pos);
    }
	/**
	 * Access the position of the PackingStation in the position
	 * @param pos is the location of the PackingStation
	 * @return <code>PackingStation</code> in a certain position
	 */
	public static PackingStation getPackingStationList(int pos) {
    	return packingList.get(pos);
    }
	/**
	 * Returns the height of the Grid
	 * @return <code>int</code> Grid height in cells
	 */
	public int getGridHeight() {
		return height;
	}
	/**
	 * Returns the width of the Grid
	 * @return <code>int</code> Grid width in cells
	 */
	public int getGridWidth() {
		return width;
	}
	/**
	 * Returns the total number of cells in the Grid 
	 * @return <code>int</code> total number of cells
	 */
	public int getSquares() {
		return squares;
	}
	/**
	 * sets the height of the Grid
	 * @param height is the number of cells high you want the grid to be
	 */
	public void setGridHeight(int height) {
		this.height = height;
	}
	/**
	 * sets the width of the Grid
	 * @param width is the number of cells wide you want the grid to be
	 */
	public void setGridWidth(int width) {
		this.width = width;
	}

}
