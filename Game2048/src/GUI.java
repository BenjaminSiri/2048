import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GUI extends JFrame{
	
	private static int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	
	public Board board = new Board();
	
	public Panel panel;
	public JPanel topPanel;
	
	public JButton startButton;
	public JButton restartButton;
	
	public JLabel score;
		
	public GUI() {
		this.setTitle("2048 test");
		this.setSize(400, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		topPanel = new JPanel(new FlowLayout());
		topPanel.setBackground(Color.DARK_GRAY);
		startButton = new JButton("Start");
		restartButton = new JButton("Restart");
		topPanel.add(startButton);
		topPanel.add(restartButton);
		add(topPanel, BorderLayout.NORTH);
		
		panel = new Panel();
		add(panel, BorderLayout.CENTER);
		
		panel.getInputMap(IFW).put(KeyStroke.getKeyStroke("W"), "up");
		panel.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), "left");
		panel.getInputMap(IFW).put(KeyStroke.getKeyStroke("S"), "down");
		panel.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), "right");
		
		panel.getActionMap().put("up", new MoveAction("up"));
		panel.getActionMap().put("left", new MoveAction("up"));
		panel.getActionMap().put("down", new MoveAction("up"));
		panel.getActionMap().put("right", new MoveAction("up"));
	}
	
	private class MoveAction extends AbstractAction {
		String action;
		
		MoveAction(String action){
			this.action = action;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			board.input(e.getActionCommand().charAt(0));
			panel.repaint();
		}
	}
	
	
	private class Panel extends JPanel{
				
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
	}		
}


















