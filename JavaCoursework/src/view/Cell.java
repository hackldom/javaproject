package view;
/**
 * A class to create a cell
 * @author
 *
 */
public class Cell {
	/**
	 * x position of the cell
	 */
	protected int posX;
	/**
	 * y position of the cell
	 */
	protected int posY;
	/**
	 * Creates the <code>Cell</code> and sets the position
	 * @param posx x position of the cell
	 * @param posy y position of the cell
	 */
    public Cell(int posx, int posy) {
		this.posX = posx;
		this.posY = posy;
		}
    /**
     * Returns the x-coordinate
     * @return <code>int</code> x position of cell
     */
    public int getX() {
    	return posX;
    }
    /**
     * Returns the y-coordinate
     * @return <code>int</code> y position of cell
     */
    public int getY() {
    	return posY;
    }
    /**
     * Changes the x-position ready for the next cell
     * @param c is the amount the current position is changed by
     */
    public void changeX(int c){
    	posX = posX+c;
    }
    /**
     * Changes the y-position ready for the next cell
     * @param c is the amount the current position is changed by
     */
    public void changeY(int c){
    	posY = posY+c;
    }
    /**
     * Returns the position of the cell as Strings
     */
    public String toString(){
    	String toReturn = ("(" + posX + ", " + posY + ")");
    	return toReturn;
    }
}
