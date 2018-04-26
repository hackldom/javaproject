package model;

public class StorageShelf {
	private int Shelves[]; 
	
	
	public int getShelf(int shelfNumber)
	{
		int orderedItem = Shelves[shelfNumber];
		return orderedItem;
	}

}
