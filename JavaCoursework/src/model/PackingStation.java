package model;

import view.Cell;

public class PackingStation {
	private Cell cell;
	private String pID;
	private Order order;
	private boolean needsRobot;
	private boolean hasOrder;
	private String rID;


	public PackingStation(Cell cell, String pID){
		this.cell = cell;
		this.pID = pID;
		needsRobot = true;
		hasOrder = false;
	}

	public String getPID(){
		return pID;
	}
	
	public String getRID(){
		return rID;
	}
	
	public boolean readyToPack(){
		return hasOrder;
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

