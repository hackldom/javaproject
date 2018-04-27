package model;
import java.util.ArrayList;
import java.util.List;


import java.util.*;
import view.*;
public class Robot {
    private Cell pos;
    private boolean gotItem;
    private boolean busy;
    private ChargingPod pod;
    private String rID;
	private int charge;
	public static int MAX_CHARGE;
	private String cpID;
    private Cell shelfCell;
    private Cell stationCell;
    private boolean returnToPod;
	List<Robot>	robotList = new ArrayList<Robot>();

    public Robot(Cell cell, String rID, boolean isFree, int battery, ChargingPod pod){
    	pos = cell;
    	this.rID = rID;
    	this.charge = battery;
    	gotItem = false;
    	this.pod = pod;
    	busy = false;
    	MAX_CHARGE = battery;
    }

    public void addRobot(Robot r) {
    	robotList.add(r);
    }

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

	public void pickItem() {
		gotItem = true;
	}

	public void drop() {
		gotItem = false;
		busy = false;
	}

	public Cell getCell(){
		return pos;
	}

	public int getX(){
		return pos.getX();
	}

	public int getY(){
		return pos.getY();
	}

	public boolean getBusy(){
		return busy;
	}

	public boolean getReturnToPod(){
		return returnToPod;
	}

	public boolean carrying() {
		return gotItem;
	}

	public String getCPID() {
		return pod.getID();
	}

	public String getRID() {
		return rID;
	}

	public int getCharge() {
		return charge;
	}

	public Cell getStationCell(){
		return stationCell;
	}

	public Cell getShelfCell(){
		return shelfCell;
	}

	public void free(){
		busy = false;
	}

	public void busy(){
		busy = true;
	}

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

	public void returnToPod(){
		returnToPod = true;
	}

	public void setDestintion (Cell shelf, Cell station){
    	shelfCell = shelf;
    	stationCell = station;
    }

	public void charge() {
		charge++;
	}

	public ChargingPod getPod(){
		return pod;
	}

	private void powerMinus(){
		//use one if not carrying anything two if it is
		if (gotItem){
			charge = charge - 2;
		}
		else{
			charge = charge - 1;
		}
	}

}
