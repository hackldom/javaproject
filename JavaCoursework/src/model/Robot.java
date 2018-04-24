package model;
import java.util.ArrayList;
import java.util.List;


import java.util.*;
import view.*;
/**
 * A class to represent the Robot object
 * @author 
 * @version 24/04/18
 *
 */

public class Robot {
	/**
	 * battery gives level of charge
	 * @see #getCharge()
	 */
    private int battery;
    /**
     * Maximum battery capacity of the robot
     */
    private static final int  MAX_BATTERY = 20;
    /**
     * refers to X position of the robot in the grid
     */
    private Cell[] robotX;
    /**
     * refers to Y position of the robot in the grid
     */
    private Cell[] robotY;
    /**
     * whether the robot has crashed or still functioning
     */
    private boolean hasCrashed;
    /**
     * Whether the robot is carrying an order or not
     */
    private boolean carrying;
    /**
     * 
     */
    static String NAME;
    /**
     * An ArrayList to store objects of type Robot
     * @see #addRobot(Robot) 
     */
	List<Robot>	robotList = new ArrayList<Robot>();
	//public Cell[][] cell;

    /**
     * Creates a <code>Robot</code> with its position on the grid 
     * @param x is the coordinate of the Robot in the grid
     * @param y is the coordinate of the Robot in the grid
     * @param isFree
     * @param battery refers to current battery level
     */
    public Robot(Cell[] x, Cell[] y, boolean isFree, int battery){
    	x = robotX;
    	y = robotY;
    	
    	battery = MAX_BATTERY;
    	hasCrashed = false;
    	carrying = false;
    }
    /**
     * adds a Robot to the robotList ArrayList
     * @param r is the Robot being added
     */
    public void addRobot(Robot r) {
    	robotList.add(r);
    }
    /**
     * removes a robot from the robotList ArrayList
     * @param r represents the robot being removed
     */ 
    public void removeRobot(Robot r) {
    	robotList.remove(r);
    }
    /**
     * returns the maximum battery
     * @return <code>int</code> MAX_BATTERY
     */
    public int getMaxBattery() {
    	return MAX_BATTERY;
    }
    /**
     * method that makes the robot move
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
    	
    	
    }*/
    	
    
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
    
    public Cell[] getX(){
    	return robotX;
    }
    
    public Cell[] getY(){
    	return robotY;
    }
    
    
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
    
    public void acceptAssignment(){
    	carrying = true;
    }
    public boolean returnToPod(){
    	return false;
    }
    
    public int getCharge() {
    	return battery;
    }
    
    public void charge() {
    	battery++;
    }
}