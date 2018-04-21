package model;
import java.util.ArrayList;
import java.util.List;


import java.util.*;

public class Robot {
    private int battery;
    private static final int  MAX_BATTERY = 20;
    private int robotX;
    private int robotY;
    private boolean hasCrashed;
    private boolean carrying;
    static int POD_X;
    static int POD_Y;
    static String NAME;
	List<Robot>	robotList = new ArrayList<Robot>();

    
    public Robot(int x, int y, boolean isFree, int battery){
    	x = robotX;
    	y = robotY;
    	POD_X = x;
    	POD_Y = y;
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
    
    
    public void move(int xChange, int yChange){
    	if (!hasCrashed & !(returnToPod())){
    		//move
    		powerMinus();
    		checkLocation();
    	}
    }
    
    public void checkLocation(){
    	
    	
    	if (robotX == POD_X && robotY == POD_Y){
    		charge();
    	}
    	/*if (hitRobot()){
    		System.out.println("robot " + NAME + " crashed with another robot");
    		//stop simulation
    	}*/
    	
    	
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
    
    public int getX(){
    	return robotX;
    }
    
    public int getY(){
    	return robotY;
    }
    
    
    private void powerMinus(){
    	//use one if not carrying anything two if it is
    	if (battery == 0){
    		hasCrashed = true;
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