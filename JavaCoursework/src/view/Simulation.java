package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.ChargingPod;
import view.InputReader;
import model.PackingStation;
import model.Robot;
import model.StorageShelf;

public class Simulation{

	//Height and width could be replaced by size, as it's always going to be a square
	private int height;
	private int width;
	static Scanner sc=new Scanner(System.in);
	static double squares;
	static double numOfSingleKit;
	static double numOfObjects;
	static List<Robot>	robotList = new ArrayList<Robot>();
	static List<StorageShelf> shelfList = new ArrayList<StorageShelf>();
	static List<PackingStation> packingList = new ArrayList<PackingStation>();
	static InputReader simFile;
    static int charge;
    static int chargeSpeed;
    static int numOfRobots;
    static int numOfShelfs;
    static int numOfStations;
    static Grid grid;

	public Simulation() {

		numOfObjects = Math.round(squares / 3.0);
		numOfSingleKit = Math.round(numOfObjects / 3.0);
		simFile = new InputReader("simulation1.txt");
		numOfRobots = 0;
		numOfShelfs = 0;
		numOfStations = 0;
	}

	public static Robot getRobotList(int pos) {
    	return robotList.get(pos);
    }
	public static StorageShelf getStorageShelfList(int pos) {
    	return shelfList.get(pos);
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
			Cell cells = new Cell(x, y);
			ChargingPod pod = new ChargingPod(cID, cells, chargeSpeed);
			Robot r = new Robot(cells, rID, true, charge, pod);
			robotList.add(r);
			System.out.println("The x coordinate for "+ rID +" robot is: " + Integer.toString(getRobotList(numOfRobots).getX()));
			System.out.println("This robots charging pod is called " + getRobotList(numOfRobots).getPod().getID());
			numOfRobots++;
			}

	public static void setShelf(String sID, int x, int y) {
		Cell cells = new Cell(x, y);
		StorageShelf s = new StorageShelf(cells, sID);
		shelfList.add(s);
		System.out.println("The x coordinate for "+ sID +" robot is: " + Integer.toString(getStorageShelfList(numOfShelfs).getX()));
		System.out.println("This robots charging pod is called " + getStorageShelfList(numOfShelfs).getID());
		numOfShelfs++;
		}

	public static void setStation(String pID, int x, int y) {
		Cell cells = new Cell(x, y);
		PackingStation p = new PackingStation(cells, pID);
		packingList.add(p);
		System.out.println("The x coordinate for "+ pID +" robot is: " + Integer.toString(getPackingStationList(numOfStations).getX()));
		System.out.println("This robots charging pod is called " + getPackingStationList(numOfStations).getID());
		numOfStations++;
		}



/*	public static void setPackingStation(String pID, int x, int y) {
		double numStations = (numOfSingleKit * 0.8);
		for(int i = 0; i < numStations; i++) {
			Cell cells = new Cell(x, y);
			PackingStation p = new PackingStation(1,1);
			packingList.add(p);
			System.out.println("the position of the packing stations are: " + getPackingStationList(i).g);
		}
	}*/



    public static void readFile() {
    	String[] line;

    	line = simFile.nextLine();
    	charge = Integer.parseInt(line[1]);
    	System.out.println("charge is " + Integer.toString(charge));
    	line = simFile.nextLine();
    	chargeSpeed = Integer.parseInt(line[1]);
    	System.out.println("charge speed is " + Integer.toString(chargeSpeed));
    	int loop = 1;
    	while (loop == 1) {
    		line = simFile.nextLine();
    		System.out.println(line[0]);
    		if (line[0].equals("podRobot")){
    			setRobot(line[1], line[2], Integer.valueOf(line[3]), Integer.valueOf(line[4]), chargeSpeed, charge);
    		}
    		else if (line[0] == "shelf"){
    			setShelf(line[1], Integer.valueOf(line[2]),  Integer.valueOf(line[3]));
    		}
    		else if (line[0] == "station"){
    			setStation(line[1], Integer.valueOf(line[2]),  Integer.valueOf(line[3]));
    		}
    		else {
    			loop = 0;
    		}
    		}


    	}

	public static void main(String[] args) {
		Simulation Sim = new Simulation();
		String[] line;
    	line = simFile.nextLine();
    	System.out.println("1st line ");
    	line = simFile.nextLine();
    	int w = Integer.parseInt(line[1]);
    	System.out.println("width is " + Integer.toString(w));
    	line = simFile.nextLine();
    	int h = Integer.parseInt(line[1]);
    	System.out.println("height is " + Integer.toString(h));

		//System.out.println("How many rows/columns would you like in the grid?");
	    //userInput = sc.nextInt();
	    grid = new Grid(w, h);
	    System.out.println("There are " + Integer.toString(grid.getGridWidth()) + " rows and " + Integer.toString(grid.getGridHeight()) + " columns");
	    System.out.println("There are " + Integer.toString(grid.getSquares()) + " cells in the grid" );

	    readFile();
	    //System.out.println(grid.numOfSingleKit + " Storage Shelves");
	    //System.out.println(grid.numOfSingleKit + " Packing Stations");
	    //System.out.println(grid.numOfSingleKit + " Charging Pods");


	  }

}