package model;
/**
 * Represents the object PackingStation
 * @author 
 *
 */
public class PackingStation {
	/**
	 * refers to current packingStation status
	 * @see #checkPS
	 */
	private String status;
	/**
	 * keeps an array of orders used by the robot
	 * @see #checkOrders
	 */
	private String[] orders;
	
	/**
	 * Creates a <code>PackingStation</code> holding items from orders
	 * @param ord is the number of orders contained in the array
	 * @param stat is the 
	 */
	public PackingStation(int ord, int stat){
		orders = new String[ord];
	}
	
	/**
	 * returns current status of the PackingStation has
	 * @return <code>String</code> status found by {@link #status} 
	 */
	public String checkPS() {
		return status;
	}
	
	/**
	 *returns number of orders being carried out
	 *@return <code>int</code length of orders array {@link #orders}
	 * 
	 */
	public int checkOrders() {
		return orders.length;
	}
	/**
	 * 
	 */
	
	public void checkNextOrder() {
		
	}
	/**
	 * used to change current PackingStation status
	 * @param stat refers to the 
	 */
	public void changeStatus(String stat) {
		status = stat;
	}
	/**
	 * sets the current order being packed
	 * @param ord sets the orders
	 */
	public void setOrders(int ord) {
		orders = new String[ord];
	}
	/**
	 * sets the next order to be packed
	 * @param next sets the next order to be packed
	 */
	public void setNext(String next) {
		for (int i=0; i<orders.length; i++) {
			if (!orders[i].isEmpty()) {
				orders[i] = next;
			}
		}

	}
}
