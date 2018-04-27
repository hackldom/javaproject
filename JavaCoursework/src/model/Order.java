package model;

import view.Cell;
/**
 * A class that stores the location of the order and where the storage shelf is containing the required items
 * @author 
 *
 */
public class Order {
	/**
	 * ticks is the incremental time of the simulation
	 */
	private int ticks;
	/**
	 * cell is location of StorageShelf containing items
	 */
	private Cell cell;
	/**
	 * sID is the StorageShelf ID
	 */
	private String sID;
	/**
	 * Creates an <code>Order</code> 
	 * sets time it takes, position and shelf its located in
	 * @param ticks is time to do order
	 * @param cell is position of StorageShelf
	 * @param sID is StorageShelf unique ID
	 */
	public Order (int ticks, Cell cell, String sID){
		this.ticks = ticks;
		this.cell = cell;
		this.sID = sID;
	}
	/**
	 * Returns the number of ticks to complete order
	 * @return <code>int</code> number of ticks
	 */
	public int getTicks(){
		return ticks;
	}
	/**
	 * Returns the position for Robot to get the items for the order
	 * @return <code>Cell</code> position of shelf
	 */
	public Cell getPosition(){
		return cell;
	}
	/**
	 * Returns the required shelf ID
	 * @return <code>String</code> shelf ID
	 */
	public String getSID(){
		return sID;
	}
	/**
	 * Returns the x coordinate of the shelf in Grid
	 * @return <code>int</code> x location of StorageShelf
	 */
	public int getX(){
		return cell.getX();
	}
	/**
	 * Returns the y coordinate of the shelf in Grid
	 * @return <code>int</code> y location of StorageShelf
	 */
	public int getY(){
		return cell.getY();
	}
	/**
	 * Reduces the number of ticks by 1 as the order is processed
	 * 
	 */
	public void changeTicks(){
		ticks--;
	}


}