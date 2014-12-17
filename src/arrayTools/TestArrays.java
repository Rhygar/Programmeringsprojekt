package arrayTools;

import java.awt.*;
import javax.swing.*;

/**
 * <<<<<< CLASS UNDER CONSTRUCTION >>>>>>
 * Test environment to test different set and get methods using arrays 
 * @author David Tran
 *
 */
public class TestArrays extends JPanel {

	JLabel[][] labels = new JLabel[7][7];		//Jlabel components for the 7x7 array. Goes in center
	JLabel[] labelsW = new JLabel[7];			//JLabel components for the array[7]. Goes in west
	JLabel[] labelsS = new JLabel[7];			//JLabel components for the array[7]. Goes in south
	Dimension block = new Dimension(40,40);		//size for all the JLabel components 
	private Font font = new Font( "SansSerif", Font.BOLD, 30 );
	private int nbr = 4;						//just a test for using varibels to change the text in labels
	
	
	public TestArrays() {
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
		
		//panel south, where the horizontal Array7 is
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(500, 65));
		south.setLayout(new GridLayout(1,7, 5, 5));
		south.setBorder(BorderFactory.createEmptyBorder(20,100,5,92));
		for (int i = 0; i < labelsS.length; i++) {
			labelsS[i] = new JLabel("");
			labelsS[i].setBackground(Color.BLUE);
			labelsS[i].setOpaque(true);
			labelsS[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelsS[i].setFont(font);
			south.add(labelsS[i]);
		}
			
		//panel east, where the buttons are
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(90, 400));
		
		//panel center, where the 7x7 array is
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(7,7, 5, 5));
		center.setBorder(BorderFactory.createEmptyBorder(2,20,20,2));
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
		
		
		
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		labels[0][0].setText(nbr + "");
	}
	
	/**
	 * Changing specified row in the 7x7 array
	 * @param array array with 7 elements
	 * @param row this row will be modified. Start from 0 
	 */
	public void changeRow(int[] array, int row) {
		for(int col = 0; col < labels[row].length; col++) {
			labels[row][col].setText(array[col] + "");
		}
	}
	
	/**
	 * Changing specified column in the 7x7 array
	 * @param array array with 7 elements
	 * @param col this column will be modified. Start from 0
	 */
	public void changeCol(int[] array, int col) {
		for(int row = 0; row < labels.length; row++) {
			labels[row][col].setText(array[row] + "");
		}
	}
	
	
	//main method to try and see the panel
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TestArrays test = new TestArrays();
		frame.add(test);
		int[] array = {1,2,3,4,5,6,7};
		test.changeRow(array, 0);
		test.changeCol(array, 0);
		frame.add(test);
		
		frame.pack();
		frame.setVisible(true);
	}
	 
}
