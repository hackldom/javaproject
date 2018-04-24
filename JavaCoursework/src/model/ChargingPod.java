package model;

import view.Cell;

public class ChargingPod {
	String cID;
	Cell pos;
	int chargeSpeed;
	
	public ChargingPod(String cID, Cell cell, int chargeSpeed) {
		this.cID = cID;
		pos = cell;
		this.chargeSpeed = chargeSpeed;
	}
	
	public int getCharge(){
		return chargeSpeed;
	}
	
	public String getID() {
		return cID;
	
	}
}