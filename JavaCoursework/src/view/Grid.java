package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ChargingPod;
import model.PackingStation;
import model.Robot;

public class Grid{
	
	//Height and width could be replaced by size, as it's always going to be a square
	private static double height;
	private static double width;
	private static int userInput;
	static Scanner sc=new Scanner(System.in);
	static double squares;
	static double numOfSingleKit;
	static double numOfObjects;
	static List<Robot>	robotList = new ArrayList<Robot>();
	static List<PackingStation> packingList = new ArrayList<PackingStation>();
	
	public Grid(double size) {
		this.height = size;
		this.width = size;
		squares = size * size;
		numOfObjects = Math.round(squares / 3.0);
		numOfSingleKit = Math.round(numOfObjects / 3.0);
	}
	
	public static Robot getRobotList(int pos) {
    	return robotList.get(pos);
    }
	
	public static PackingStation getPackingStationList(int pos) {
    	return packingList.get(pos);
    }
	public int getGridHeight() {
		return (int)height;
	}
	
	public int getGridWidth() { 
		return (int)width;
	}
	
	public void setGridHeight(int height) {
		this.height = height;
	}
	
	public void setGridWidth(int width) {
		this.width = width;
	}
	
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
	
	public static void setPackingStation(String pID, int x, int y) {
		double numStations = (numOfSingleKit * 0.8);
		for(int i = 0; i < numStations; i++) {
			Cell cells = new Cell(x, y);
			PackingStation p = new PackingStation(1,1);
			packingList.add(p);
			System.out.println("the position of the packing stations are: " + getPackingStationList(i).g);
		}
	}
	
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
