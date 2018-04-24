package model;

import javafx.scene.text.Text;
/**
 * represent ChargingPod object
 * @author 
 * @version 24/04/18
 */
public class ChargingPod {
	/**
	 * Max robot battery
	 */
	private static final int  MAX_BATTERY = 20;
	/**
	 * Determines whether robot is charging or not
	 */
	private boolean isCharging;
	/**
	 * Creates a field of type robot
	 */
	private Robot robot;
	/**
	 * Field to store text
	 * @see #drawChargingPod()
	 */
	Text text = new Text();
	
	public ChargingPod() {
		
	}
	/**
	 * Charge the robot
	 * {@link #robot}
	 */
	public void charge(){
		while (robot.getCharge() <= MAX_BATTERY/2) 
		{
			robot.charge();
		}
	}
	/**
	 * draw the charging pod
	 *
	 * {@link #text}
	 */
	public void drawChargingPod() {
		text.setText("Charging");
	}
	
	
}