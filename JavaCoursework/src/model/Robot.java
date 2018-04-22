package model;
import java.util.ArrayList;
import java.util.List;


import java.util.*;
import view.*;
public class Robot {
    private int battery;
    private static final int  MAX_BATTERY = 20;
    private Cell[] robotX;
    private Cell[] robotY;
    private boolean hasCrashed;
    private boolean carrying;
    
    static String NAME;
	List<Robot>	robotList = new ArrayList<Robot>();
	//public Cell[][] cell;

    
    public Robot(Cell[] x, Cell[] y, boolean isFree, int battery){
    	x = robotX;
    	y = robotY;
    	
    	battery = MAX_BATTERY;
    	hasCrashed = false;
    	carrying = false;
    }

    public void addRobot(Robot r) {
    	robotList.add(r);
    }
    
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