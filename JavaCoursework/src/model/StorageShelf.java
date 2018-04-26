package model;

import view.Cell;

public class StorageShelf {
	private String sID;
	private Cell cell;
	
	public StorageShelf(Cell cell, String sID) {
		this.cell = cell;
		this.sID = sID;
	}
	
	
	public String getsID() {
		return sID;
	}
	
	public Cell getCell() {
		return cell;
	}
	public int getX(){
		return cell.getX();
	}
	public int getY(){
		return cell.getY();
	}
	

}
