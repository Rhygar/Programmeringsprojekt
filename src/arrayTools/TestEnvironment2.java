package arrayTools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestEnvironment2 extends JPanel {
	
	private JLabel[][] labels = new JLabel[7][7];
	private JLabel[] labelsW = new JLabel[7];	
	private JLabel[] labelsE = new JLabel[7];	
	
	private JButton btnLeft = new JButton("Left");
	private JButton btnRight = new JButton("Right");


	private Dimension block = new Dimension(40,40);		//size for all the JLabel components
	private Font font = new Font( "SansSerif", Font.BOLD, 30 );
	
	
	public TestEnvironment2() {
	
		//main test window size
		setPreferredSize(new Dimension(500,400));
		//choosing borderlayout to have one in west, south, east and center
		setLayout(new BorderLayout());
		
		//panel west, where the vertical Arrray7 is
		JPanel west = new JPanel();
		west.setPreferredSize(new Dimension(80, 400));
		west.setLayout(new GridLayout(7,1, 5, 5));
		west.setBorder(BorderFactory.createEmptyBorder(2,20,20,20));
		for (int i = 0; i < labelsW.length; i++) {
			labelsW[i] = new JLabel("");
			labelsW[i].setBackground(Color.RED);
			labelsW[i].setOpaque(true);
			labelsW[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelsW[i].setFont(font);			
			west.add(labelsW[i]);
		}
		
		//panel center, where the 7x7 array is
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(7,7, 5, 5));
		center.setBorder(BorderFactory.createEmptyBorder(2,20,20,20));
			for (int row = 0; row < labels.length; row++) {
				for (int col = 0; col < labels[row].length; col++) {
					labels[row][col] = new JLabel("");
					labels[row][col].setPreferredSize(block);
					labels[row][col].setBackground(Color.GRAY);
					labels[row][col].setOpaque(true);
					labels[row][col].setHorizontalAlignment(SwingConstants.CENTER);
					labels[row][col].setFont(font);
					center.add(labels[row][col]);
				}
			}
		
			
		//panel west, where the vertical Arrray7 is
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(80, 400));
		east.setLayout(new GridLayout(7,1, 5, 5));
		east.setBorder(BorderFactory.createEmptyBorder(2,20,20,20));
		for (int i = 0; i < labelsE.length; i++) {
			labelsE[i] = new JLabel("");
			labelsE[i].setBackground(Color.RED);
			labelsE[i].setOpaque(true);
			labelsE[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelsE[i].setFont(font);			
			east.add(labelsE[i]);
		}
		
		//panel south, where the horizontal Array7 is
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(500, 65));
		south.setLayout(new GridLayout(1,2, 5, 5));
		south.setBorder(BorderFactory.createEmptyBorder(20,100,5,92));
		south.add(btnLeft);
		south.add(btnRight);
		
			
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
	
	}
	
	private class AL implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	public static void main(String[] args) {
		TestEnvironment2 test = new TestEnvironment2();
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(test);
		frame.pack();
		frame.setVisible(true);
		
	}
}
