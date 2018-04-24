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
	 *returns number of items a
	 * @return
	 */
	
	public int checkOrders() {
		return orders.length;
	}
	
	public void checkNextOrder() {
		
	}
	
	public void changeStatus(String stat) {
		status = stat;
	}
	
	public void setOrders(int ord) {
		orders = new String[ord];
	}
	
	public void setNext(String next) {
		for (int i=0; i<orders.length; i++) {
			if (!orders[i].isEmpty()) {
				orders[i] = next;
			}
		}

	}
}
