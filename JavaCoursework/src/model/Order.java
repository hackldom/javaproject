package model;

import view.Cell;

public class Order {
	private int ticks;
	private Cell cell;
	private String sID;

	public Order (int ticks, Cell cell, String sID){
		this.ticks = ticks;
		this.cell = cell;
		this.sID = sID;
	}

	public int getTicks(){
		return ticks;
	}

	public Cell getPosition(){
		return cell;
	}

	public String getSID(){
		return sID;
	}

	public int getX(){
		return cell.getX();
	}

	public int getY(){
		return cell.getY();
	}

	public void changeTicks(){
		ticks--;
	}


}