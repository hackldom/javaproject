package model;

import view.Cell;
/**
 * The StorageShelf class is used to create shelves which hold the items for an order
 * @author
 *
 */
public class StorageShelf {
	/**
	 * The Id of the shelf
	 */
	private String sID;
	/**
	 * The cell its located in
	 */
	private Cell cell;
	/**
	 * Creates the <code>StorageShelf</code> and sets position and ID
	 * @param cell is the position in the Grid
	 * @param sID is the unique ID of the StorageShelf
	 */
	public StorageShelf(Cell cell, String sID) {
		this.cell = cell;
		this.sID = sID;
	}
	
	/**
	 * Returns the StorageShelf ID
	 * @return <code>String</code> Id of StorageShelf
	 */
	public String getsID() {
		return sID;
	}
	/**
	 * returns the cell position
	 * @return <code>Cell</code> position of the StorageShelf
	 */
	public Cell getCell() {
		return cell;
	}
	/**
	 * Returns the x position of the StorageShelf in the Grid
	 * @return <code>int</code> x position of cell located in
	 */
	public int getX(){
		return cell.getX();
	}
	/**
	 * Returns the y position of the StorageShelf in the Grid
	 * @return
	 */
	public int getY(){
		return cell.getY();
	}
	

}
