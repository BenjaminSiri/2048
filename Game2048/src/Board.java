// 2-5-23
public class Board {
	private int[][] table;
	private int emptySpaces;
	
	/**
	 * This constructor accepts two integers
	 * one for x and one for y. Specifying
	 * the dimensions for a 2048 board.
	 * @param x
	 * @param y
	 */
	public Board(int x, int y) {
		emptySpaces = (x*y);
		table = new int[x][y];
		for(int i=0; i < x; i++) {
			for(int j=0; j < y; j++) {
				table[i][j] = 0;
			}
		}
	}
	
	/**
	 * This default constructor instantiates
	 * a board with 4x4 dimensions. A standard
	 * 2048 board.
	 */
	public Board() {
		emptySpaces = 16;
		table = new int[4][4];
		int count = 1;
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
	
	public int[][] transpose(int[][] input){
		int[][] out = new int[4][4];
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				out[j][i] = getTable()[i][j];
			}
		}
		return out;
	}
	
	public void moveUp() {
		Stack stack = new Stack();
		int[][] initial = getTable();
		// Iterate through each column
		for (int j=0; j<rowLength(); j++) {
			// Move all elements to a stack
			for (int i=colLength()-1; i>=0; i--) {
				if(table[i][j] != 0) {
					stack.push(table[i][j]);
					table[i][j] = 0;
				}
			}
			// Parse through logic as we take out of the stack
			int placeHolder = 0;
			while(!stack.empty()) {
				if(placeHolder == 0) {
					table[0][j] = stack.pop();
					placeHolder++;
				}
				else if(table[placeHolder-1][j] == stack.peek()) {
					table[placeHolder-1][j] = stack.pop()*2;
					emptySpaces++;
				}
				else {
					table[placeHolder][j] = stack.pop();
					placeHolder++;
				}
			}
		}
		newNumber();
	}
	
	public void moveDown() {
		Stack stack = new Stack();
		int[][] initial = getTable();
		// Iterate through each column
		for (int j=0; j<rowLength(); j++) {
			// Move all elements to a stack
			for (int i=0; i<colLength(); i++) {
				if(table[i][j] != 0) {
					stack.push(table[i][j]);
					table[i][j] = 0;
				}
			}
			// Parse through logic as we take out of the stack
			int placeHolder = colLength()-1;
			while(!stack.empty()) {
				if(placeHolder == colLength()-1) {
					table[placeHolder][j] = stack.pop();
					placeHolder--;
				}
				else if(table[placeHolder+1][j] == stack.peek()) {
					table[placeHolder+1][j] = stack.pop()*2;
					emptySpaces++;
				}
				else {
					table[placeHolder][j] = stack.pop();
					placeHolder--;
				}
			}
		}
		newNumber();
	}
	
	public void moveLeft() {
		Stack stack = new Stack();
		int[][] initial = getTable();
		// Iterate through each row
		for (int i=0; i<colLength(); i++) {
			// Move all elements to a stack
			for (int j=rowLength()-1; j>=0; j--) {
				if (table[i][j] != 0) {
					stack.push(table[i][j]);
					table[i][j] = 0;
				}
			}
			// Parse through logic as we take out of the stack
			int placeHolder = 0;
			while(!stack.empty()) {
				if(placeHolder == 0) {
					table[i][0] = stack.pop();
					placeHolder++;
				}
				else if(table[i][placeHolder-1] == stack.peek()) {
					table[i][placeHolder-1] = stack.pop()*2;
					emptySpaces++;
				}
				else {
					table[i][placeHolder] = stack.pop();
					placeHolder++;
				}
			}
		}		
		newNumber();
	}
	
	public void moveRight() {
		Stack stack = new Stack();
		int[][] initial = getTable();
		// Iterate through each row
		for (int i=0; i<colLength(); i++) {
			// Move all elements to a stack
			for (int j=0; j<rowLength(); j++) {
				if(table[i][j] != 0) {
					stack.push(table[i][j]);
					table[i][j] = 0;
				}
			}
			// Parse through logic as we take out of the stack
			int placeHolder = rowLength()-1;
			while(!stack.empty()) {
				if(placeHolder == rowLength()-1) {
					table[i][placeHolder] = stack.pop();
					placeHolder--;
				}
				else if(table[i][placeHolder+1] == stack.peek()) {
					table[i][placeHolder+1] = stack.pop()*2;
					emptySpaces++;
				}
				else {
					table[i][placeHolder] = stack.pop();
					placeHolder--;
				}
			}
		}
		newNumber();
	}
	
	public void newNumber() {
		int randomOne = (int)(Math.random() * emptySpaces);
		int remainingEmptySpaces = emptySpaces;
		boolean numberAddedCheck = false;
		for (int i=0; i < colLength(); i++) {
			for (int j=0; j < rowLength(); j++) {
				if(table[i][j] == 0) {
					remainingEmptySpaces--;
					if(remainingEmptySpaces == randomOne) {
						table[i][j] = 2;
						emptySpaces--;
						numberAddedCheck = true;
					}
				}
			}
		}
		if(!numberAddedCheck) {
			System.out.println("NO NUMBER ADDED!!!");
		}
	}
	
	public void input(char key) {
		if (key == 'w') {
			this.moveUp();
		}
		else if (key == 's') {
			this.moveDown();
		}
		else if (key == 'a') {
			this.moveLeft();
		}
		else if (key == 'd') {
			this.moveRight();
		}
	}
	
	public void restart() {
		for(int i=0; i < colLength(); i++) {
			for(int j=0; j < rowLength(); j++) {
				table[i][j] = 0;
			}
		}
	}
	
	
	public String toString() {
		String out = "";
		for(int i=0; i < colLength(); i++) {
			for(int j=0; j < rowLength(); j++) {
				out += table[i][j];
			}
			out += '\n';
		}
		return out;
	}
}
