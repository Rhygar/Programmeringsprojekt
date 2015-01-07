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
	
	private Array7 arr7s;
	private Array7 arr7w;
	private Array7x7 arr77;

	private JLabel[][] labels = new JLabel[7][7];		//Jlabel components for the 7x7 array. Goes in center
	private JLabel[] labelsW = new JLabel[7];			//JLabel components for the array[7]. Goes in west
	private JLabel[] labelsS = new JLabel[7];			//JLabel components for the array[7]. Goes in south
	private JButton btnReadRow = new JButton("Läs rad");
	private JButton btnWriteRow = new JButton("Skriv rad");
	private JButton btnReadCol = new JButton("Läs kol");
	private JButton btnWriteCol = new JButton("Skriv kol");
	private JButton btnModRow = new JButton("Mod Row");
	private JButton btnModCol = new JButton("Mod Col");
	private JTextField tfRowNbr = new JTextField("Input rad nr");
	private JTextField tfColNbr = new JTextField("Input kol nr");
	private Dimension block = new Dimension(40,40);		//size for all the JLabel components 
	
	private Font font = new Font( "SansSerif", Font.BOLD, 30 );
	
	
	public TestEnvironment(Array7x7 arr77) {
		
		this.arr77 = arr77;
		
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
		east.add(btnModRow);
		east.add(btnModCol);
		
		
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
		btnModRow.addActionListener(new AL());
		btnModCol.addActionListener(new AL());
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
				if (labels[i][j].getText().equals("1")) {
					labels[i][j].setBackground(Color.BLACK);
				} else if (labels[i][j].getText().equals("0")) {
					labels[i][j].setBackground(Color.RED);
					labels[i][j].setForeground(Color.RED);
				}
			}
		}
	}	
	
	public void setArray7w(int[] array) {
		for(int i = 0; i < 7; i++) {
			labelsW[i].setText(array[i] + "");
		}
	}
	
	public void setArray7s(int[] array) {
		for(int i = 0; i < 7; i++) {
			labelsS[i].setText(array[i] + "");
		}
	}
	
	/**
	 * Sets values in TestEnvironment from Array7x7 object.
	 * @param arr Array7x7 object
	 */
	public void update() {
		set7x7ArrayInt(arr77.getArray());
//		setArray7w(arr7w.getArray());
//		setArray7s(arr7s.getArray());
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
	 * @param arr Array7 object
	 */
	public void setHorizontalArray(Array7 arr) {
		for (int i = 0; i < 7; i++) {
			String text = arr.getElement(i) + "";
			labelsS[i].setText(text);
		}
	}
	
	/**
	 * Changing the vertical array
	 * @param arr Array7 object
	 */
	public void setVerticalArray(Array7 arr) {
		for (int i = 0; i < 7; i++) {
			String text = arr.getElement(i) + "";
			labelsW[i].setText(text);
		}
	}
	
	/**
	 * Returns the horizontal array
	 * @return arr7s Array7 object
	 */
	public Array7 getHorizontalArray() {
		return arr7s;
	}
	
	
	/**
	 * Returns the vertical array
	 * @return arr7w Array7 object
	 */
	public Array7 getVerticalArray() {
		return arr7w;
	}
	
	
	public void readRow() throws Exception {
		int rowNbr = Integer.parseInt(tfRowNbr.getText());
		arr7s = arr77.getRow(rowNbr);
		setHorizontalArray(arr7s);
	}
	
	public void writeRow() {
		int rowNbr = Integer.parseInt(tfRowNbr.getText());
		arr77.setRow(rowNbr, arr7s);
		update();
	}
	
	public void modifyRow() {
		int[] array = new int[7];
		Array7 arr = new Array7();
		for(int i = 0; i < 7; i++) {
			int c = Integer.parseInt(JOptionPane.showInputDialog("Tal " + (i+1) + " av 7 (Mindre än 10!)" ));
			array[i] = c;
		}
		for(int i = 0; i < 7; i++) {
//			arr.setElement(i, array[i]);
			arr7s.setElement(i, array[i]);
		}
		setHorizontalArray(arr7s);
		update();
	}

	
	public void readCol() throws Exception {
		int colNbr = Integer.parseInt(tfColNbr.getText());
		arr7w = arr77.getCol(colNbr);
		setVerticalArray(arr7w);
	}
	
	public void writeCol() {
		int colNbr = Integer.parseInt(tfRowNbr.getText());
		arr77.setCol(colNbr, arr7w);
		update();
	}
		
	
	public void modifyCol() {
		int[] array = new int[7];
		Array7 arr = new Array7();
		for(int i = 0; i < 7; i++) {
			int c = Integer.parseInt(JOptionPane.showInputDialog("Tal " + (i+1) + " av 7 (Mindre än 10!)" ));
			array[i] = c;
		}
		for(int i = 0; i < 7; i++) {
			arr7w.setElement(i, array[i]);
		}
		setVerticalArray(arr7w);
	}
	
	
	private class AL implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (btnReadRow == e.getSource()) {
				try {
					readRow();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (btnWriteRow == e.getSource()) {
				writeRow();
			} else if (btnReadCol == e.getSource()) {
				try {
					readCol();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (btnWriteCol == e.getSource()) {
				writeCol();
			} else if (btnModRow == e.getSource()) {
				modifyRow();
			} else if (btnModCol == e.getSource()) {
				modifyCol();
			}
			
		}
	}
	
	public static void main (String[] args) throws Exception {
//		ArrayChars chars = new ArrayChars();
		
		
		int arr [][] ={{1,2,3,4,5,6,7},
					{8,9,10,11,12,13,14},
					{15,16,17,18,19,20,21},
					{22,23,24,25,26,27,28},
					{29,30,31,32,33,34,35},
					{36,37,38,39,40,41,42},
					{43,44,45,46,47,48,49}};
		
		int arr2 [] = {2,9,1,4,8,6,7};
		
		Array7 arr1 = new Array7 (arr2);
		Array7x7 arr7 = new Array7x7(arr);
		
		TestEnvironment run = new TestEnvironment(arr7);
		
//		arr7.setElement(0, 3, 3);
//		arr7.setRow(1,arr1.getArray());
		run.set7x7ArrayInt(arr7.getArray());
		JFrame frame = new JFrame("Test Arrays");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		run.update();
		frame.add(run);
		frame.pack();
		frame.setVisible(true);
		
	}
}