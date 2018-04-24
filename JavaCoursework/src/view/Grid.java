package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Robot;

/**
 * Creates a grid structure based on user input values
 * @author 
 * @version 24/04/18
 */
public class Grid{
	
	//Height and width could be replaced by size, as it's always going to be a square
	/**
	 * Height and width of grid
	 */
	private static double height;
	private static double width;
	/**
	 * cells store Cell array of array 
	 */
	private static Cell[][] cells;
	/**
	 * userInput contains user input value
	 */
	private static int userInput;
	/**
	 * scanner takes user input
	 */
	static Scanner sc=new Scanner(System.in);
	/**
	 * squares is total number of cells
	 */
	static double squares;
	/**
	 * numOfSingleKit is number of each object
	 */
	static double numOfSingleKit;
	/**
	 * numOfObjects is total number of objects
	 */
	static double numOfObjects;
	/**
	 * robotList is an ArrayList of robots
	 * @see #setRobot
	 */
	static List<Robot>	robotList = new ArrayList<Robot>();
	
	/**
	 * Creates a <code>Grid</code> and sets the dimensions based on userInput
	 * @param size refers to the height and width entered 
	 * 
	 */
	public Grid(double size) {
		this.height = size;
		this.width = size;
		cells = new Cell[(int) width][(int) height];
		squares = size * size;
		numOfObjects = Math.round(squares / 3.0);
		numOfSingleKit = Math.round(numOfObjects / 3.0);
	}
	/**
	 * Returns the robots position 
	 * 
	 * @param pos refers to robot position on the grid
	 * @return <code>Robot</code> position found by accessing {@link #robotList}
	 */
	
	public static Robot getRobotList(int pos) {
    	return robotList.get(pos);
    }
	/**
	 * Gets grid height
	 * @return <code>int</code> height {@link #height}
	 */
	public int getGridHeight() {
		return (int)height;
	}
	/**
	 * Gets grid width
	 * @return <code>int</code> width {@link #width}
	 */
	public int getGridWidth() { 
		return (int)width;
	}
	/**
	 * Sets grid height
	 * @param height
	 */
	public void setGridHeight(int height) {
		this.height = height;
	}
	/**
	 * Sets grid width
	 * @param width
	 */
	public void setGridWidth(int width) {
		this.width = width;
	}
	/**
	 * Sets up robots with position and adds it to robotList
	 * {@link #robotList}
	 */
	public static void setRobot() {
		double numRobots = numOfSingleKit;
		cells = new Cell[(int) width][(int) height];
		for(int i = 0; i < numRobots; i++) {
			Robot r = new Robot(cells[i], cells[0], true, 20);
			robotList.add(r);
			System.out.println("The x coordinate for "+ i +"th robot is: " + getRobotList(i));
		}
		
	}
	/**
	 * 
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
