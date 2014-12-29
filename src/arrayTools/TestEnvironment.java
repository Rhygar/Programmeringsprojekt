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
public class TestEnvironment extends JPanel {

	private JLabel[][] labels = new JLabel[7][7];		//Jlabel components for the 7x7 array. Goes in center
	private JLabel[] labelsW = new JLabel[7];			//JLabel components for the array[7]. Goes in west
	private JLabel[] labelsS = new JLabel[7];			//JLabel components for the array[7]. Goes in south
	private JButton btnReadRow = new JButton("Läs rad");
	private JButton btnWriteRow = new JButton("Skriv rad");
	private JButton btnReadCol = new JButton("Läs kol");
	private JButton btnWriteCol = new JButton("Skriv kol");
	private JTextField tfRowNbr = new JTextField("Input rad nr");
	private JTextField tfColNbr = new JTextField("Input kol nr");
	private Dimension block = new Dimension(40,40);		//size for all the JLabel components 
	
	private Font font = new Font( "SansSerif", Font.BOLD, 30 );
	
	
	public TestEnvironment() {
		
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
		//adding components to the panel		
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		
		//the buttons listens to clicks
		btnReadRow.addActionListener(new AL());
		btnReadCol.addActionListener(new AL());
		btnWriteRow.addActionListener(new AL());
		btnWriteCol.addActionListener(new AL());
	}
	
	/**
	 * Sets values in a 7x7 JLabel
	 * @param array 7x7 int[][] with values
	 */
	public void set7x7ArrayInt(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				String value = array[i][j] + "";
				labels[i][j].setText(value);
			}
		}
	}	
	
	/**
	 * Sets values in TestEnvironment from Array7x7 object.
	 * @param arr Array7x7 object
	 */
	public void setArray7x7(Array7x7 arr) {
		set7x7ArrayInt(arr.getArray());
	}
	
	/**
	 * Changing specified row in the TestEnvironment
	 * @param array int[] array with 7 elements
	 * @param row this row will be modified. Start from 0 
	 */
	public void TESetRow(int[] array, int row) {
		for(int col = 0; col < labels[row].length; col++) {
			labels[row][col].setText(array[col] + "");
		}
	}
	
	/**
	 * Changing specified column in the TestEnvironment
	 * @param array int[] array with 7 elements
	 * @param col this column will be modified. Start from 0
	 */
	public void TESetCol(int[] array, int col) {
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
		int[] array = new int[7];
		for(int i = 0; i < 7; i++) {
			int c = Integer.parseInt(JOptionPane.showInputDialog("Tal " + (i+1) + " av 7 (Mindre än 10!)" ));
			array[i] = c;
		}
		setHorizontalArray(array);
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
		TESetCol(array, col);
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
	
	public static void main (String[] args) {
		TestEnvironment run = new TestEnvironment();
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(run);
		frame.pack();
		frame.setVisible(true);
		
	}
}
