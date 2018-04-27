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
	 * Robots cell position
	 */
    private Cell pos;
    /**
	 * Whether it has item or not
	 */
    private boolean gotItem;
    /**
     * Whether Robot is currently processing an order
     * @see #free()
     */
    private boolean busy;
    /**
     * pod is ChargingPod object
     */
    private ChargingPod pod;
    /**
     * Id of the robot
     */
    private String rID;
    /**
     * battery level of the robot
     */
	private int charge;
	/**
	 * Max charge of the battery
	 */
	public static int MAX_CHARGE;
	/**
	 * ChargingPod ID
	 */
	private String cpID;
	/**
	 * Location of StorageShelf
	 */
    private Cell shelfCell;
    /**
     * Location of PackingStation
     */
    private Cell stationCell;
    /**
     * Robot return to pod or not
     */
    private boolean returnToPod;
    /**
     * ArrayList containing the Robots in the simulation
     */
	List<Robot>	robotList = new ArrayList<Robot>();
	/**
	 * Creates a <code>Robot</code> and sets its position, battery, id and ChargingPod
	 * @param cell location of Robot
	 * @param rID Robot ID
	 * @param isFree Whether its being used or not
	 * @param battery battery level of the Robot
	 * @param pod is the Robots paired ChargingPod
	 */
    public Robot(Cell cell, String rID, boolean isFree, int battery, ChargingPod pod){
    	pos = cell;
    	this.rID = rID;
    	this.charge = battery;
    	gotItem = false;
    	this.pod = pod;
    	busy = false;
    	MAX_CHARGE = battery;
    }
    /**
     * Adds the Robot to the ArrayList
     * @param r is the robot reference
     */
    public void addRobot(Robot r) {
    	robotList.add(r);
    }
    /**
     * Allows the Robot to move around the Grid
     * It returns whether true it moves or not
     * @param direction determines the direction the Robot travels in next
     * @return <code>boolean</code> deciding if it moves or not
     */
	public boolean move(String direction){
		try{
		if (direction.equals("d")){
			pos.changeY(1);
		}
		if (direction.equals("u")){
			pos.changeY(-1);
		}
		if (direction.equals("r")){
			pos.changeX(1);
		}
		if (direction.equals("l")){
			pos.changeX(-1);
		}
		powerMinus();
		return true;
		}
		catch (java.lang.NullPointerException e)
		{
			return false;
		}
	}
	/**
	 * The robot picks up the item and sets gotItem to true
	 */
	public void pickItem() {
		gotItem = true;
	}
	/**
	 * The robot drops the item after finishing the order
	 */
	public void drop() {
		gotItem = false;
		busy = false;
	}
	/**
	 * This returns the current position of the Robot
	 * @return <code>Cell</code> of the robot
	 */
	public Cell getCell(){
		return pos;
	}
	/**
	 * Returns the x location of Robot in Grid
	 * @return <code>int</code> x coordinate
	 */
	public int getX(){
		return pos.getX();
	}
	/**
	 * Returns the y location of Robot in Grid
	 * @return <code>int</code> y coordinate
	 */
	public int getY(){
		return pos.getY();
	}
	/**
	 * Returns whether the Robot is busy or not
	 * @return <code>boolean</code> robot is processing order, or not
	 */
	public boolean getBusy(){
		return busy;
	}
	/**
	 * Returns whether robot returns to pod or not
	 * @return <code>boolean</code> Robot return to pod or not
	 */
	public boolean getReturnToPod(){
		return returnToPod;
	}
	/**
	 * Returns whether the Robot has items or not
	 * @return <code>boolean</code> Robot is carrying or not
	 */
	public boolean carrying() {
		return gotItem;
	}
	/**
	 * Returns the ChargingPod unique ID
	 * @return <code>String</code> the ChargingPod ID
	 */
	public String getCPID() {
		return pod.getID();
	}
	/**
	 * Returns the Robot unique ID
	 * @return <code>String</code> the Robt ID
	 */
	public String getRID() {
		return rID;
	}
	/**
	 * Returns the charge level of Robot
	 * @return <code>int</code> battery level of Robot
	 */
	public int getCharge() {
		return charge;
	}
	/**
	 * Returns the location of PackingStation
	 * @return <code>Cell</code> PackingStation position in Grid
	 */
	public Cell getStationCell(){
		return stationCell;
	}
	/**
	 * Returns the location of StorageShelf
	 * @return <code>Cell</code> StorageShelf position in Grid
	 */
	public Cell getShelfCell(){
		return shelfCell;
	}
	/**
	 * Whether the Robot is not processing an order
	 */
	public void free(){
		busy = false;
	}
	/**
	 * Whether the Robot is processing an order
	 */
	public void busy(){
		busy = true;
	}
	/**
	 * Returns the cell of the destination location
	 * @return <code>Cell</code> position of the desired location
	 */
	public Cell getDestination(){
		if (getBusy()){
			if (gotItem){
				return stationCell;
			}
			else{

				return shelfCell;
			}
		}
		if (returnToPod){
			return pod.getCell();
		}
		else {
			return pos;
		}
	}
	/**
	 * Sends the robot back to its ChargingPod
	 */
	public void returnToPod(){
		returnToPod = true;
	}
	/**
	 * Sets the destination of the Robot
	 * @param shelf is the StorageShelf
	 * @param station is the PackingStation
	 */
	public void setDestintion (Cell shelf, Cell station){
    	shelfCell = shelf;
    	stationCell = station;
    }
	/**
	 * Increments the battery level by 1 when charging
	 */
	public void charge() {
		charge++;
	}
	/**
	 * Returns the Robots ChargingPod
	 * @return <code>ChargingPod</code> for Robot
	 */
	public ChargingPod getPod(){
		return pod;
	}
	/**
	 * Decreases power by 1 if empty, two if carrying
	 */
	private void powerMinus(){
		
		if (gotItem){
			charge = charge - 2;
		}
		else{
			charge = charge - 1;
		}
	}

}
