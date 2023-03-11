import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GUI extends JFrame{
	
	public Panel panel;
		
	public GUI() {
		this.setTitle("2048 test");
		this.setSize(400, 430);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);		
		
		panel = new Panel();
		this.setContentPane(panel);
		this.addKeyListener(panel);
		
	}
	
	
	public class Panel extends JPanel implements KeyListener{
				
		public Board board = new Board();
		private int spacing = 5;
		
		public Panel() {
				
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			
			g2.setColor(Color.DARK_GRAY);
			g2.fillRect(0, 0, 400, 400);
			int size = 90;
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					g2.setColor(Color.GRAY);
					g2.fillRect((spacing+i*size)+20, (spacing+j*size)+20, size-2*spacing, size-2*spacing);
					g2.setColor(Color.BLACK);
					g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
					g2.drawString(Integer.toString(board.getTable()[j][i]), ((spacing+i*size))+(size/2), ((spacing+j*size)+20)+(size/2));
				}
			}
		}
		
			
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println(e.getKeyChar());
			board.input(e.getKeyChar());
			panel.repaint();
		}
			
		@Override
		public void keyTyped(KeyEvent e) {
				
		}
			
		@Override
		public void keyPressed(KeyEvent e) {
				
		}		
	}
}


















