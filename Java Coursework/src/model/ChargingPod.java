package model;

import javafx.scene.text.Text;

public class ChargingPod {
	private static final int  MAX_BATTERY = 20;
	private boolean isCharging;
	private Robot robot;
	Text text = new Text();
	
	public ChargingPod() {
		
	}
	
	public void charge(){
		while (robot.getCharge() <= MAX_BATTERY/2) 
		{
			robot.charge();
		}
	}
	public void drawChargingPod() {
		text.setText("Charging");
		
	}
	
	
}