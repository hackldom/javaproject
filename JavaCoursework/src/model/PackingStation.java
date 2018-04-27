package model;

import view.Cell;
/**
 * The PackingStation class is used to make the PackingStation for the order
 * @author 
 *
 */
public class PackingStation {
	/**
	 * cell is used to store position of PackingStation 
	 */
	private Cell cell;
	/**
	 * pID is the individual packingStation reference
	 */
	private String pID;
	/**
	 * is the order currently being processed
	 */
	private Order order;
	/**
	 * If the packingStation is ready to be used
	 */
	private boolean needsRobot;
	/**
	 * If the packingStation is in use for order
	 */
	private boolean hasOrder;
	/**
	 * rID is the robot unique ID
	 */
	private String rID;

	/**
	 * Creates a <code>PackingStation</code> for robots use
	 * @param cell is the cell position of the robot
	 * @param pID is the PackingStation reference ID
	 */
	public PackingStation(Cell cell, String pID){
		this.cell = cell;
		this.pID = pID;
		needsRobot = true;
		hasOrder = false;
	}
	/**
	 * Returns the PackingStation ID
	 * @return <code>String</code> PackingStation ID
	 */
	public String getPID(){
		return pID;
	}
	/**
	 * Returns the Robot ID
	 * @return <code>String</code> Robot ID
	 */
	public String getRID(){
		return rID;
	}
	/**
	 * Returns when ready to be used
	 * @return <code>Boolean</code> If not in use by Robot
	 */
	public boolean readyToPack(){
		return hasOrder;
	}
	/**
	 * Returns when ready to be used
	 * @return <code>Boolean</code> If not in use by Robot
	 */
	public boolean gotOrder() {
		if (order == null){
			return false;
		}
		return true;
	}
	/**
	 * Used to set the order currently being packed
	 * @param order is the current order being packed
	 */
	public void setOrder (Order order){
		this.order = order;
	}

	public Order getOrder(){
		return order;
	}

	public boolean needsRobot(){
		return needsRobot;
	}

	public int getX(){
		return cell.getX();
	}

	public int getY(){
		return cell.getY();
	}

	public Cell getCell(){
		return cell;
	}

	public void hasRobot(String rID){
		this.rID = rID;
		needsRobot = false;
	}

	public void removeRobot(){
		rID = "";
		needsRobot = true;
	}
	
	public void hasOrder(){
		hasOrder = true;
	}
	
	public void pack(){
		order.changeTicks();
		if (order.getTicks() == 0){
			order = null;
			hasOrder = false;
			System.out.println("Packing Station " + getPID() + " finished packing its order");
		}
		else {
			System.out.println("Packing Station " + getPID() + " is packing its order");
		}
		
	}

}

