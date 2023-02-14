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
		for(x=0; x < 4; x++) {
			for(y=0; y < 4; y++) {
				table[x][y] = 0;
			}
		}
	}
	
	/**
	 * This default constructor instantiates
	 * a board with 4x4 dimensions. A standard
	 * 2048 board.
	 */
	public Board() {
		table = new int[4][4];
		for(int i=0; i < 4; i++) {
			for(int j=0; j < 4; j++) {
				table[i][j] = 0;
			}
		}
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
		for(int i=0; i < this.colLength()-1; i++) { //Bottom -> Up
			for(int j=0; j < this.rowLength(); j++) { //Left -> Right
				if(canMerge(i, j, i+1, j)) {
					merge(i, j, i+1, j);
				}
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
		int[][] currentTable = getTable();
		if(((currentTable[thisx][thisy] != 0 && currentTable[otherx][othery] != 0)
				&& (currentTable[thisx][thisy] == currentTable[otherx][othery]))
				|| (currentTable[thisx][thisy] == 0 && currentTable[otherx][othery] != 0)) {
			return true;
		}
		return false;
	}
	
	public void merge(int thisx, int thisy, int otherx, int othery) {
		int[][] currentTable = getTable();
		currentTable[thisx][thisy] = currentTable[thisx][thisy] * 2;
		
		currentTable[otherx][othery] = 0;
		
		table = currentTable;
	}
}
