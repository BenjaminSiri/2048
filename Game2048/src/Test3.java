import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Test3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("2048 Test");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
