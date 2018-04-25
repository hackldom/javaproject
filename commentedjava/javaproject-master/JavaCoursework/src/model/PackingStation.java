package model;
/**
 * A class to create the PackingStation object
 * @author xandie
 * @version 25/04/18
 */
public class PackingStation {
	/**
	 * status is whether the packing station is in use 
	 */
	private String status;
	/**
	 * orders contains all the items in an order in String array
	 * @see #checkPS()
	 */
	private String[] orders;
	
	/**
	 * Constructor for PackingStation
	 * @param cell 
	 * @param ord puts the order into the orders array
	 * @param stat
	 */
	public PackingStation(Cell cell, int ord, int stat){
		orders = new String[ord];
	}
	/**
	 * returns the current status of the PackingStation
	 * @return <code>String</code> for status
	 */
	public String checkPS() {
		return status;
	}
	/**
	 * returns the length of the order
	 * @return <code>int</code> for length of the order
	 */
	public int checkOrders() {
		return orders.length;
	}
	
	public void checkNextOrder() {
		
	}
	/**
	 * Changes the status of the PackingStation (it may no longer be in use)
	 * @param stat changes the current status String
	 */
	public void changeStatus(String stat) {
		status = stat;
	}
	/**
	 * Sets the array with an order
	 * @param ord a list of items in an order
	 */
	public void setOrders(int ord) {
		orders = new String[ord];
	}
	/**
	 * Sets up the next order
	 * @param next is the items in the following order
	 */
	public void setNext(String next) {
		for (int i=0; i<orders.length; i++) {
			if (!orders[i].isEmpty()) {
				orders[i] = next;
			}
		}

	}
}
