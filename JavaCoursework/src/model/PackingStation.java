package model;

import view.Cell;

public class PackingStation {
	private String status;
	private String[] orders;


	public PackingStation(Cell cell, int ord, int stat){
		orders = new String[ord];
	}

	public String checkPS() {
		return status;
	}

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
