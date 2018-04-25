package model;

import view.Cell;

public class PackingStation {
	private Cell cell;
	private String pID;
	private Order order;
	
	
	public PackingStation(Cell cell, String pID){
		this.cell = cell;
		this.pID = pID;
	}
	
	public String getpID(){
		return pID;
	}

	public boolean gotOrder() {
		if (order.equals(null)){
			return false;
		}
		return true;
	}
	
	public void setOrder (Order order){
		this.order = order;
	}
	
	public int getX(){
		return cell.getX();
	}
	
	public int getY(){
		return cell.getY();
	}
}
