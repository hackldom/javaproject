package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.CostEstimation;
import controller.PathFinder;
import model.ChargingPod;
import model.Order;
import view.InputReader;
import model.PackingStation;
import model.Robot;
import model.StorageShelf;

public class Simulation{

	//Height and width could be replaced by size, as it's always going to be a square
	private int height;
	private int width;
	private static int tick;
	static Scanner sc=new Scanner(System.in);
	static double squares;
	static double numOfSingleKit;
	static double numOfObjects;
	static List<Robot>	robotList = new ArrayList<Robot>();
	static List<StorageShelf> shelfList = new ArrayList<StorageShelf>();
	static List<PackingStation> packingList = new ArrayList<PackingStation>();
	static List<Order> orderList = new ArrayList<Order>();
	static InputReader simFile;
    static int charge;
    static int chargeSpeed;
    static int numOfRobots;
    static int numOfShelfs;
    static int numOfStations;
    static int numOfOrders;
    static Grid grid;
    static boolean runSimulation;
    static PathFinder pF;
    static CostEstimation cE;

	public Simulation() {

		numOfObjects = Math.round(squares / 3.0);
		numOfSingleKit = Math.round(numOfObjects / 3.0);
		simFile = new InputReader("simulation1.txt");
		numOfRobots = 0;
		numOfShelfs = 0;
		numOfStations = 0;
		numOfOrders = 0;
		pF = new PathFinder();
		cE = new CostEstimation();
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
	public static Order getOrderList(int pos) {
    	return orderList.get(pos);
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
			System.out.println("The coordinates for "+ rID +" robot is: (" + Integer.toString(getRobotList(numOfRobots).getX())
			+ ", " + Integer.toString(getRobotList(numOfRobots).getY()) + ")");
			System.out.println("This robots charging pod is called " + getRobotList(numOfRobots).getPod().getID());
			numOfRobots++;
			}

	public static void setShelf(String sID, int x, int y) {
		Cell cells = new Cell(x, y);
		StorageShelf s = new StorageShelf(cells, sID);
		shelfList.add(s);
		System.out.println("The coordinates for "+ sID +" shelf is: (" + Integer.toString(getStorageShelfList(numOfShelfs).getX())
		+ ", " + Integer.toString(getStorageShelfList(numOfShelfs).getY()) +")");
		numOfShelfs++;
		}

	public static void setStation(String pID, int x, int y) {
		Cell cells = new Cell(x, y);
		PackingStation p = new PackingStation(cells, pID);
		packingList.add(p);
		System.out.println("The coordinates for "+ pID +" packing station is: (" + Integer.toString(getPackingStationList
		(numOfStations).getX()) + ", " + Integer.toString(getPackingStationList(numOfStations).getY()) + ")");
		numOfStations++;
		}

	public static void setOrder(int ticks, String location) {
		int x= 0;
		Cell newCell = null;
		while (x < shelfList.size()){
			if (getStorageShelfList(x).getsID().equals(location)){
				newCell = getStorageShelfList(x).getCell();
				x = shelfList.size();
			}
			x++;
		}
		Order order = new Order(ticks, newCell, location);
		orderList.add(order);
		System.out.println("new order number " + numOfOrders + " has been stored in storage shelf " + location + " and "
		+ "takes " + getOrderList(numOfOrders).getTicks() + " ticks");
		numOfOrders++;
		}

	private static int checkCrashed(int x) {
		int y = x;
		x++;
		while (x < numOfRobots){
			if ((getRobotList(y).getCell().getX() == getRobotList(x).getCell().getX()) && (getRobotList(y).getCell().getY() == getRobotList(y).getCell().getY())){
				return x;
			}
			x++;
		}
		return -1;
	}

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
    		try{
    		line = simFile.nextLine();
    		//System.out.println(line[0]);
    		if (line[0].equals("podRobot")){
    			setRobot(line[1], line[2], Integer.valueOf(line[3]), Integer.valueOf(line[4]), chargeSpeed, charge);
    		}
    		else if (line[0].equals("shelf")){
    			setShelf(line[1], Integer.valueOf(line[2]),  Integer.valueOf(line[3]));
    		}
    		else if (line[0].equals("station")){
    			setStation(line[1], Integer.valueOf(line[2]),  Integer.valueOf(line[3]));
    		}
    		else if (line[0].equals("order")){
    			setOrder(Integer.valueOf(line[1]), line[2]);
    		}
    		} catch ( java.util.NoSuchElementException e){
    			loop = 0;
    			}
    		}
    	}

	/**
	 * Run the simulation from its current state for the given number of steps.
	 * Stop before the given number of steps if it ceases to be viable.
	 */
	public static void simulate()
	{
		tick = 1;
		runSimulation = true;
		while(runSimulation) {
			System.out.println("currently on tick " + Integer.toString(tick) + " press enter to run next tick:");
		    String userInput = sc.nextLine();
			simulateOneStep();
			print();
			tick++;
		}
	}

	/**
	 * Run the simulation from its current state for a single step.
	 * Iterate over the whole field updating the state of each
	 * fox and rabbit.
	 */
	public static void simulateOneStep()
	{
		System.out.println("simulateOneStep");
		if (simFinished()) {
			System.out.println("Simulation finished");
			runSimulation = false;
		} else {
			for (int p = 0; p < numOfStations; p++) {
				if (getPackingStationList(p).gotOrder() == false) {
					setOrder(p);
				}
				if (getPackingStationList(p).needsRobot()) {
					requestRobot(p);
				}
			}

			for (int x = 0; x < numOfRobots; x++){
				if (getRobotList(x).getBusy() || getRobotList(x).getReturnToPod()){
					Cell destination = getRobotList(x).getDestination();
					String direction = pF.getDirection(getRobotList(x).getX(),getRobotList(x).getY(), destination.getX(), destination.getY());
					System.out.println(direction);
					getRobotList(x).move(direction);
					System.out.println("Robot " + getRobotList(x).getRID() + " moved to " + getRobotList(x).getCell().toString());
					if ((getRobotList(x).getCell().getX() == getRobotList(x).getShelfCell().getX()) && (getRobotList(x).getCell().getY() == getRobotList(x).getShelfCell().getY())){
						getRobotList(x).pickItem();
						System.out.println("Robot " + getRobotList(x).getRID() + " reached shelf and picked up item");
					}
				}
			}

		}

	}


	private static void print(){
		System.out.println("Tick: " + tick);
		for (int x = 0; x < packingList.size(); x++){
			System.out.println(getPackingStationList(x).getpID() + " " + getPackingStationList(x).getCell().toString());
		}
		for (int x = 0; x < shelfList.size(); x++){
			System.out.println(shelfList.get(x).getsID() + " " + shelfList.get(x).getCell().toString());
		}
		for (int x = 0; x < robotList.size(); x++){
			System.out.println(getRobotList(x).getCPID() + " " + getRobotList(x).getPod().getCell().toString());
		}
		for (int x = 0; x < robotList.size(); x++){
			System.out.println(getRobotList(x).getRID() + " " + getRobotList(x).getCell().toString());
		}
		for (int x = 0; x < orderList.size(); x++){
			System.out.println("Order at " + getOrderList(x).getSID() + " and takes " + getOrderList(x).getTicks() + " ticks to unpack");
		}

	}



	private static boolean simFinished() {
		for (int x = 0; x < numOfRobots-1; x++){

			if (checkCrashed(x) != -1){
				System.out.println("Robot " + getRobotList(x).getRID() + " has crashed into Robot " + getRobotList
				(checkCrashed(x)).getRID());
				return true;
			}
			}
		for (int x = 0; x < numOfRobots-1; x++){

			if (getRobotList(x).getCharge() == 0){
				System.out.println("Robot " + getRobotList(x).getRID() + " has ran out of charge" );
				return true;
			}
			}
		if (orderList.size() > 0){
			return false;
		}
		for (int x = 0; x < numOfStations; x++){
			if (getPackingStationList(x).gotOrder()){
				return false;
			}
		}
		System.out.println("Simulation complete! All orders packed");
		return true;
	}

	private static void setOrder(int station) {
		Order nextOrder;
		nextOrder = orderList.get(0);
		getPackingStationList(station).setOrder(nextOrder);
		orderList.remove(0);
		System.out.println("Packing station " + getPackingStationList(station).getpID() + " has taken next order from list");
	}

	private static void requestRobot (int station){
		for (int x = 0; x < numOfRobots; x++){
			if(getRobotList(x).getBusy() == false){
				System.out.println("Packing station " + getPackingStationList(station).getpID() + " has requested robot " +  getRobotList(x).getRID() +
						" to retreive order from shelf " + getPackingStationList(station).getOrder().getSID());
				if (cE.trip(getRobotList(x).getX(), getRobotList(x).getY(), (double)getRobotList(x).getCharge(), getPackingStationList(station).getX(),
						getPackingStationList(station).getY(), getPackingStationList(station).getOrder().getX(), getPackingStationList(station).getOrder().getY())){

					getRobotList(x).setDestintion(getPackingStationList(station).getOrder().getPosition(), getPackingStationList(station).getCell());
					System.out.println("Robot has accepted the request");
					getRobotList(x).busy();
					getPackingStationList(station).hasRobot();
					x = numOfRobots;
				}
				else{
					System.out.println("Robot has denied the request, and is going to return to pod");
					getRobotList(x).returnToPod();
				}

			}

		}
		if (getPackingStationList(station).needsRobot()){
			System.out.println("No robots where free or decided to accept the request, station will try again on the next tick");
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
	    simulate();
	  //  System.out.println(grid.numOfSingleKit + " Storage Shelves");
	   // System.out.println(grid.numOfSingleKit + " Packing Stations");
	   // System.out.println(grid.numOfSingleKit + " Charging Pods");


	  }



}