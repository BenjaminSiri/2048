import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String response;
		Board testboard = new Board();
		
		System.out.println("Do you want to play a game? (y/n)");
		response = scnr.nextLine();
		response = response.trim();
		
		if(response.equals("y")){
			testboard.newNumbers();
			System.out.println(testboard);
		}
		else {
			System.out.println("Closing...");
		}
		
		System.out.println("Make a move. (w/a/s/d)");
		response = scnr.nextLine();
		response = response.trim();
		
		while(response.equals("w") || response.equals("a") || response.equals("s")  || response.equals("d") ) {
			if(response.equals("w")) {
				testboard.moveUp();
			}
			else if(response.equals("a")) {
				testboard.moveLeft();
			}
			else if(response.equals("s")) {
				testboard.moveDown();
			}
			else if(response.equals("d")) {
				testboard.moveRight();
			}
			System.out.println(testboard);
			
			System.out.println("Make a move. (w/a/s/d)");
			response = scnr.nextLine();
			response = response.trim();
		}
		
		scnr.close();
	}
}
