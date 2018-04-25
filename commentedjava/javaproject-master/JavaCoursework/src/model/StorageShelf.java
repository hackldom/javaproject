package model;
/**
 * A class for the StorageShelf object
 * @author xandie
 * @version 25/04/18
 */
public class StorageShelf {
	private int Shelves[]; 
	
	/**
	 * returns the shelf number that the order can be taken from
	 * @param shelfNumber refers to a particular StorageShelf
	 * @return <code>int</code> gets the shelf required
	 */
	public int getShelf(int shelfNumber)
	{
		int orderedItem = Shelves[shelfNumber];
		return orderedItem;
	}

}
