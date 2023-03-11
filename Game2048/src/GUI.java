import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GUI extends JFrame{
	
	private int spacing = 5;
	public Board board = new Board();
	
	public GUI() {
		this.setTitle("2048 test");
		this.setSize(400, 430);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);		
		
		Panel panel = new Panel(board.getTable());
		this.setContentPane(panel);
		
		Action action = new Action();
		this.addKeyListener(action);
	}
	
	public class Panel extends JPanel{
		int[][] grid;
				
		public Panel(int[][] grid) {
			this.grid = grid;
		}
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, 400, 400);
			g.setColor(Color.GRAY);
			int size = 90;
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					g.fillRect((spacing+i*size)+20, (spacing+j*size)+20, size-2*spacing, size-2*spacing);
					JLabel label = new JLabel(Integer.toString(grid[i][j]));
					label.setBounds((spacing+i*size)+20, (spacing+j*size)+20, size-2*spacing, size-2*spacing);
					this.add(label);
				}
			}
		}
	}
	
	public class Action implements KeyListener{
		
		@Override
		public void keyReleased(KeyEvent e) {
			board.input(e.getKeyChar());
		}
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
		
	}
}


















