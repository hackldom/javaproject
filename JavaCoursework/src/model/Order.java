package model;

import view.Cell;

public class Order {
	private int ticks;
	private Cell cell;
	
	public Order (int ticks, Cell cell){
		this.ticks = ticks;
		this.cell = cell;
	}
	
	public int getTicks(){
		return ticks;
	}
	
	public Cell getPosition(){
		return cell;
	}
	
	public void changeTicks(){
		ticks--;
	}

}