package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ChargingPod;
import model.PackingStation;
import model.Robot;
/**
 * A class to create the warehouse Grid
 * @author 
 * @version 25/04/18
 */
public class Grid{
	
 /**
  * height of the grid in number of cells
  */
	private static double height;
	/**
	 * width of the grid in number of cells
	 */
	private static double width;
	/**
	 * Value the user inputs
	 */
	private static int userInput;
	/**
	 * Allows the user to put a value in
	 */
	static Scanner sc=new Scanner(System.in);
	/**
	 * number of cells in the Grid
	 */
	static double squares;
	/**
	 * Number of a single type of object
	 */
	static double numOfSingleKit;
	/**
	 * Number of objects in the Grid overall
	 */
	static double numOfObjects;
	/**
	 * Holds a list of robots
	 * @see #setRobot(String, String, int, int, int, int) 
	 */
	static List<Robot>	robotList = new ArrayList<Robot>();
	/**
	 * Holds a list of PackingStations
	 */
	static List<PackingStation> packingList = new ArrayList<PackingStation>();
	/**
	 * Creates a <code>Grid</code> with certain dimensions
	 * @param size is the height and width of the Grid in cells
	 */
	public Grid(double size) {
		this.height = size;
		this.width = size;
		squares = size * size;
		numOfObjects = Math.round(squares / 3.0);
		numOfSingleKit = Math.round(numOfObjects / 3.0);
	}
	/**
	 * Returns the position of a robot
	 * @param pos is the location in the grid
	 * @return <code>Robot</code> position
	 */
	public static Robot getRobotList(int pos) {
    	return robotList.get(pos);
    }
	/**
	 * Returns the position of a PackingStation
	 * @param pos is the location of PackingStation in Grid
	 * @return <code>PackingStation</code> position
	 */
	public static PackingStation getPackingStationList(int pos) {
    	return packingList.get(pos);
    }
	/**
	 * Returns the height of the Grid
	 * @return <code>int</code> height of grid
	 */
	public int getGridHeight() {
		return (int)height;
	}
	/**
	 * Returns the width of the Grid
	 * @return <code>int</code> width of grid
	 */
	public int getGridWidth() { 
		return (int)width;
	}
	/**
	 * Sets the height of the Grid
	 * @param height is the height of grid
	 */
	public void setGridHeight(int height) {
		this.height = height;
	}
	/**
	 * Sets the width of the Grid
	 * @param width of grid
	 */
	public void setGridWidth(int width) {
		this.width = width;
	}
	/**
	 * Sets the robot up and adds it to robotList
	 * It sets the ChargingPod and gives it a name
	 * @param cID is the individual reference for the ChargingPod
	 * @param rID is the individual reference for the Robot
	 * @param x is the x position of the cell
	 * @param y is the y position of the cell
	 * @param chargeSpeed is the rate the battery charges
	 * @param charge is the amount of charge in the Robot battery
	 */
	public static void setRobot(String cID, String rID, int x, int y, int chargeSpeed, int charge) {
		double numRobots = (numOfSingleKit * 0.8);
		for(int i = 0; i < numRobots; i++) {
			Cell cells = new Cell(x, y);
			ChargingPod pod = new ChargingPod(cID, cells, chargeSpeed);
			Robot r = new Robot(cells, rID, true, charge, pod);
			robotList.add(r);
			System.out.println("The x coordinate for "+ i +"th robot is: " + Integer.toString(getRobotList(i).getX()));
			System.out.println("This robots charging pod is called" + getRobotList(i).getPod().getID());
			}
		
	}
	/**
	 * Sets the packingStations up and puts them in positions
	 * @param pID the Id of the packingStation
	 * @param x coordinate of the cell
	 * @param y coordinate of the cell
	 */
	public static void setPackingStation(String pID, int x, int y) {
		double numStations = (numOfSingleKit * 0.8);
		for(int i = 0; i < numStations; i++) {
			Cell cells = new Cell(x, y);
			PackingStation p = new PackingStation(1,1);
			packingList.add(p);
			System.out.println("the position of the packing stations are: " + getPackingStationList(i).g);
		}
	}
	/**
	 * Method that 
	 * @param args
	 */
	public static void main(String[] args) {
	    System.out.println("How many rows/columns would you like in the grid?");
	    userInput = sc.nextInt();
	    Grid grid = new Grid(userInput);
	    System.out.println("There are " + userInput + " rows and columns");
	    System.out.println("There are " + (userInput * userInput) + " cells in the grid" );
	    System.out.println("There are " + numOfObjects + " objects, out of which there are:");
	    
	    double numRobot = (double) Math.rint(numOfSingleKit);
	    
	    
	    
	    System.out.println(grid.numOfSingleKit + " Robots");
	    setRobot();
	    //System.out.println(grid.numOfSingleKit + " Storage Shelves");
	    //System.out.println(grid.numOfSingleKit + " Packing Stations");
	    //System.out.println(grid.numOfSingleKit + " Chargin' Pods");
	    
	    
	  }
	
	
}
