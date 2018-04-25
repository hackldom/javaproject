package model;

import view.Cell;
/**
 * A class for the chargingPod object
 * @author xandie
 *
 */
public class ChargingPod {
	/**
	 * refers to a particular ChargingPod
	 * 	 
	 */
	String cID;
	/**
	 * cell that the ChargingPod is located in
	 * @see #getID()
	 */
	Cell pos;
	/**
	 * rate at which robot battery charges per tick of simulation
	 * @see #getCharge()
	 */
	int chargeSpeed;
	
	/**
	 * Constructor for the ChargingPod object
	 * @param cID is the unique id of each ChargingPod
	 * @param cell refers to the cell the ChargingPod is located in
	 * @param chargeSpeed is the rate of charge
	 */
	
	public ChargingPod(String cID, Cell cell, int chargeSpeed) {
		this.cID = cID;
		pos = cell;
		this.chargeSpeed = chargeSpeed;
	}
	
	/**
	 * returns the chargeSpeed
	 * @return <code>int</code> for rate of charge
	 */
	public int getCharge(){
		return chargeSpeed;
	}
	/**
	 * returns ChargingPod ID
	 * @return <code>String</code> for ID
	 */
	public String getID() {
		return cID;
	
	}
}