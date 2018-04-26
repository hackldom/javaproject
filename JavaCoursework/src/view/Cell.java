package view;

public class Cell {
	protected int posX;
	protected int posY;

    public Cell(int posx, int posy) {
		this.posX = posx;
		this.posY = posy;
		}

    public int getX() {
    	return posX;
    }
    public int getY() {
    	return posY;
    }
    public void changeX(int c){
    	posX = posX+c;
    }
    public void changeY(int c){
    	posY = posY+c;
    }
    public String toString(){
    	String toReturn = ("(" + posX + ", " + posY + ")");
    	return toReturn;
    }
}
