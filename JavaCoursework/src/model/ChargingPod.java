package model;

import view.Cell;
/**
 * A class that is used to setup the ChargingPod
 * The object is used to charge the robot
 * @author 
 *
 */
public class ChargingPod {
	/**
	 * This is the ChargingPod unique ID
	 */
	String cID;
	/**
	 * The cell the pod is placed in
	 */
	Cell pos;
	/**
	 * The rate at which it charges the Robot battery
	 */
	int chargeSpeed;
    /**
     * Constructs the ChargingPod
     * @param cID is the id of the ChargingPod
     * @param cell is the cell the pod is placed in
     * @param chargeSpeed is the rate of charge
     */
	public ChargingPod(String cID, Cell cell, int chargeSpeed) {
		this.cID = cID;
		pos = cell;
		this.chargeSpeed = chargeSpeed;
	}
	/**
	 * returns the rate of charge
	 * @return <code>int</code> rate of charge of battery
	 */
	public int getCharge(){
		return chargeSpeed;
	}
	/**
	 * Returns the ID of the ChargingPod
	 * @return <code>String</code> ID of the pod 
	 */
	public String getID() {
		return cID;

	}
	/**
	 * Returns the cell the pod is in
	 * @return <code>Cell</code> position in Grid
	 */
	public Cell getCell(){
		return pos;
	}
}