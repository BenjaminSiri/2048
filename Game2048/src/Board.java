// 2-5-23
public class Board {
	private int[][] table;
	
	/**
	 * This constructor accepts two integers
	 * one for x and one for y. Specifying
	 * the dimensions for a 2048 board.
	 * @param x
	 * @param y
	 */
	public Board(int x, int y) {
		table = new int[x][y];
	}
	
	/**
	 * This default constructor instantiates
	 * a board with 4x4 dimensions. A standard
	 * 2048 board.
	 */
	public Board() {
		table = new int[4][4];
	}
	
	public int[][] getTable() {
		return table;
	}
	public int rowLength() {
		return this.getTable().length;
	}
	public int colLength() {
		return this.getTable()[0].length;
	}
	
	public void moveUp() {
		for(int i=0; i < this.colLength(); i++) { //Bottom -> Up
			for(int j=0; j < this.rowLength(); j++) { //Left -> Right
				
			}
		}
		
	}
	public void moveDown() {
		
	}
	public void moveRight() {
		
	}
	public void moveLeft() {
		
	}
	
	public void newNumbers() {
		
	}
	
	public boolean canMerge(int thisx, int thisy, int otherx, int othery) {
		return true;
	}
	
	public void merge(int thisx, int thisy, int otherx, int othery) {
		
	}
}
