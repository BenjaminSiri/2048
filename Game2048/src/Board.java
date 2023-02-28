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
		for(int i=0; i < x; i++) {
			for(int j=0; j < y; j++) {
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
				if(i==1 && j==1) {
					table[i][j] = 1;
				}
				else {
					table[i][j] = 0;
				}
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
		// Iterate through each column
		// Move all elements to a stack
		// Parse through logic as we take out of the stack
		// Add new numbers
	}
	
	public void moveDown() {
		
	}
	
	public void moveRight() {
		
	}
	
	public void moveLeft() {
		
	}
	
	public void newNumbers() {
		
	}
	
	
	public String toString() {
		String out = "";
		for(int i=0; i < rowLength(); i++) {
			for(int j=0; j<colLength(); j++) {
				out += table[i][j];
			}
			out += '\n';
		}
		return out;
	}
}
