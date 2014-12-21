package arrayTools;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JButton btnReadRow = new JButton("Läs rad");
	JButton btnWriteRow = new JButton("Skriv rad");
	JButton btnReadCol = new JButton("Läs kol");
	JButton btnWriteCol = new JButton("Skriv kol");
	JTextField tfRowNbr = new JTextField("Input rad nr");
	JTextField tfColNbr = new JTextField("Input kol nr");
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
		east.add(btnReadRow);
		east.add(btnWriteRow);
		east.add(tfRowNbr);
		east.add(btnReadCol);
		east.add(btnWriteCol);
		east.add(tfColNbr);
		
		
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
		btnReadRow.addActionListener(new AL());
		btnReadCol.addActionListener(new AL());
		btnWriteRow.addActionListener(new AL());
		btnWriteCol.addActionListener(new AL());
		
		labels[0][0].setText(nbr + "");
	}
	
	/**
	 * Sets values in a 7x7 JLabel
	 * @param array 7x7 int[][] with values
	 */
	public void set7x7Array(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				String value = array[i][j] + "";
				labels[i][j].setText(value);
			}
		}
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
	
	public int[] getRow(int row) {
		int[] array = new int[7];
		for(int col = 0; col < labels[row].length; col++) {
			array[col] = Integer.parseInt(labels[row][col].getText());
		}
		return array;
	}
	
	public int[] getCol(int col) {
		int[] array = new int[7];
		for(int row = 0; row < labels.length; row++) {
			array[row] = Integer.parseInt(labels[row][col].getText());
		}
		return array;
	}
	
	/**
	 * Changing the horizontal array
	 * @param arr 7 element array
	 */
	public void setHorizontalArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			String text = arr[i] + "";
			labelsS[i].setText(text);
		}
	}
	
	/**
	 * Changing the vertical array
	 * @param arr 7 element array
	 */
	public void setVerticalArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			String text = arr[i] + "";
			labelsW[i].setText(text);
		}
	}
	
	/**
	 * Returns the horizontal array
	 * @return array 7 int array
	 */
	public int[] getHorizontalArray() {
		int[] array = new int[7];
		for (int i = 0; i < labelsS.length; i++) {
			array[i] = Integer.parseInt(labelsS[i].getText());
		}
		return array; 
	}
	
	/**
	 * Returns the vertical array
	 * @return array 7 int array
	 */
	public int[] getVerticalArray() {
		int[] array = new int[7];
		for (int i = 0; i < labelsW.length; i++) {
			array[i] = Integer.parseInt(labelsW[i].getText());
		}
		return array;
	}
	
	
	public void readRow() {
		int[] array;
		array = getRow(Integer.parseInt(tfRowNbr.getText()));
		setHorizontalArray(array);
	}
	
	public void writeRow() {
		int[] array;
		int row;
		array = getHorizontalArray();
		row = Integer.parseInt(tfRowNbr.getText());
		changeRow(array, row);
	}
	
	public void readCol() {
		int[] array;
		array = getCol(Integer.parseInt(tfColNbr.getText()));
		setVerticalArray(array);
	}
	
	public void writeCol() {
		int[] array;
		int col;
		array = getVerticalArray();
		col = Integer.parseInt(tfRowNbr.getText());
		changeCol(array, col);
	}
	
	
	private class AL implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (btnReadRow == e.getSource()) {
				readRow();
			} else if (btnWriteRow == e.getSource()) {
				writeRow();
			} else if (btnReadCol == e.getSource()) {
				readCol();
			} else if (btnWriteCol == e.getSource()) {
				writeCol();
			}
			
		}
		
	}
	
	
	
	//main method to try and see the panel
	
	public static void main(String[] args) throws Exception {
		
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
		Array7x7 testArray = new Array7x7();
		Array7 testArr7 = new Array7();
		testArr7.setElement(3, 6);
		testArr7.setElement(5, 9);
		testArray.setElement(1, 1, 5);
		testArray.setCol(2, testArr7);
		testArray.setRow(1, testArr7);
		test.set7x7Array(testArray.getArray());
		test.setVerticalArray(testArr7.getArray());
		test.setVerticalArray(testArray.getCol(2).getArray());
		
		
	}
	 
}
