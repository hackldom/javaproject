package view;
/**
 * A class which represent an individual cell in the Grid
 * @author xandie
 * @version 25/04/18
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
	 * Creates a <code>Cell</code> and gets its position
	 * @param posx is the x position of the cell
	 * @param posy is the y position of the cell
	 */
    public Cell(int posx, int posy) {
		this.posX = posx;
		this.posY = posy;
		}
    /**
     * Returns the x coordinate of the cell
     * @return <code>int</code> x coordinate of cell
     */
    public int getX() {
    	return posX;
    }
    /**
     * Returns the y coordinate of the cell 
     * @return <code>int</code> y coordinate of the cell
     */
    public int getY() {
    	return posY;
    }
}
