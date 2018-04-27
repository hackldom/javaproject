package model;

import view.Cell;

public class PackingStation {
	private Cell cell;
	private String pID;
	private Order order;
	private boolean needsRobot;


	public PackingStation(Cell cell, String pID){
		this.cell = cell;
		this.pID = pID;
		needsRobot = true;
	}

	public String getpID(){
		return pID;
	}

	public boolean gotOrder() {
		if (order == null){
			return false;
		}
		return true;
	}

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

	public void hasRobot(){
		needsRobot = false;
	}

	public void removeRobot(){
		needsRobot = true;
	}

}

