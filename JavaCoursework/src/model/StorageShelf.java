package model;
/**
 * Represents the StorageShelf object
 * @author 
 *
 */
public class StorageShelf {
	private int Shelves[]; 
	
	/**
	 * returns the shelfNumber where ordered item is being taken from  
	 * @param shelfNumber accesses the shelf number
	 * @return orderedItem <code>int</code>  
	 */
	
	public int getShelf(int shelfNumber)
	{
		int orderedItem = Shelves[shelfNumber];
		return orderedItem;
	}

}
