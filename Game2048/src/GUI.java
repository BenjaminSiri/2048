import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GUI extends JFrame{
	
	public Panel panel;
	
	public JButton startButton;
	public JButton restartButton;
	
	public JLabel score;
		
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
			
			//board.newNumber();
			
			g2.setColor(Color.DARK_GRAY);
			g2.fillRect(0, 0, 400, 400);
			int size = 90;
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					int scale = (int)(Math.log(board.getTable()[j][i]) / Math.log(2));
					scale = scale - 2;
					if (board.getTable()[j][i] == 2) {
						g2.setColor(Color.LIGHT_GRAY);
					}
					else if (board.getTable()[j][i] == 0){
						g2.setColor(Color.GRAY);
					}
					else if (scale <= 6){
						g2.setColor(new Color((240+(scale))%255, (240-(40*scale))%255, (150-(20*scale))%255));		
					}
					else if (scale <= 14) {
						scale = scale-7;
						g2.setColor(new Color((240-(30*scale))%255, (60-(10*scale))%255, (180+(10*scale))%255));
					}
					g2.fillRect((spacing+i*size)+20, (spacing+j*size)+20, size-2*spacing, size-2*spacing);
					g2.setColor(Color.BLACK);
					g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
					g2.drawString(Integer.toString(board.getTable()[j][i]), ((spacing+i*size))+(size/2), ((spacing+j*size)+20)+(size/2));
				}
			}
		}
		
			
		@Override
		public void keyReleased(KeyEvent e) {
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


















