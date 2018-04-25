package model;
import java.util.ArrayList;
import java.util.List;


import java.util.*;
import view.*;
/**
 * A class to create the robot object
 * @author xandie
 * @version 25/04/18
 */
public class Robot {
	/**
	 *Current robot battery level
	 * @see #charge()
	 */
    private int battery;
    /**
     * max battery level
     */
    private static final int  MAX_BATTERY = 20;
    /**
     * The cell that the robot is located in
     */
    private Cell pos;
    /**
     * Whether the robot crashed or not
     */
    private boolean hasCrashed;
    /**
     * Whether the robot is carrying an order or not
     */
    private boolean carrying;
  
    private ChargingPod pod;
    /**
     * Unique id of the robot
     */
    private String rID;
    /**
     * Name of a specific robot
     */
    static String NAME;
    /**
     * Contains the list of robots on the grid
     * @see #addRobot(Robot) 
     */
	List<Robot>	robotList = new ArrayList<Robot>();
	//public Cell[][] cell;

    /**
     * Creates a <code>Robot</code> and sets starting position
     * @param cell is the starting cell of the robot
     * @param rID is the unique robot ID
     * @param isFree 
     * @param battery sets the current battery level to full
     * @param pod creates an instance of ChargingPod
     */
    public Robot(Cell cell, String rID, boolean isFree, int battery, ChargingPod pod){
        pos = cell;
    	this.rID = rID;
    	battery = MAX_BATTERY;
    	hasCrashed = false;
    	carrying = false;
    	this.pod = pod;
    }
    /**
     * Adds robot to the robotList
     * @param r is the Robot being added
     */
    public void addRobot(Robot r) {
    	robotList.add(r);
    }
    
   /* public void charge(){
		while (robot.getCharge() <= MAX_BATTERY/2) 
		{
			robot.charge();
		}
	}*/
    /**
     * Removes robot from the robotList
     * @param r refers to the Robot being removed
     */
    public void removeRobot(Robot r) {
    	robotList.remove(r);
    }
    /**
     * Returns the maximum battery of the robot
     * @return <code>int</code> max battery level of robot
     */
    public int getMaxBattery() {
    	return MAX_BATTERY;
    }
    /**
     * Method to get the Robot moving around the grid
     * @param xChange 
     * @param yChange
     */
    public void move(int xChange, int yChange){
    	if (!hasCrashed & !(returnToPod())){
    		//move
    		powerMinus();
    		//checkLocation();
    	}
    }
    /*public void checkLocation(){
    	
    	
    	if (robotX == POD_X && robotY == POD_Y){
    		charge();
    	}
    	/*if (hitRobot()){
    		System.out.println("robot " + NAME + " crashed with another robot");
    		//stop simulation
    	}
    	
    	
    	
    
   /*public boolean hitRobot(){
    	for (int i = 0; grid.getRobots().length){
    		if (!(grid.getRobots()[i].equals(grid.getRobots()[NAME]))){
    			if (grid.getRobots()[i].getX() == robotX && grid.getRobots()[i].getY() == robotY){
    				return true;
    			}
    		}
    		i++;
    	}
    	return false;
    }*/
    /**
     * Returns the current cell of the Robot
     * @return <code>Cell</code> for where robot is located in the grid
     */
    public Cell getCell(){
    	return pos;
    }
    /**
     * Returns the current x position
     * @return <code>int</code> for x coordinate in grid
     */
    public int getX(){
    	return pos.getX();
    }
    /**
     * Returns the current y position
     * @return <code>int</code> for y coordinate in grid
     */
    public int getY(){
    	return pos.getY();
    }
    /**
     * Returns the ChargingPod of that particular Robot
     * @return <code>ChargingPod</code> that robots charging station
     */
    public ChargingPod getPod() {
    	return pod;
    }
    
    /**
     * Increments the battery level based on whether its carrying, crashed or not
     * If its carrying it takes 2 charge per tick
     * if not carrying it takes 1 charge per tick
     */
    private void powerMinus(){
    	//use one if not carrying anything two if it is
    	if(!hasCrashed) {
    		if(!carrying) {
    			battery--;
    		}
    		else if(carrying) {
    			battery = battery -2;
    		}
    	}
    	else if(hasCrashed) {
    		System.out.println("One of the robots crashed, the simulation will now exit");
    		//EXIT SIMULATION
    	}
    	
    }
    /**
     * If the robot accepts an assignment, carrying set to true
     */
    public void acceptAssignment(){
    	carrying = true;
    }
    /**
     * returns when the Robot needs to return to pod
     * @return <code>boolean</code> if the Robot requires battery
     */
    public boolean returnToPod(){
    	return false;
    }
    /**
     * returns the battery level of the Robot
     * @return <code>int</code> current battery level
     */
    public int getCharge() {
    	return battery;
    }
    /**
     * Used to charge the Robot battery
     * It increments 1 per tick
     */
    public void charge() {
    	battery++;
    }
}