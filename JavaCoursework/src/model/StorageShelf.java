package model;

import view.Cell;

public class StorageShelf {
	private int sId;
	private Cell cell;
	
	public StorageShelf(Cell cell, int sID) {
		this.sId = sID;
	}
	
	
	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

}
