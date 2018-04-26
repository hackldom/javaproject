package model;
import java.util.ArrayList;
import java.util.List;


import java.util.*;
import view.*;
public class Robot {
    private int battery;
    private static final int  MAX_BATTERY = 20;
    private Cell pos;
    private boolean hasCrashed;
    private boolean carrying;
    private ChargingPod pod;
    private String rID;
    
    static String NAME;
	List<Robot>	robotList = new ArrayList<Robot>();
	//public Cell[][] cell;

    
    public Robot(Cell cell, String rID, boolean isFree, int battery, ChargingPod pod){
    pos = cell;
    	this.rID = rID;
    	battery = MAX_BATTERY;
    	hasCrashed = false;
    	carrying = false;
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
    
    public int getMaxBattery() {
    	return MAX_BATTERY;
    }
    
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
    
    public Cell getCell(){
    	return pos;
    }
    
    
    public int getX(){
    	return pos.getX();
    }
    
    public int getY(){
    	return pos.getY();
    }
    
    public ChargingPod getPod() {
    	return pod;
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