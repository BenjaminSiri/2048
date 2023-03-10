import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Test3 implements Runnable{
	
	GUI gui = new GUI();
	
	public static void main(String[] args) {
		new Thread(new Test3()).start();
		
	}
	
	@Override
	public void run() {
		while(true) {
			gui.repaint();
		}
	}
	
	
}
