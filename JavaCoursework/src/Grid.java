import java.util.Scanner;

public class Grid{
	
	//Height and width could be replaced by size, as it's always going to be a square
	private double height;
	private double width;
	private Cell[][] cells;
	private static int userInput;
	static Scanner sc=new Scanner(System.in);
	static double squares;
	static double numOfSingleKit;
	static double numOfObjects;
	
	public Grid(double size) {
		this.height = size;
		this.width = size;
		cells = new Cell[(int) width][(int) height];
		squares = size * size;
		numOfObjects = Math.round(squares / 3.0);
		numOfSingleKit = Math.round(numOfObjects / 3.0);
	}
	
	public int getGridHeight() {
		return (int)height;
	}
	
	public int getGridWidth() { 
		return (int)width;
	}
	
	public void setGridHeight(int height) {
		this.height = height;
	}
	
	public void setGridWidth(int width) {
		this.width = width;
	}
	
	public static void main(String[] args) {
	    System.out.println("How many rows/columns would you like in the grid?");
	    userInput = sc.nextInt();
	    Grid grid = new Grid(userInput);
	    System.out.println("There are " + userInput + " rows and columns");
	    System.out.println("There are " + (userInput * userInput) + " cells in the grid" );
	    System.out.println("There are " + numOfObjects + " objects, out of which there are:");
	    
	    double numRobot = (double) Math.rint(numOfSingleKit);
	    
	    
	    
	    System.out.println(grid.numOfSingleKit+ " Robots");
	    System.out.println(grid.numOfSingleKit + " Storage Shelves");
	    System.out.println(grid.numOfSingleKit + " Packing Stations");
	    System.out.println(grid.numOfSingleKit + " Chargin' Pods");
	  }
	
	
}
