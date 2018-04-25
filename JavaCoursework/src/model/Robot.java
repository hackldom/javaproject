package model;
import java.util.ArrayList;
import java.util.List;


import java.util.*;
import view.*;
public class Robot {
    private int battery;
    private static final int  MAX_BATTERY = 20;
    private Cell pos;
    private String item;
    private boolean crashed;
    private boolean gotItem;
    private ChargingPod pod;
    private String rID;
	private int charge;
	private String cpID;
    static String NAME;
	List<Robot>	robotList = new ArrayList<Robot>();

	//public Cell[][] cell;

    
    public Robot(Cell cell, String rID, boolean isFree, int battery, ChargingPod pod){
    	pos = cell;
    	this.rID = rID;
    	battery = MAX_BATTERY;
    	crashed = false;
    	gotItem = false;
    	this.pod = pod;
    }

    public void addRobot(Robot r) {
    	robotList.add(r);
    }
    
   /* public void charge(){
		while (robot.getCharge() <= MAX_BATTERY/2) 
		{
			robot.charge();
		}
	}*/
    
    public void removeRobot(Robot r) {
    	robotList.remove(r);
    }
    
	public void move(int xChange, int yChange){
		if (!crashed){
			//move
			powerMinus();
		}
		else if (gotItem = true) {
			powerMinus();
			powerMinus();
		}
		else {
			powerMinus();
		}
	}

	public void pickItem(String itemName) {
		item = itemName;
		gotItem = true;
	}

	public void drop() {
		item = "";
		gotItem = false;
	}

	public int getX(){
		return pos.getX();
	}

	public int getY(){
		return pos.getY();
	}

	public boolean getCrashed() {
		return crashed;
	}

	public String getItem() {
		return item;
	}

	public boolean carrying() {
		return gotItem;
	}

	public String getCPID() {
		return cpID;
	}

	public String getRID() {
		return rID;
	}

	public int getCharge() {
		return charge;
	}

	public void charge() {
		charge++;
	}

	private void powerMinus(){
		//use one if not carrying anything two if it is
		charge = charge - 1;
		if (charge == 0){
			crashed = true;
		}
	}

}
